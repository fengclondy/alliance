package com.ai.aso.common.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.aso.common.param.AttributeSet;
import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.db.dao.ContbookRecordMapper;
import com.ai.aso.common.db.dao.ContractBookMapper;
import com.ai.aso.common.db.model.ContbookRecord;
import com.ai.aso.common.db.model.ContractBook;
import com.ai.aso.common.db.model.ContractBookExample;
import com.ai.aso.common.service.ContractBookRecordService;
import com.ai.aso.common.service.ContractBookService;
import com.ai.aso.common.sequence.SequenceFactory;

@Service
public class ContractBookServiceImpl implements ContractBookService {
	
	@Autowired
	private ContractBookMapper contractBookMapper;
	@Autowired
	private ContbookRecordMapper contbookRecordMapper;
	@Autowired
	private SequenceFactory sequenceFactory;
	@Autowired
	private ContractBookRecordService contractBookRecordService;
	

	@Override
	public void addContractBook(List<ContractBook> bookList) {
		for (ContractBook book : bookList) {
			book.setBookId(sequenceFactory.next(BizConstants.SEQUENCENAME_BOOK));
			book.setState(GlobalParamSet.getInteger(BizConstants.CONTRACT_BOOK_STATE_NORMAL));
			book.setVer(1L);
			contractBookMapper.insertSelective(book);
			
			ContbookRecord cbr = new ContbookRecord();
			cbr.setBookId(book.getBookId());
			cbr.setLockVal(1L);
			cbr.setOperAmount(book.getAmount());
			cbr.setOperComm("新建" + AttributeSet.getAttrGroup(BizConstants.ATTR_CONTRACT_BOOK_TYPE).getName(String.valueOf(book.getBookType())));
			cbr.setOperDate(new Date());
			cbr.setOperType(GlobalParamSet.getShort(BizConstants.CONT_BOOK_RECORD_OPER_TYPE_IN));
			
			contbookRecordMapper.insertSelective(cbr);
		}
		
	}


	@Override
	public long findDeposit(String contId) {
		ContractBookExample example = new ContractBookExample();
		example.createCriteria().andContIdEqualTo(contId).andBookTypeEqualTo(GlobalParamSet.getShort(BizConstants.CONTRACT_BOOK_TYPE_DEPOSIT));
		List<ContractBook> bookList = contractBookMapper.selectByExample(example);
		
		assert (bookList != null && bookList.size() == 1);
		
		return bookList.get(0).getAmount();
	}


	@Override
	public long findCredit(String contId) {
		ContractBookExample example = new ContractBookExample();
		example.createCriteria().andContIdEqualTo(contId).andBookTypeEqualTo(GlobalParamSet.getShort(BizConstants.CONTRACT_BOOK_TYPE_CREDIT));
		List<ContractBook> bookList = contractBookMapper.selectByExample(example);
		
		assert (bookList != null && bookList.size() == 1);
		
		return bookList.get(0).getAmount();
	}


	@Override
	public long findPayment(String contId) {
		ContractBookExample example = new ContractBookExample();
		example.createCriteria().andContIdEqualTo(contId).andBookTypeEqualTo(GlobalParamSet.getShort(BizConstants.CONTRACT_BOOK_TYPE_PAYMENT));
		List<ContractBook> bookList = contractBookMapper.selectByExample(example);
		
		assert (bookList != null && bookList.size() == 1);
		
		return bookList.get(0).getAmount();
	}


	@Override
	@Transactional
	public int transferDeposit(String contId, long amount) {
		ContractBookExample example = new ContractBookExample();
		example.createCriteria().andContIdEqualTo(contId).andBookTypeEqualTo(GlobalParamSet.getShort(BizConstants.CONTRACT_BOOK_TYPE_DEPOSIT));
		List<ContractBook> bookList = contractBookMapper.selectByExample(example);
		
		assert (bookList != null && bookList.size() == 1);
		
		ContractBook deposit = bookList.get(0);
		
		long curVer = deposit.getVer();
		
		deposit.setAmount(deposit.getAmount() - amount);
		deposit.setVer(curVer+1);
		
		ContractBookExample locker = new ContractBookExample();
		locker.createCriteria().andBookIdEqualTo(deposit.getBookId()).andVerEqualTo(curVer);
		int rs = contractBookMapper.updateByExampleSelective(deposit, locker);
		
		
		
		ContractBookExample payEx = new ContractBookExample();
		payEx.createCriteria().andContIdEqualTo(contId).andBookTypeEqualTo(GlobalParamSet.getShort(BizConstants.CONTRACT_BOOK_TYPE_PAYMENT));
		bookList = contractBookMapper.selectByExample(payEx);
		
		assert (bookList != null && bookList.size() == 1);
		
		ContractBook payment = bookList.get(0);
		curVer = payment.getVer();
		payment.setAmount(payment.getAmount() + amount);
		payment.setVer(curVer+1);
		
		locker = new ContractBookExample();
		locker.createCriteria().andBookIdEqualTo(payment.getBookId()).andVerEqualTo(curVer);
		rs += contractBookMapper.updateByExampleSelective(payment, locker);
		
		rs += contractBookRecordService.transferDeposit(contId, amount);
		
		return rs;
	}


	@Override
	public int overdraft(String contId, long amount) {
		ContractBookExample example = new ContractBookExample();
		example.createCriteria().andContIdEqualTo(contId).andBookTypeEqualTo(GlobalParamSet.getShort(BizConstants.CONTRACT_BOOK_TYPE_CREDIT));
		List<ContractBook> bookList = contractBookMapper.selectByExample(example);
		
		assert (bookList != null && bookList.size() == 1);
		
		ContractBook credit = bookList.get(0);
		
		long curVer = credit.getVer();
		
		credit.setAmount(credit.getAmount() + amount);
		credit.setVer(curVer+1);
		
		ContractBookExample locker = new ContractBookExample();
		locker.createCriteria().andBookIdEqualTo(credit.getBookId()).andVerEqualTo(curVer);
		int rs = contractBookMapper.updateByExampleSelective(credit, locker);
		
		rs += contractBookRecordService.overdraft(contId, amount);
		
		return rs;
	}
}
