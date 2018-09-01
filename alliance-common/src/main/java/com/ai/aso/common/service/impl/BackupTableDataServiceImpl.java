package com.ai.aso.common.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.ai.aso.base.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.db.dao.BillRecMapper;
import com.ai.aso.common.db.dao.ContractBookDiskMapper;
import com.ai.aso.common.db.dao.ContractBookMapper;
import com.ai.aso.common.db.dao.ContractMapper;
import com.ai.aso.common.db.dao.CostBillMapper;
import com.ai.aso.common.db.dao.CustMapper;
import com.ai.aso.common.db.dao.DataBookaDiskMapper;
import com.ai.aso.common.db.dao.DataBookaMapper;
import com.ai.aso.common.db.dao.PaymentMapper;
import com.ai.aso.common.db.dao.ext.BillRecExtMapper;
import com.ai.aso.common.db.model.BillRec;
import com.ai.aso.common.db.model.BillRecExample;
import com.ai.aso.common.db.model.Contract;
import com.ai.aso.common.db.model.ContractBook;
import com.ai.aso.common.db.model.ContractBookDisk;
import com.ai.aso.common.db.model.ContractBookExample;
import com.ai.aso.common.db.model.CostBill;
import com.ai.aso.common.db.model.CostBillExample;
import com.ai.aso.common.db.model.Cust;
import com.ai.aso.common.db.model.DataBooka;
import com.ai.aso.common.db.model.DataBookaDisk;
import com.ai.aso.common.db.model.Payment;
import com.ai.aso.common.db.model.PaymentExample;
import com.ai.aso.common.service.BackupTableDataService;

@Service("backupTableDataService")
public class BackupTableDataServiceImpl implements BackupTableDataService {
	Logger logger = LoggerFactory.getLogger(BackupTableDataServiceImpl.class);
	@Autowired
	private ContractMapper contractMapper;
	@Autowired
	private ContractBookMapper contractBookMapper;
	@Autowired
	private PaymentMapper paymentMapper;
	@Autowired
	private DataBookaMapper dataBookaMapper;
	@Autowired
	private CostBillMapper costBillMapper;
	@Autowired
	private CustMapper custMapper;
	@Autowired
	private ContractBookDiskMapper contractBookDiskMapper;
	@Autowired
	private DataBookaDiskMapper dataBookaDiskMapper;
	@Autowired
	private BillRecMapper billRecMapper;
	@Autowired
	private BillRecExtMapper billRecExtMapper;
	private DecimalFormat df = new DecimalFormat("#############000");

	@Override
	public void backupFile() {
		// TODO Auto-generated method stub
		logger.debug("备份经分所需表文件开始");
		backupContractData();
		backupContractBookData();
		backupPaymentData();
		// backupDataBookaData();
		backupCustData();
		logger.debug("备份经分所需表文件结束");
	}

	@Override
	public void backupTable() {
		// TODO Auto-generated method stub
		logger.debug("备份经分所需表到备份表开始");
		backupContbookDisk();
		// backupDatabookDisk();
		logger.debug("备份经分所需表到备份表结束");
	}

	@Override
	public void backupBillrecAndCostbill() {
		// TODO Auto-generated method stub
		logger.debug("备份经分所需Billrec&Costbill表文件结束");
		// backupCostBillData();
		backupBillrec();
		logger.debug("备份经分所需Billrec&Costbill表文件结束");
	}

