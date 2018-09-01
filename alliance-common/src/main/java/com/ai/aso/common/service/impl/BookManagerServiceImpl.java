package com.ai.aso.common.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.aso.common.param.AttributeSet;
import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.base.utils.StringUtil;
import com.ai.aso.common.bo.ContractBookBo;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.db.dao.ContbookRecordMapper;
import com.ai.aso.common.db.dao.ContractBookMapper;
import com.ai.aso.common.db.dao.DataAccountMapper;
import com.ai.aso.common.db.dao.DataBookaMapper;
import com.ai.aso.common.db.model.ContbookRecord;
import com.ai.aso.common.db.model.Contract;
import com.ai.aso.common.db.model.ContractBook;
import com.ai.aso.common.db.model.ContractBookExample;
import com.ai.aso.common.db.model.ContractBookExample.Criteria;
import com.ai.aso.common.db.model.DataAccount;
import com.ai.aso.common.db.model.DataBooka;
import com.ai.aso.common.exception.ContBookValidException;
import com.ai.aso.common.service.BookManagerService;
import com.ai.aso.common.sequence.SequenceFactory;

/**
 * 账本管理
 * <p>
 * Description:
 * </p>
 *
 * @author liuwu
 * @date 2016年9月28日
 *
 */
@Service
public class BookManagerServiceImpl implements BookManagerService {
	
	@Autowired
	private ContractBookMapper contractBookMapper;
	@Autowired
	private ContbookRecordMapper contbookRecordMapper;
	@Autowired
	private SequenceFactory sequenceFactory;
	@Autowired
	private DataBookaMapper dataBookaMapper;
	@Autowired
	private DataAccountMapper dataAccountMapper;
	@Override
	@Transactional
	public String PaymentBookIncome(String amount, ContractBookBo bo) {
		// 合法性校验
		String bookType = GlobalParamSet.getString(BizConstants.CONTRACT_BOOK_TYPE_PAYMENT);
		if (StringUtil.isEmpty(bookType)) {
			bookType = "200";
		}
		authContBook(bo, bookType);
		// 存入账户表
		ContractBook contractBook = bo.toContractBook();

		contractBook.setAmount(Long.parseLong(amount));


		// 存入账户流水表
		ContbookRecord record = new ContbookRecord();
		String id = sequenceFactory.next(BizConstants.SEQUENCENAME_BOOK);
		record.setId(Long.parseLong(id));
		record.setBookId(contractBook.getBookId());
		record.setOperAmount(Long.parseLong(amount));
		record.setOperComm("支付流水收入");
		record.setOperDate(new Date());
		record.setOperType(Short.parseShort("100"));
		// record.setOperSubType(operSubType);
		contbookRecordMapper.insertSelective(record);
		contractBookMapper.updateByPrimaryKeySelective(contractBook);
		return contractBook.getBookId();

	}

	@Override
	@Transactional
	public String PaymentBookPay(String amount, ContractBookBo bo) {
		// 合法性校验
		String bookType = GlobalParamSet.getString(BizConstants.CONTRACT_BOOK_TYPE_PAYMENT);
		if (StringUtil.isEmpty(bookType)) {
			bookType = "200";
		}
		authContBook(bo, bookType);
		// 存入账户表
		ContractBook contractBook = bo.toContractBook();
		contractBook.setAmount(Long.parseLong(amount));

		// 存入账户流水表
		ContbookRecord record = new ContbookRecord();
		String id = sequenceFactory.next(BizConstants.SEQUENCENAME_BOOKRECORD);
		record.setId(Long.parseLong(id));
		record.setBookId(contractBook.getBookId());
		record.setOperAmount(Long.parseLong(amount));
		record.setOperComm("支付流水支出");
		record.setOperDate(new Date());
		record.setOperType(Short.parseShort("200"));
		// record.setOperSubType(operSubType);
		contbookRecordMapper.insertSelective(record);
		contractBookMapper.updateByPrimaryKeySelective(contractBook);
		return contractBook.getBookId();
	}

