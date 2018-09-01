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

@Service
public class ContractBookRecordServiceImpl implements ContractBookRecordService {
	@Autowired
	private ContractBookMapper contractBookMapper;
	@Autowired
	private ContbookRecordMapper contbookRecordMapper;

	@Override
	@Transactional
	public int transferDeposit(String contId, long amount) {
		ContractBookExample example = new ContractBookExample();
		example.createCriteria().andContIdEqualTo(contId).andBookTypeEqualTo(GlobalParamSet.getShort(BizConstants.CONTRACT_BOOK_TYPE_DEPOSIT));
		List<ContractBook> bookList = contractBookMapper.selectByExample(example);
		
		assert (bookList != null && bookList.size() == 1);
		
		ContractBook deposit = bookList.get(0);
		
		ContbookRecord cbr = new ContbookRecord();
		cbr.setBookId(deposit.getBookId());
		cbr.setLockVal(1L);
		cbr.setOperAmount(0 - amount);//转出
		cbr.setOperComm(AttributeSet.getAttrGroup(BizConstants.ATTR_CONTRACT_BOOK_TYPE).getName(String.valueOf(deposit.getBookType())) + " - 转存：" + amount);
		cbr.setOperDate(new Date());
		cbr.setOperType(GlobalParamSet.getShort(BizConstants.CONT_BOOK_RECORD_OPER_TYPE_OUT));
		
		int rs = contbookRecordMapper.insertSelective(cbr);
		
		ContractBookExample payEx = new ContractBookExample();
		payEx.createCriteria().andContIdEqualTo(contId).andBookTypeEqualTo(GlobalParamSet.getShort(BizConstants.CONTRACT_BOOK_TYPE_PAYMENT));
		bookList = contractBookMapper.selectByExample(payEx);
		
		assert (bookList != null && bookList.size() == 1);
		
		ContractBook payment = bookList.get(0);
		
		cbr = new ContbookRecord();
		cbr.setBookId(payment.getBookId());
		cbr.setLockVal(1L);
		cbr.setOperAmount(amount);//转入
		cbr.setOperComm(AttributeSet.getAttrGroup(BizConstants.ATTR_CONTRACT_BOOK_TYPE).getName(String.valueOf(payment.getBookType())) + " - 转入：" + amount);
		cbr.setOperDate(new Date());
		cbr.setOperType(GlobalParamSet.getShort(BizConstants.CONT_BOOK_RECORD_OPER_TYPE_IN));
		
		rs += contbookRecordMapper.insertSelective(cbr);
		
		return rs;
	}

	@Override
	public int overdraft(String contId, long amount) {
		ContractBookExample example = new ContractBookExample();
		example.createCriteria().andContIdEqualTo(contId).andBookTypeEqualTo(GlobalParamSet.getShort(BizConstants.CONTRACT_BOOK_TYPE_CREDIT));
		List<ContractBook> bookList = contractBookMapper.selectByExample(example);
		
		assert (bookList != null && bookList.size() == 1);
		
		ContractBook deposit = bookList.get(0);
		
		ContbookRecord cbr = new ContbookRecord();
		cbr.setBookId(deposit.getBookId());
		cbr.setLockVal(1L);
		cbr.setOperAmount(amount);//追加额度
		cbr.setOperComm(AttributeSet.getAttrGroup(BizConstants.ATTR_CONTRACT_BOOK_TYPE).getName(String.valueOf(deposit.getBookType())) + " - 透支：" + amount);
		cbr.setOperDate(new Date());
		cbr.setOperType(GlobalParamSet.getShort(BizConstants.CONT_BOOK_RECORD_OPER_TYPE_IN));
		
		int rs = contbookRecordMapper.insertSelective(cbr);
		
		return rs;

	}

}