	@Override
	public void backupContractData() {
		// TODO Auto-generated method stub
		List<Contract> contracts = contractMapper.selectByExample(null);
		logger.debug("备份合同表(tc_contract)数据共{}条", contracts.size());
		List<String> tempList = null;
		int i = 1;
		int counts = 0;
		if (!contracts.isEmpty() && contracts.size() > 0) {
			tempList = new ArrayList<String>();
			for (Contract contract : contracts) {
				String tempString = contract.getContId() + "|" + contract.getCustId() + "|" + contract.getContNo() + "|"
						+ contract.getContName() + "|" + contract.getContCopy() + "|" + contract.getContValue() + "|"
						+ contract.getBusiType() + "|" + contract.getPayType() + "|" + contract.getPayment() + "|"
						+ contract.getDeposit() + "|" + contract.getPayedFee() + "|" + contract.getContOff() + "|"
						+ (contract.getCreateDate() == null ? ""
								: new SimpleDateFormat("yyyyMMddHHmmss").format(contract.getCreateDate()))
						+ "|"
						// + new
						// SimpleDateFormat("yyyyMMddHHmmss").format(contract.getCreateDate())

						+ (contract.getEffDate() == null ? ""
								: new SimpleDateFormat("yyyyMMddHHmmss").format(contract.getEffDate()))
						+ "|"
						// + new
						// SimpleDateFormat("yyyyMMddHHmmss").format(contract.getEffDate())+"|"
						+ (contract.getExpDate() == null ? ""
								: new SimpleDateFormat("yyyyMMddHHmmss").format(contract.getExpDate()))
						+ "|"
						// + new
						// SimpleDateFormat("yyyyMMddHHmmss").format(contract.getExpDate())+"|"
						+ contract.getState() + "|" + contract.getSubState() + "|" + contract.getRegionId() + "|"
						+ contract.getServiceId() + "|" + contract.getPaymentId() + "|" + contract.getContName() + "|"
						+ contract.getCustName() + "|" + contract.getExt1() + "|" + contract.getExt2() + "|"
						+ contract.getExt3() + "|" + contract.getExt4() + "|" + contract.getExt5() + "\r\n";

				tempList.add(tempString.replaceAll("null", ""));
				counts++;
				if (counts == GlobalParamSet.getInteger(BizConstants.BILL_REC_SHOW_LINE_COUNTS)) {

					saveDataFile(tempList, "tc_contract", df.format(i));
					tempList = new ArrayList<String>();
					counts = 1;
					i++;
				}
			}
		}
		saveDataFile(tempList, "tc_contract", df.format(i));
	}

	@Override
	public void backupContractBookData() {
		// TODO Auto-generated method stub
		ContractBookExample example = new ContractBookExample();
		List<Short> booktypes = new ArrayList<Short>();
		booktypes.add(GlobalParamSet.getShort(BizConstants.CONTRACT_BOOK_TYPE_DEPOSIT));
		booktypes.add(GlobalParamSet.getShort(BizConstants.CONTRACT_BOOK_TYPE_PAYMENT));
		example.createCriteria().andBookTypeIn(booktypes)
				.andStateEqualTo(GlobalParamSet.getInteger(BizConstants.CONTRACT_BOOK_STATE_NORMAL));
		List<ContractBook> contractBooks = contractBookMapper.selectByExample(example);
		logger.debug("备份合同账本表(tc_contractBook)数据共{}条", contractBooks.size());
		List<String> tempList = null;
		int i = 1;
		int counts = 0;
		if (null != contractBooks && contractBooks.size() > 0) {
			tempList = new ArrayList<String>();
			for (ContractBook contractBook : contractBooks) {
				String tempString = contractBook.getBookId() + "|" + contractBook.getContId() + "|"
						+ contractBook.getBookType() + "|" + contractBook.getAmount() + "|" + contractBook.getState()
						+ "|" + contractBook.getEffDate() + "|" + contractBook.getExpDate() + "|"
						+ contractBook.getVer() + "|" + contractBook.getExt1() + "|" + contractBook.getExt2() + "|"
						+ contractBook.getExt3() + "\r\n";
				tempList.add(tempString.replaceAll("null", ""));
				counts++;
				if (counts == GlobalParamSet.getInteger(BizConstants.BILL_REC_SHOW_LINE_COUNTS)) {

					saveDataFile(tempList, "tc_contractBook", df.format(i));
					tempList = new ArrayList<String>();
					counts = 1;
					i++;
				}
			}
		}
		saveDataFile(tempList, "tc_contractBook", df.format(i));
	}