	@Override
	@Transactional
	public String DepositBookIncome(String amount, ContractBookBo bo) {
		// 合法性校验
		String bookType = GlobalParamSet.getString(BizConstants.CONTRACT_BOOK_TYPE_DEPOSIT);
		if (StringUtil.isEmpty(bookType)) {
			bookType = "100";
		}
		authContBook(bo, bookType);
		// 存入账户表
		ContractBook contractBook = bo.toContractBook();
		contractBook.setAmount(Long.parseLong(amount));

		// 存入账户流水表
		ContbookRecord record = new ContbookRecord();
		String id = sequenceFactory.next(BizConstants.SEQUENCENAME_BOOKRECORD);
		record.setId(Long.parseLong(id));
		record.setBookId(contractBook.getBookId());
		record.setOperAmount(Long.parseLong(amount));
		record.setOperComm("保证金收入");
		record.setOperDate(new Date());
		record.setOperType(Short.parseShort("100"));
		// record.setOperSubType(operSubType);
		contbookRecordMapper.insertSelective(record);
		contractBookMapper.updateByPrimaryKeySelective(contractBook);
		return contractBook.getBookId();
	}

	@Override
	@Transactional
	public String DepositBookPay(String amount, ContractBookBo bo) {
		// 合法性校验
		String bookType = GlobalParamSet.getString(BizConstants.CONTRACT_BOOK_TYPE_DEPOSIT);
		if (StringUtil.isEmpty(bookType)) {
			bookType = "100";
		}
		hasContBook(bo, bookType);
		// 存入账户表
		ContractBook contractBook = bo.toContractBook();
		String bookId = sequenceFactory.next(BizConstants.SEQUENCENAME_BOOK);
		contractBook.setBookId(bookId);
		contractBook.setBookType(Short.parseShort(GlobalParamSet.getString(BizConstants.CONTRACT_BOOK_TYPE_DEPOSIT)));
		contractBook.setAmount(Long.parseLong(amount));
		contractBook.setEffDate(new Date());
		contractBook.setVer(1L);
		// 存入账户流水表
		ContbookRecord record = new ContbookRecord();
		String id = sequenceFactory.next(BizConstants.SEQUENCENAME_BOOKRECORD);
		record.setId(Long.parseLong(id));
		record.setBookId(bookId);
		record.setOperAmount(Long.parseLong(amount));
		record.setOperComm("透支支出");
		record.setOperDate(new Date());
		record.setOperType(Short.parseShort("200"));
		// record.setOperSubType(operSubType);
		contractBookMapper.insertSelective(contractBook);
		contbookRecordMapper.insertSelective(record);
		return bookId;
	}

	@Override
	@Transactional
	public String creditBookPay(String amount, ContractBookBo bo) {
		// 合法性校验
		String bookType =GlobalParamSet.getString(BizConstants.CONTRACT_BOOK_TYPE_CREDIT);
		if (StringUtil.isEmpty(bookType)) {
			bookType = "300";
		}
		authContBook(bo, bookType);
		// 存入账户表
		ContractBook contractBook = bo.toContractBook();
		contractBook.setAmount(Long.parseLong(amount));

		// 存入账户流水表
		ContbookRecord record = new ContbookRecord();
		String id = sequenceFactory.next(BizConstants.SEQUENCENAME_BOOKRECORD);
		record.setId(Long.parseLong(id));
		record.setBookId(contractBook.getBookId());
		record.setOperAmount(Long.parseLong(amount));
		record.setOperComm("保证金支出");
		record.setOperDate(new Date());
		record.setOperType(Short.parseShort("100"));
		// record.setOperSubType(operSubType);
		contbookRecordMapper.insertSelective(record);
		contractBookMapper.updateByPrimaryKeySelective(contractBook);
		return contractBook.getBookId();
	}

	@Override
	@Transactional
	public String creditBookIncome(String amount, ContractBookBo bo) {
		// 合法性校验
		String bookType = GlobalParamSet.getString(BizConstants.CONTRACT_BOOK_TYPE_CREDIT);
		if (StringUtil.isEmpty(bookType)) {
			bookType = "300";
		}
		authContBook(bo, bookType);
		// 存入账户表
		ContractBook contractBook = bo.toContractBook();
		contractBook.setAmount(Long.parseLong(amount));

		// 存入账户流水表
		ContbookRecord record = new ContbookRecord();
		String id = sequenceFactory.next(BizConstants.SEQUENCENAME_BOOKRECORD);
		record.setId(Long.parseLong(id));
		record.setBookId(contractBook.getBookId());
		record.setOperAmount(Long.parseLong(amount));
		record.setOperComm("信用收入");
		record.setOperDate(new Date());
		record.setOperType(Short.parseShort("100"));
		// record.setOperSubType(operSubType);
		contbookRecordMapper.insertSelective(record);
		contractBookMapper.updateByPrimaryKeySelective(contractBook);
		return contractBook.getBookId();
	}

	@Override
	public String PaymentBookOpen(String amount, ContractBookBo bo) {
		// 合法性校验
		String bookType = GlobalParamSet.getString(BizConstants.CONTRACT_BOOK_TYPE_PAYMENT);
		if (StringUtil.isEmpty(bookType)) {
			bookType = "200";
		}
		hasContBook(bo, bookType);
		ContractBook contractBook = bo.toContractBook();
		// 存入账户表
		String bookId = sequenceFactory.next(BizConstants.SEQUENCENAME_BOOK);
		contractBook.setBookId(bookId);
		contractBook.setBookType(GlobalParamSet.getShort(BizConstants.CONTRACT_BOOK_TYPE_PAYMENT));
		contractBook.setAmount(Long.parseLong(amount));
		contractBook.setEffDate(new Date());
		contractBook.setState(GlobalParamSet.getInteger(BizConstants.CONTRACT_BOOK_STATE_NORMAL));
		contractBook.setVer(1L);
		// 存入账户流水表
		// ContbookRecord record = new ContbookRecord();
		// String id = sequenceFactory.next(BizConstants.SEQUENCENAME_BOOKRECORD);
		// record.setId(Long.parseLong(id));
		// record.setBookId(bookId);
		// record.setOperAmount(Long.parseLong(amount));
		// record.setOperComm("");
		// record.setOperDate(new Date());
		// record.setOperType(Short.parseShort("100"));
		// record.setOperSubType(operSubType);
		contractBookMapper.insertSelective(contractBook);
		// contbookRecordMapper.insertSelective(record);
		return bookId;

	}

	@Override
	@Transactional
	public String DepositBookOpen(String amount, ContractBookBo bo) {
		// 合法性校验
		String bookType = GlobalParamSet.getString(BizConstants.CONTRACT_BOOK_TYPE_DEPOSIT);
		if (StringUtil.isEmpty(bookType)) {
			bookType = "100";
		}
		hasContBook(bo, bookType);
		// 存入账户表
		ContractBook contractBook = bo.toContractBook();
		String bookId = sequenceFactory.next(BizConstants.SEQUENCENAME_BOOK);
		contractBook.setBookId(bookId);
		contractBook.setBookType(Short.parseShort(GlobalParamSet.getString(BizConstants.CONTRACT_BOOK_TYPE_DEPOSIT)));
		contractBook.setAmount(Long.parseLong(amount));
		contractBook.setEffDate(new Date());
		contractBook.setState(Integer.parseInt(GlobalParamSet.getString(BizConstants.CONTRACT_BOOK_STATE_NORMAL)));
		contractBook.setVer(1L);
		// 存入账户流水表
		// ContbookRecord record = new ContbookRecord();
		// String id = sequenceFactory.next(BizConstants.SEQUENCENAME_BOOKRECORD);
		// record.setId(Long.parseLong(id));
		// record.setBookId(bookId);
		// record.setOperAmount(Long.parseLong(amount));
		// record.setOperComm("");
		// record.setOperDate(new Date());
		// record.setOperType(Short.parseShort("200"));
		// record.setOperSubType(operSubType);
		contractBookMapper.insertSelective(contractBook);
		// contbookRecordMapper.insertSelective(record);
		return bookId;

	}

	@Override
	@Transactional
	public String creditBookOpen(String amount, ContractBookBo bo) {
		// 合法性校验
		String bookType = GlobalParamSet.getString(BizConstants.CONTRACT_BOOK_TYPE_CREDIT);
		if (StringUtil.isEmpty(bookType)) {
			bookType = "300";
		}
		hasContBook(bo, bookType);
		// 存入账户表
		ContractBook contractBook = bo.toContractBook();
		String bookId = sequenceFactory.next(BizConstants.SEQUENCENAME_BOOK);
		contractBook.setBookId(bookId);
		contractBook.setBookType(Short.parseShort(GlobalParamSet.getString(BizConstants.CONTRACT_BOOK_TYPE_CREDIT)));
		contractBook.setAmount(Long.parseLong(amount));
		contractBook.setEffDate(new Date());
		contractBook.setState(Integer.parseInt(GlobalParamSet.getString(BizConstants.CONTRACT_BOOK_STATE_NORMAL)));
		contractBook.setVer(1L);

		contractBookMapper.insertSelective(contractBook);
		return bookId;

	}