	@Override
	public void backupPaymentData() {
		// TODO Auto-generated method stub
		PaymentExample example = new PaymentExample();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.MONTH, -1);
		Date lastDate = calendar.getTime();
		example.createCriteria().andPayDateBetween(lastDate, new Date())
				.andPayStateEqualTo(GlobalParamSet.getInteger(BizConstants.PAY_STATE_PAY_SUCC))
				.andObjectTypeEqualTo(GlobalParamSet.getInteger(BizConstants.PAY_OBJECT_TYPE_ADVANCES));
		List<Payment> payments = paymentMapper.selectByExample(example);
		logger.debug("备份支付记录表(tc_payment)数据共{}条", payments.size());
		List<String> tempList = null;
		int i = 1;
		int counts = 0;
		if (!payments.isEmpty() && payments.size() > 0) {
			tempList = new ArrayList<String>();
			for (Payment payment : payments) {
				String tempString = payment.getPaymentId() + "|" + payment.getPayMode() + "|" + payment.getCostType()
						+ "|" + payment.getCustId() + "|" + payment.getObjectType() + "|" + payment.getObjectId() + "|"
						+ payment.getAmount() + "|"
						+ new SimpleDateFormat("yyyyMMddHHmmss").format(payment.getApplyDate()) + "|"
						+ new SimpleDateFormat("yyyyMMddHHmmss").format(payment.getPayDate()) + "|"
						+ payment.getPayState() + "|" + payment.getPayCert() + "|" + payment.getBillCode() + "|"
						+ payment.getBillServid() + "|" + payment.getBillAcct() + "|" + payment.getPayNo() + "|"
						+ payment.getPayReqid() + "|" + payment.getPayResid() + "|" + payment.getOperator() + "|"
						+ payment.getExt1() + "|" + payment.getExt2() + "|" + payment.getExt3() + "\r\n";
				tempList.add(tempString.replaceAll("null", ""));
				counts++;
				if (counts == GlobalParamSet.getInteger(BizConstants.BILL_REC_SHOW_LINE_COUNTS)) {

					saveDataFile(tempList, "tc_payment", df.format(i));
					tempList = new ArrayList<String>();
					counts = 1;
					i++;
				}
			}
		}
		saveDataFile(tempList, "tc_payment", df.format(i));
	}

	@Override
	public void backupCostBillData() {
		// TODO Auto-generated method stub
		CostBillExample example = new CostBillExample();
		example.createCriteria().andStateEqualTo(GlobalParamSet.getInteger(BizConstants.COST_BILL_STATE_NOT));
		List<CostBill> costBills = costBillMapper.selectByExample(example);
		logger.debug("备份客户收入核算表(tc_costBill)数据共{}条", costBills.size());
		List<String> tempList = null;
		int i = 1;
		int counts = 0;
		if (!costBills.isEmpty() && costBills.size() > 0) {
			tempList = new ArrayList<String>();
			for (CostBill costBill : costBills) {
				String tempString = costBill.getCostId() + "|" + costBill.getBillMonth() + "|" + costBill.getActuMonth()
						+ "|" + costBill.getCustId() + "|" + costBill.getCustName() + "|" + costBill.getRegionId() + "|"
						+ costBill.getRegionName() + "|" + costBill.getUsedData() + "|" + costBill.getExpData() + "|"
						+ costBill.getBillFee() + "|" + costBill.getTotalFee() + "|" + costBill.getOffFee() + "|"
						+ costBill.getDiscount() + "|" + costBill.getState() + "|" + costBill.getIsInvcd() + "|"
						+ new SimpleDateFormat("yyyyMMddHHmmss").format(costBill.getBegDate()) + "|"
						+ new SimpleDateFormat("yyyyMMddHHmmss").format(costBill.getEndDate()) + "|"
						+ new SimpleDateFormat("yyyyMMddHHmmss").format(costBill.getCreateDate()) + "|"
						+ new SimpleDateFormat("yyyyMMddHHmmss").format(costBill.getOperDate()) + "|"
						+ costBill.getOperator() + "|" + costBill.getExt1() + "|" + costBill.getExt2() + "|"
						+ costBill.getExt3() + "\r\n";
				tempList.add(tempString.replaceAll("null", ""));
				counts++;
				if (counts == GlobalParamSet.getInteger(BizConstants.BILL_REC_SHOW_LINE_COUNTS)) {

					saveDataFile(tempList, "tc_costBill", df.format(i));
					tempList = new ArrayList<String>();
					counts = 1;
					i++;
				}
			}
		}
		saveDataFile(tempList, "tc_costBill", df.format(i));
	}

	@Override
	public void backupDataBookaData() {
		// TODO Auto-generated method stub
		List<DataBooka> bookas = dataBookaMapper.selectByExample(null);
		logger.debug("备份流量分销量本表(tc_dataBooka)数据共{}条", bookas.size());
		List<String> tempList = null;
		int i = 1;
		int counts = 0;
		tempList = new ArrayList<String>();
		if (!bookas.isEmpty() && bookas.size() > 0) {
			// tempList = new ArrayList<String>();
			for (DataBooka dataBooka : bookas) {
				String tempString = dataBooka.getBookId() + "|" + dataBooka.getCustId() + "|" + dataBooka.getAcctId()
						+ "|" + dataBooka.getAcctType() + "|" + dataBooka.getContId() + "|" + dataBooka.getBusiType()
						+ "|" + new SimpleDateFormat("yyyyMMddHHmmss").format(dataBooka.getEffDate()) + "|"
						+ new SimpleDateFormat("yyyyMMddHHmmss").format(dataBooka.getExpDate()) + "|"
						+ dataBooka.getBookType() + "|" + dataBooka.getBookName() + "|" + dataBooka.getGoodsType() + "|"
						+ dataBooka.getBookState() + "|" + dataBooka.getRegionId() + "|" + dataBooka.getBillRule() + "|"
						+ dataBooka.getOrigType() + "|" + dataBooka.getOrigId() + "|" + dataBooka.getNote() + "|"
						+ new SimpleDateFormat("yyyyMMddHHmmss").format(dataBooka.getCreateDate()) + "|"
						+ dataBooka.getServiceId() + "|" + dataBooka.getTotalVal() + "|" + dataBooka.getCumuVal() + "|"
						+ dataBooka.getBalaVal() + "|" + dataBooka.getVer() + "|" + dataBooka.getExt1() + "|"
						+ dataBooka.getExt2() + "|" + dataBooka.getExt3() + "|" + dataBooka.getExt4() + "|"
						+ dataBooka.getExt5() + "\r\n";
				tempList.add(tempString.replaceAll("null", ""));
				counts++;
				if (counts == GlobalParamSet.getInteger(BizConstants.BILL_REC_SHOW_LINE_COUNTS)) {

					saveDataFile(tempList, "tc_dataBooka", df.format(i));
					tempList = new ArrayList<String>();
					counts = 1;
					i++;
				}
			}
		}
		saveDataFile(tempList, "tc_dataBooka", df.format(i));
	}

	@Override
	public void backupCustData() {
		// TODO Auto-generated method stub
		List<Cust> custs = custMapper.selectByExample(null);
		logger.debug("备份客户信息表(tc_cust)数据共{}条", custs.size());
		List<String> tempList = null;
		int i = 1;
		int counts = 0;
		tempList = new ArrayList<String>();
		if (!custs.isEmpty() && custs.size() > 0) {
			// tempList = new ArrayList<String>();
			for (Cust cust : custs) {
				String tempString = cust.getCustId() + "|" + cust.getOriginCustId() + "|" + cust.getCustExtId() + "|"
						+ cust.getAcctId() + "|" + cust.getCustType() + "|" + cust.getCustName() + "|"
						+ cust.getCustNamePy() + "|" + cust.getShortName() + "|" + cust.getCertType() + "|"
						+ cust.getCertNbr() + "|" + cust.getRegionId() + "|" + cust.getCustAddr() + "|"
						+ cust.getUserName() + "|" + cust.getUserMobile() + "|" + cust.getUserEmail() + "|"
						+ cust.getUserPhone() + "|" + cust.getSalsman() + "|" + cust.getState() + "|"
						+ cust.getValidFlag() + "|" + cust.getOperFlag() + "|"
						+ new SimpleDateFormat("yyyyMMddHHmmss").format(cust.getCreateDate()) + "|"
						+ new SimpleDateFormat("yyyyMMddHHmmss").format(cust.getModiDate()) + "|" + cust.getCrmCustSn()
						+ "|" + cust.getCrmAcctSn() + "|" + cust.getCrmUserSn() + "|" + cust.getCrmUserCode() + "|"
						+ cust.getAgentLevel() + "|" + cust.getManagerId() + "|" + cust.getVipLevel() + "|"
						+ cust.getSnapFlag() + "|" + cust.getSnapVer() + "|" + cust.getExt1() + "|" + cust.getExt2()
						+ "|" + cust.getExt3() + "\r\n";
				tempList.add(tempString.replaceAll("null", ""));
				counts++;
				if (counts == GlobalParamSet.getInteger(BizConstants.BILL_REC_SHOW_LINE_COUNTS)) {

					saveDataFile(tempList, "tc_cust", df.format(i));
					tempList = new ArrayList<String>();
					counts = 1;
					i++;
				}
			}
		}
		saveDataFile(tempList, "tc_cust", df.format(i));
	}

	private void backupBillrec() {
		BillRecExample example = new BillRecExample();
		String lastBatch = billRecExtMapper.selectNewbillBatch();
		String batchCode=null;
		if (StringUtil.isEmpty(lastBatch)) {
			example.createCriteria().andStateEqualTo(200);
		} else {
			example.createCriteria().andStateEqualTo(200).andBillMonthEqualTo(lastBatch.substring(0, 6));
		}
		example.setOrderByClause("Cust_Id");
		List<BillRec> billRecs = billRecMapper.selectByExample(example);
//		if (StringUtil.isNotEmpty(lastBatch)) {
//			batchCode=lastBatch.substring(0, 6) + "%";
//		}
//		List<BillRec> billRecs=billRecExtMapper.selectBillRec(batchCode);
		logger.debug("备份流量计费清单表(tc_billRec)数据共{}条", billRecs.size());
		List<String> tempList = null;

		int i = 1;
		int counts = 0;
		tempList = new ArrayList<String>();
		if (!billRecs.isEmpty() && billRecs.size() > 0) {

			for (BillRec billRec : billRecs) {
				String tempString = billRec.getBillRecId() + "|" + billRec.getBillMonth() + "|" + billRec.getBillBatch()
						+ "|" + billRec.getSourceType() + "|" + billRec.getPayType() + "|" + billRec.getDataBookId()
						+ "|" + billRec.getCapBookId() + "|" + billRec.getRecNo() + "|" + billRec.getBatchCode() + "|"
						+ billRec.getRecClass() + "|" + billRec.getRecMode() + "|" + billRec.getContId() + "|"
						+ billRec.getContNo() + "|" + billRec.getCustId() + "|" + billRec.getCustName() + "|"
						+ billRec.getRegionId() + "|" + billRec.getRegionName() + "|" + billRec.getBusiMode() + "|"
						+ billRec.getUserNbr() + "|" + billRec.getCostRegion() + "|" + billRec.getCostRegionName() + "|"
						+ billRec.getServId() + "|" + billRec.getBillOfferId() + "|" + billRec.getOfferInst() + "|"
						+ billRec.getGoodsId() + "|" + billRec.getGoodsType() + "|" + billRec.getDataType() + "|"
						+ billRec.getGoodsName() + "|" + billRec.getDataVal() + "|" + billRec.getDiscount() + "|"
						+ billRec.getBillFee() + "|" + billRec.getTotalFee() + "|" + billRec.getOffFee() + "|"
						+ billRec.getCostRate() + "|" + billRec.getCostFee() + "|" + billRec.getRemarks() + "|"
						+ billRec.getRecState() + "|"
						+ new SimpleDateFormat("yyyyMMddHHmmss").format(billRec.getSubDate()) + "|"
						+ new SimpleDateFormat("yyyyMMddHHmmss").format(billRec.getRecDate()) + "|"
						+ billRec.getTrdRec() + "|" + billRec.getTrdSaler() + "|" + billRec.getTrdActivity() + "|"
						+ billRec.getCostCenter() + "|" + billRec.getState() + "|" + billRec.getExt1() + "|"
						+ billRec.getExt2() + "|" + billRec.getExt3() + "\r\n";
				tempList.add(tempString.replaceAll("null", ""));
				counts++;
				if (counts == GlobalParamSet.getInteger(BizConstants.BILL_REC_SHOW_LINE_COUNTS)) {

					saveDataFile(tempList, "tc_billRec", df.format(i));
					tempList = new ArrayList<String>();
					counts = 1;
					i++;
				}
			}
		}
		saveDataFile(tempList, "tc_billRec", df.format(i));
	}

	@Override
	public void backupContbookDisk() {
		// TODO Auto-generated method stub
		ContractBookExample example = new ContractBookExample();
		List<Short> booktypes = new ArrayList<Short>();
		booktypes.add(GlobalParamSet.getShort(BizConstants.CONTRACT_BOOK_TYPE_DEPOSIT));
		booktypes.add(GlobalParamSet.getShort(BizConstants.CONTRACT_BOOK_TYPE_PAYMENT));
		example.createCriteria().andBookTypeIn(booktypes)
				.andStateEqualTo(GlobalParamSet.getInteger(BizConstants.CONTRACT_BOOK_STATE_NORMAL));
		List<ContractBook> contractBooks = contractBookMapper.selectByExample(example);
		logger.debug("备份合同账本表(tc_contractBook)到(tc_contractBook_disk)数据共{}条", contractBooks.size());
		if (null != contractBooks && contractBooks.size() > 0) {
			contractBookDiskMapper.deleteByExample(null);
			for (ContractBook contractBook : contractBooks) {
				contractBookDiskMapper.insertSelective(tocontractBookDisk(contractBook));

			}
		}
	}

	@Override
	public void backupDatabookDisk() {
		// TODO Auto-generated method stub
		List<DataBooka> bookas = dataBookaMapper.selectByExample(null);
		logger.debug("备份流量分销量本表(tc_dataBooka)到(tc_dataBooka_disk)数据共{}条", bookas.size());
		if (!bookas.isEmpty() && bookas.size() > 0) {
			dataBookaDiskMapper.deleteByExample(null);
			for (DataBooka dataBooka : bookas) {
				dataBookaDiskMapper.insertSelective(todataBookaDisk(dataBooka));
			}
		}
	}

	private void saveDataFile(List<String> dataList, String tableName, String conts) {
		String path = GlobalParamSet.getString(BizConstants.FILE_UPLOAD_BACKUP_TABLE);
		String mounth ="";
		String today = new SimpleDateFormat("yyyyMMdd").format(new Date());
		Calendar calendar = Calendar.getInstance();
		if (tableName.equalsIgnoreCase("tc_billRec")) {
			calendar.add(Calendar.MONTH, -1);
			 mounth = new SimpleDateFormat("yyyyMM").format(calendar.getTime());
		} else {
			 mounth = new SimpleDateFormat("yyyyMM").format(calendar.getTime());
		}
		String filePath = path.trim() + tableName + "." + mounth + "." + today + "." + conts + ".txt";
		logger.debug("备份数据生成的文件是{}", filePath);

		File file = new File(filePath);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		OutputStreamWriter write=null;
		BufferedWriter writer =null;
		String encoding = "UTF-8";
		try {
			write = new OutputStreamWriter(new FileOutputStream(file), encoding);
			 writer = new BufferedWriter(write);
			if (null != dataList && dataList.size() > 0) {
				for (String string : dataList) {
					writer.write(string); // 输出流写入到文件中
				}
			}
			writer.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (null!=write){
               try {
				   write.close();
			   }catch (IOException e){
				   e.printStackTrace();
			   }
			}if (null!=writer){
               try {
				   writer.close();
			   }catch (IOException e){
				   e.printStackTrace();
			   }
			}
		}
	}

	private DataBookaDisk todataBookaDisk(DataBooka dataBooka) {
		DataBookaDisk dataBookaDisk = new DataBookaDisk();
		dataBookaDisk.setBookId(dataBooka.getBookId());
		dataBookaDisk.setAcctId(dataBooka.getAcctId());
		dataBookaDisk.setCustId(dataBooka.getCustId());
		dataBookaDisk.setAcctId(dataBooka.getAcctId());
		dataBookaDisk.setAcctType(dataBooka.getAcctType());
		dataBookaDisk.setContId(dataBooka.getContId());
		dataBookaDisk.setBusiType(dataBooka.getBusiType());
		dataBookaDisk.setEffDate(dataBooka.getEffDate());
		dataBookaDisk.setExpDate(dataBooka.getExpDate());
		dataBookaDisk.setBookType(dataBooka.getBookType());
		dataBookaDisk.setBookName(dataBooka.getBookName());
		dataBookaDisk.setGoodsType(dataBooka.getGoodsType());
		dataBookaDisk.setBookState(dataBooka.getBookState());
		dataBookaDisk.setRegionId(dataBooka.getRegionId());
		dataBookaDisk.setBillRule(dataBooka.getBillRule());
		dataBookaDisk.setOrigType(dataBooka.getOrigType());
		dataBookaDisk.setOrigId(dataBooka.getOrigId());
		dataBookaDisk.setNote(dataBooka.getNote());
		dataBookaDisk.setCreateDate(dataBooka.getCreateDate());
		dataBookaDisk.setServiceId(dataBooka.getServiceId());
		dataBookaDisk.setTotalVal(dataBooka.getTotalVal());
		dataBookaDisk.setCumuVal(dataBooka.getCumuVal());
		dataBookaDisk.setBalaVal(dataBooka.getBalaVal());
		dataBookaDisk.setVer(dataBooka.getVer());
		dataBookaDisk.setExt1(dataBooka.getExt1());
		dataBookaDisk.setExt2(dataBooka.getExt2());
		dataBookaDisk.setExt3(dataBooka.getExt3());
		dataBookaDisk.setExt4(dataBooka.getExt4());
		dataBookaDisk.setExt5(dataBooka.getExt5());
		return dataBookaDisk;
	}

	private ContractBookDisk tocontractBookDisk(ContractBook contractBook) {
		ContractBookDisk contractBookDisk = new ContractBookDisk();
		contractBookDisk.setBookId(contractBook.getBookId());
		contractBookDisk.setContId(contractBook.getContId());
		contractBookDisk.setBookType(contractBook.getBookType());
		contractBookDisk.setAmount(contractBook.getAmount());
		contractBookDisk.setState(contractBook.getState());
		contractBookDisk.setEffDate(contractBook.getEffDate());
		contractBookDisk.setExpDate(contractBook.getExpDate());
		contractBookDisk.setVer(contractBook.getVer());
		contractBookDisk.setExt1(contractBook.getExt1());
		contractBookDisk.setExt2(contractBook.getExt2());
		contractBookDisk.setExt3(contractBook.getExt3());
		return contractBookDisk;
	}

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		// calendar.add(Calendar.MONTH, -1);
		String mounth = new SimpleDateFormat("yyyyMM").format(calendar.getTime());
		System.out.println(mounth);
	}
}