	/**
	 * 账户合法性验证
	 * 
	 * @param bo
	 * @return
	 */
	private Boolean authContBook(ContractBookBo bo, String bookType) {
		ContractBook contractBook = bo.toContractBook();
		ContractBookExample example = new ContractBookExample();
		Criteria criteria = example.createCriteria();
		criteria.andContIdEqualTo(contractBook.getContId());
		criteria.andBookTypeEqualTo(Short.parseShort(bookType));
		ContractBook book = contractBookMapper.selectByExample(example).get(0);
		if (null != book && (contractBook.getBookId().equals(book.getBookId()))) {

			if (contractBook.getState().equals(Integer.parseInt(GlobalParamSet.getString(BizConstants.CONTRACT_BOOK_STATE_NORMAL)))) {
				return true;
			} else {
				throw new ContBookValidException();
			}

		} else {

			throw new ContBookValidException();
		}

	}

	/**
	 * 账户存是否存在校验
	 * 
	 * @param bo
	 * @return
	 */
	private Boolean hasContBook(ContractBookBo bo, String bookType) {
		ContractBook contractBook = bo.toContractBook();
		ContractBookExample example = new ContractBookExample();
		example.createCriteria().andContIdEqualTo(contractBook.getContId());
		example.createCriteria().andBookTypeEqualTo(Short.parseShort(bookType));
		ContractBook book = contractBookMapper.selectByExample(example).get(0);
		if (null == book) {

			return true;

		} else {

			throw new ContBookValidException();
		}
	}
	@Override
	@Transactional
	public String paymentBookIncome(long amount,String contId) {
		ContractBookExample example = new ContractBookExample();
		example.createCriteria().andContIdEqualTo(contId).andBookTypeEqualTo(GlobalParamSet.getShort(BizConstants.CONTRACT_BOOK_TYPE_PAYMENT));
		List<ContractBook> bookList = contractBookMapper.selectByExample(example);
		
		assert (bookList != null && bookList.size() == 1);
		
		ContractBook paymentBook = bookList.get(0);
		
		long curVer = paymentBook.getVer();
		
		paymentBook.setAmount(paymentBook.getAmount()+amount);
		paymentBook.setVer(curVer+1);
		
		ContractBookExample locker = new ContractBookExample();
		locker.createCriteria().andBookIdEqualTo(paymentBook.getBookId()).andVerEqualTo(curVer);
		ContbookRecord record = new ContbookRecord();
		String id = sequenceFactory.next(BizConstants.SEQUENCENAME_BOOKRECORD);
		record.setId(Long.parseLong(id));
		record.setBookId(paymentBook.getBookId());
		record.setLockVal(1L);
		record.setOperAmount(amount);
		record.setOperComm(AttributeSet.getAttrGroup(BizConstants.ATTR_CONTRACT_BOOK_TYPE).getName(String.valueOf(paymentBook.getBookType())) + "收入：" + amount);
		record.setOperDate(new Date());
		record.setOperType(GlobalParamSet.getShort(BizConstants.CONT_BOOK_RECORD_OPER_TYPE_IN));
		contractBookMapper.updateByExampleSelective(paymentBook, locker);
		contbookRecordMapper.insertSelective(record);
		return record.getBookId();
	}
	@Override
	@Transactional
	public String paymentBookPay(long amount,String contId) {
		ContractBookExample example = new ContractBookExample();
		example.createCriteria().andContIdEqualTo(contId).andBookTypeEqualTo(GlobalParamSet.getShort(BizConstants.CONTRACT_BOOK_TYPE_PAYMENT));
		List<ContractBook> bookList = contractBookMapper.selectByExample(example);
		
		assert (bookList != null && bookList.size() == 1);
		
		ContractBook paymentBook = bookList.get(0);
		
		long curVer = paymentBook.getVer();
		
		paymentBook.setAmount(paymentBook.getAmount() - amount );
		paymentBook.setVer(curVer+1);
		
		ContractBookExample locker = new ContractBookExample();
		locker.createCriteria().andBookIdEqualTo(paymentBook.getBookId()).andVerEqualTo(curVer);
		ContbookRecord record = new ContbookRecord();
		String id = sequenceFactory.next(BizConstants.SEQUENCENAME_BOOKRECORD);
		record.setId(Long.parseLong(id));
		record.setBookId(paymentBook.getBookId());
		record.setLockVal(1L);
		record.setOperAmount(0 - amount);
		record.setOperComm(AttributeSet.getAttrGroup(BizConstants.ATTR_CONTRACT_BOOK_TYPE).getName(String.valueOf(paymentBook.getBookType())) + "支出：" + amount);
		record.setOperDate(new Date());
		record.setOperType(GlobalParamSet.getShort(BizConstants.CONT_BOOK_RECORD_OPER_TYPE_OUT));
		contractBookMapper.updateByExampleSelective(paymentBook, locker);
		contbookRecordMapper.insertSelective(record);
		return record.getBookId();
	}
	@Override
	@Transactional
	public String depositBookIncome(long amount,String contId) {
		ContractBookExample example = new ContractBookExample();
		example.createCriteria().andContIdEqualTo(contId).andBookTypeEqualTo(GlobalParamSet.getShort(BizConstants.CONTRACT_BOOK_TYPE_DEPOSIT));
		List<ContractBook> bookList = contractBookMapper.selectByExample(example);
		
		assert (bookList != null && bookList.size() == 1);
		
		ContractBook depositBook = bookList.get(0);
		
		long curVer = depositBook.getVer();
		
		depositBook.setAmount(depositBook.getAmount()+amount);
		depositBook.setVer(curVer+1);
		
		ContractBookExample locker = new ContractBookExample();
		locker.createCriteria().andBookIdEqualTo(depositBook.getBookId()).andVerEqualTo(curVer);
		ContbookRecord record = new ContbookRecord();
		String id = sequenceFactory.next(BizConstants.SEQUENCENAME_BOOKRECORD);
		record.setId(Long.parseLong(id));
		record.setBookId(depositBook.getBookId());
		record.setLockVal(1L);
		record.setOperAmount(amount);
		record.setOperComm(AttributeSet.getAttrGroup(BizConstants.ATTR_CONTRACT_BOOK_TYPE).getName(String.valueOf(depositBook.getBookType())) + "收入：" + amount);
		record.setOperDate(new Date());
		record.setOperType(GlobalParamSet.getShort(BizConstants.CONT_BOOK_RECORD_OPER_TYPE_IN));
		contractBookMapper.updateByExampleSelective(depositBook, locker);
		contbookRecordMapper.insertSelective(record);
		return record.getBookId();
	
	}
	
	@Override
	@Transactional
	public String depositBookPay(long amount,String contId) {
		ContractBookExample example = new ContractBookExample();
		example.createCriteria().andContIdEqualTo(contId).andBookTypeEqualTo(GlobalParamSet.getShort(BizConstants.CONTRACT_BOOK_TYPE_DEPOSIT));
		List<ContractBook> bookList = contractBookMapper.selectByExample(example);
		
		assert (bookList != null && bookList.size() == 1);
		
		ContractBook depositBook = bookList.get(0);
		
		long curVer = depositBook.getVer();
		
		depositBook.setAmount(depositBook.getAmount()-amount);
		depositBook.setVer(curVer+1);
		
		ContractBookExample locker = new ContractBookExample();
		locker.createCriteria().andBookIdEqualTo(depositBook.getBookId()).andVerEqualTo(curVer);
		ContbookRecord record = new ContbookRecord();
		String id = sequenceFactory.next(BizConstants.SEQUENCENAME_BOOKRECORD);
		record.setId(Long.parseLong(id));
		record.setBookId(depositBook.getBookId());
		record.setLockVal(1L);
		record.setOperAmount(0 - amount);
		record.setOperComm(AttributeSet.getAttrGroup(BizConstants.ATTR_CONTRACT_BOOK_TYPE).getName(String.valueOf(depositBook.getBookType())) + "支出：" + amount);
		record.setOperDate(new Date());
		record.setOperType(GlobalParamSet.getShort(BizConstants.CONT_BOOK_RECORD_OPER_TYPE_OUT));
		contractBookMapper.updateByExampleSelective(depositBook, locker);
		contbookRecordMapper.insertSelective(record);
		return record.getBookId();
	
	}
	@Override
	@Transactional
	public String creditBookOut(long amount,String contId) {
		ContractBookExample example = new ContractBookExample();
		example.createCriteria().andContIdEqualTo(contId).andBookTypeEqualTo(GlobalParamSet.getShort(BizConstants.CONTRACT_BOOK_TYPE_CREDIT));
		List<ContractBook> bookList = contractBookMapper.selectByExample(example);
		
		assert (bookList != null && bookList.size() == 1);
		
		ContractBook creditBook = bookList.get(0);
		
		long curVer = creditBook.getVer();
		
		creditBook.setAmount(creditBook.getAmount()-amount);
		creditBook.setVer(curVer+1);
		
		ContractBookExample locker = new ContractBookExample();
		locker.createCriteria().andBookIdEqualTo(creditBook.getBookId()).andVerEqualTo(curVer);
		ContbookRecord record = new ContbookRecord();
		String id = sequenceFactory.next(BizConstants.SEQUENCENAME_BOOKRECORD);
		record.setId(Long.parseLong(id));
		record.setBookId(creditBook.getBookId());
		record.setLockVal(1L);
		record.setOperAmount(0 - amount);
		record.setOperComm(AttributeSet.getAttrGroup(BizConstants.ATTR_CONTRACT_BOOK_TYPE).getName(String.valueOf(creditBook.getBookType())) + "支出：" + amount);
		record.setOperDate(new Date());
		record.setOperType(GlobalParamSet.getShort(BizConstants.CONT_BOOK_RECORD_OPER_TYPE_OUT));
		contractBookMapper.updateByExampleSelective(creditBook, locker);
		contbookRecordMapper.insertSelective(record);
		return record.getBookId();
	
	}

	@Override
	public int addDataBook(Contract contract) {
		DataAccount dataAccount = new DataAccount();
		String acctId = sequenceFactory.next(BizConstants.SEQUENCENAME_DATAACCT);
		dataAccount.setAcctId(acctId);
		dataAccount.setAcctType(GlobalParamSet.getInteger(BizConstants.ACCT_TYPE_HN_DISTRIBUTION));
		dataAccount.setCreateDate(new Date());
		dataAccount.setCustId(contract.getCustId());
		
		DataBooka dataBooka = new DataBooka();
		String bookId = sequenceFactory.next(BizConstants.SEQUENCENAME_DATABOOK);
		dataBooka.setBookId(bookId);
		dataBooka.setCustId(contract.getCustId());
		dataBooka.setContId(contract.getContId());
		dataBooka.setAcctId(acctId);
		dataBooka.setBalaVal(0L);
		dataBooka.setBookName("流量分销量本");
		dataBooka.setBookState(GlobalParamSet.getShort(BizConstants.DATA_BOOK_STATE_USING));
		dataBooka.setBookType(GlobalParamSet.getInteger(BizConstants.DATA_BOOK_TYPE_DATA));
		dataBooka.setGoodsType(GlobalParamSet.getInteger(BizConstants.GOODS_TYPE_NORMAL));
		dataBooka.setBusiType(GlobalParamSet.getString(BizConstants.BUSSINESS_TYPE_DISTIBUTION));
		dataBooka.setCreateDate(new Date());
		dataBooka.setCumuVal(0L);
		dataBooka.setEffDate(contract.getEffDate());
		dataBooka.setExpDate(contract.getExpDate());
		dataBooka.setRegionId(contract.getRegionId());
		dataBooka.setOrigType(GlobalParamSet.getInteger(BizConstants.DATA_BOOK_ORIG_TYPE_CONT));
		dataBooka.setOrigId(contract.getContId());
		dataBooka.setServiceId(contract.getServiceId());
		dataBooka.setTotalVal(0L);
		dataBooka.setVer(1);;
		
		return dataAccountMapper.insert(dataAccount)+dataBookaMapper.insertSelective(dataBooka);
	}
}