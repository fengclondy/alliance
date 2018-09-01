package com.ai.aso.common.webService.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.base.utils.StringUtil;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.db.dao.CostBillChargeMapper;
import com.ai.aso.common.db.dao.CostBillMapper;
import com.ai.aso.common.db.dao.ext.CostBillExtMapper;
import com.ai.aso.common.db.model.CostBill;
import com.ai.aso.common.db.model.CostBillCharge;
import com.ai.aso.common.db.model.CostBillChargeExample;
import com.ai.aso.common.db.model.CostBillItem;
import com.ai.aso.common.db.model.Cust;
import com.ai.aso.common.service.BackupTableDataService;
import com.ai.aso.common.service.BillItemMapService;
import com.ai.aso.common.service.CustService;
import com.ai.aso.common.webService.db.OracleConnectionManager;
import com.ai.aso.common.webService.db.dao.QuickCostBillBoMapper;
import com.ai.aso.common.webService.model.CostBillBo;
import com.ai.aso.common.webService.service.BillCostService;

/**
 * <p>
 * Description:
 * </p>
 * 
 * @author liuwu
 * @date 2016年11月4日
 * 
 */
@Service
public class BillCostServiceImpl implements BillCostService {
	private static final Logger log = LoggerFactory
			.getLogger(BillCostServiceImpl.class);
	@Autowired
	private OracleConnectionManager oracleConnectionManager;
	@Autowired
	private CostBillMapper costBillMapper;
	@Autowired
	private CustService custService;
	@Autowired
	private BillItemMapService billItemMapService;
	@Autowired
	private QuickCostBillBoMapper quickCostBillBoMapper;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyMM");
	@Autowired
	private CostBillExtMapper costBillExtMapper;
	 @Autowired
	 private BackupTableDataService backupTableDataService;
	@Autowired
	private CostBillChargeMapper costBillChargeMapper;

	public int addCostBill() {
		List<CostBillBo> billList = queryDissynchronizedCostBillItem();
		List<CostBillBo> chargeBillList = queryBillCharge();
		int num = 0;
		int count=0;
		Connection conn = null;
		String acctMounth = "";
		try {
			conn = oracleConnectionManager.getOracleConnection();
			conn.setAutoCommit(false);
			

			if (null != billList && billList.size() > 0) { 
				PreparedStatement stmt = conn
						.prepareStatement("INSERT INTO after_surf_interface VALUES (?,?,?,?,?,?,sysdate,?,?,null,?,null)");
				PreparedStatement stmt2 = conn
						.prepareStatement("INSERT INTO AFTER_SURF_INTERFACE_summary VALUES (?,?,?,?,?,?,sysdate,?,?,null,?,null,?,?)");
				for (CostBillBo costBillBo : billList) {
					log.debug("本月【{}】入后向流量计费账单中间表开始！",
							costBillBo.getBillMonth());
					List<CostBillItem> billItems = costBillBo
							.getCostBillItems();
					long temFee = onload(billItems);
					for (CostBillItem costBillItem : billItems) {
						StringBuffer sb = new StringBuffer();

						num++;
						stmt.setString(1, costBillBo.getAcctId());
						stmt.setString(2, costBillBo.getServId());
						stmt.setString(
								3,
								GlobalParamSet
										.getString(BizConstants.CRM_BILL_ITEM_SOURCE_ID));
						int costRegion = costBillItem.getCostRegion();
						stmt.setString(4,
								billItemMapService.getBillItemId(costRegion));
						sb.append("1");
						if (StringUtil.isNotEmpty(costBillBo.getBillMonth())) {
							acctMounth = costBillBo.getBillMonth().substring(2,
									6);
						} else {
							Calendar calendar = Calendar.getInstance();
							calendar.setTime(new Date());
							calendar.add(Calendar.MONTH, -1);
							Date lastDate = calendar.getTime();
							acctMounth = dateFormat.format(lastDate);
						}
						sb.append(acctMounth);
						String billingCycleId = sb.toString();
						stmt.setString(5, billingCycleId);

						Long billFee = costBillItem.getIncome() / 10;
						if (costBillItem.getRegionId().equals(
								costBillItem.getCostRegion()))
							billFee = (costBillItem.getIncome() + temFee) / 10;
						stmt.setString(6, String.valueOf(billFee));
						stmt.setString(
								7,
								GlobalParamSet
										.getString(BizConstants.CRM_BILL_PAYMENT_METHOD));
						stmt.setString(8, GlobalParamSet
								.getString(BizConstants.CRM_BILL_SATTE));
						stmt.setString(9, GlobalParamSet
								.getString(BizConstants.CRM_BILL_OFFER_ID));
						stmt.addBatch();
					}
					StringBuffer sb1 = new StringBuffer();
					stmt2.setString(1, costBillBo.getAcctId());
					stmt2.setString(2, costBillBo.getServId());
					stmt2.setString(3, GlobalParamSet
							.getString(BizConstants.CRM_BILL_ITEM_SOURCE_ID));
					int costRegion = costBillBo.getRegionId();
					stmt2.setString(4,
							billItemMapService.getBillItemId(costRegion));
					sb1.append("1");
					if (StringUtil.isNotEmpty(costBillBo.getBillMonth())) {
						acctMounth = costBillBo.getBillMonth().substring(2, 6);
					} else {
						Calendar calendar = Calendar.getInstance();
						calendar.setTime(new Date());
						calendar.add(Calendar.MONTH, -1);
						Date lastDate = calendar.getTime();
						acctMounth = dateFormat.format(lastDate);
					}
					sb1.append(acctMounth);
					String billingCycleId = sb1.toString();
					stmt2.setString(5, billingCycleId);
					Long billFee = costBillBo.getBillFee() / 10;
					stmt2.setString(6, String.valueOf(billFee));
					stmt2.setString(7, GlobalParamSet
							.getString(BizConstants.CRM_BILL_PAYMENT_METHOD));
					stmt2.setString(8, GlobalParamSet
							.getString(BizConstants.CRM_BILL_SATTE));
					stmt2.setString(9, GlobalParamSet
							.getString(BizConstants.CRM_BILL_OFFER_ID));
					stmt2.setString(10, "0");
					stmt2.setString(11, "0");
					stmt.executeBatch();
					stmt2.executeUpdate();
					conn.commit();
					updateCostBill(costBillBo);
					log.debug("本次【{}】条入后向流量计费账单中间表成功！", num);
					num = 0;
				}
			}
			// 只有列收时
			
			if (null != chargeBillList && chargeBillList.size() > 0) {
				PreparedStatement stmt = conn
						.prepareStatement("INSERT INTO after_surf_interface VALUES (?,?,?,?,?,?,sysdate,?,?,null,?,null)");
				PreparedStatement stmt2 = conn
						.prepareStatement("INSERT INTO AFTER_SURF_INTERFACE_summary VALUES (?,?,?,?,?,?,sysdate,?,?,null,?,null,?,?)");
				
				for (CostBillBo costBillBo_ : chargeBillList) {

					log.debug("本月【{}】只存在列收入客户后向流量计费账单中间表开始！", costBillBo_
							.getCostBillCharge().getBillMonth());
						StringBuffer sb = new StringBuffer();
						count++;
						stmt.setString(1, costBillBo_.getAcctId());
						stmt.setString(2, costBillBo_.getServId());
						stmt.setString(3,GlobalParamSet.getString(BizConstants.CRM_BILL_ITEM_SOURCE_ID));
						int costRegion = costBillBo_.getCostBillCharge().getRegionId();
						stmt.setString(4,billItemMapService.getBillItemId(costRegion));
						sb.append("1");
						if (StringUtil.isNotEmpty(costBillBo_
								.getCostBillCharge().getBillMonth())) {
							acctMounth = costBillBo_.getCostBillCharge().getBillMonth().substring(2,
									6);
						} else {
							Calendar calendar = Calendar.getInstance();
							calendar.setTime(new Date());
							calendar.add(Calendar.MONTH, -1);
							Date lastDate = calendar.getTime();
							acctMounth = dateFormat.format(lastDate);
						}
						sb.append(acctMounth);
						String billingCycleId = sb.toString();
						stmt.setString(5, billingCycleId);

						Long billFee = costBillBo_.getCostBillCharge().getBillFee() / 10;
						stmt.setString(6, String.valueOf(billFee));
						stmt.setString(
								7,
								GlobalParamSet
										.getString(BizConstants.CRM_BILL_PAYMENT_METHOD));
						stmt.setString(8, GlobalParamSet
								.getString(BizConstants.CRM_BILL_SATTE));
						stmt.setString(9, GlobalParamSet
								.getString(BizConstants.CRM_BILL_OFFER_ID));
						stmt.addBatch();
				
					StringBuffer sb1 = new StringBuffer();
					stmt2.setString(1, costBillBo_.getAcctId());
					stmt2.setString(2, costBillBo_.getServId());
					stmt2.setString(3, GlobalParamSet.getString(BizConstants.CRM_BILL_ITEM_SOURCE_ID));
					stmt2.setString(4,
							billItemMapService.getBillItemId(costRegion));
					sb1.append("1");
					if (StringUtil.isNotEmpty(costBillBo_.getCostBillCharge().getBillMonth())) {
						acctMounth = costBillBo_.getCostBillCharge().getBillMonth().substring(2, 6);
					} else {
						Calendar calendar = Calendar.getInstance();
						calendar.setTime(new Date());
						calendar.add(Calendar.MONTH, -1);
						Date lastDate = calendar.getTime();
						acctMounth = dateFormat.format(lastDate);
					}
					sb1.append(acctMounth);
					stmt2.setString(5, billingCycleId);
					stmt2.setString(6, String.valueOf(billFee));
					stmt2.setString(7, GlobalParamSet
							.getString(BizConstants.CRM_BILL_PAYMENT_METHOD));
					stmt2.setString(8, GlobalParamSet
							.getString(BizConstants.CRM_BILL_SATTE));
					stmt2.setString(9, GlobalParamSet
							.getString(BizConstants.CRM_BILL_OFFER_ID));
					stmt2.setString(10, "0");
					stmt2.setString(11, "0");
					stmt.executeBatch();
					stmt2.executeUpdate();
					conn.commit();
					updateCostBillCharge(costBillBo_);
					log.debug("本次【{}】条只存在列收入后向流量计费账单中间表成功！", count);
					count = 0;

				}
			}

		} catch (Exception e) {

			log.error("数据库执行异常", e);
			try {
				conn.rollback();
			} catch (SQLException excp) {
				// TODO Auto-generated catch block
				log.error("数据库回滚数据异常", excp);

			}
		} finally {
			oracleConnectionManager.closeConnection(conn);
		}

		backupTableDataService.backupBillrecAndCostbill();
		return num+count;
	}

	public List<CostBillBo> queryBillCharge() {
		List<CostBillBo> billBos = new ArrayList<>();
		// 查询客户本月不存在入账的列收
		Integer state = GlobalParamSet
				.getInteger(BizConstants.COST_BILL_STATE_NOT);

		List<CostBillBo> billList = quickCostBillBoMapper
				.queryCostBillBo(state);
		List<String> custList = new ArrayList<>();
		for (CostBillBo costBillBo : billList) {
			custList.add(costBillBo.getCustId());
		}
		CostBillChargeExample example = new CostBillChargeExample();
		example.createCriteria().andCustIdNotIn(custList)
				.andStateEqualTo(state);
		List<CostBillCharge> billCharges = costBillChargeMapper
				.selectByExample(example);
		for (CostBillCharge costBillCharge : billCharges) {
			CostBillBo costBillBo = new CostBillBo();
			Cust cust = custService
					.findCustByCustId(costBillCharge.getCustId());
			costBillBo.setServId(cust.getCrmUserSn());
			costBillBo.setAcctId(cust.getCrmAcctSn());
			costBillBo.setCostBillCharge(costBillCharge);
			billBos.add(costBillBo);

		}
		return billBos;

	}

	public List<CostBillBo> queryDissynchronizedCostBillItem() {

		Integer state = GlobalParamSet
				.getInteger(BizConstants.COST_BILL_STATE_NOT);

		List<CostBillBo> billList = quickCostBillBoMapper
				.queryCostBillBo(state);
		if (null != billList) {
			for (CostBillBo costBillBo : billList) {
				Cust cust = custService
						.findCustByCustId(costBillBo.getCustId());
				costBillBo.setServId(cust.getCrmUserSn());
				costBillBo.setAcctId(cust.getCrmAcctSn());
				// 查询列收的记录
				CostBillChargeExample example = new CostBillChargeExample();
				example.createCriteria()
						.andCustIdEqualTo(costBillBo.getCustId())
						.andStateEqualTo(state);
				List<CostBillCharge> billChargeList = costBillChargeMapper
						.selectByExample(example);
				// CostBill
				// cb=costBillExtMapper.queryCostBill(costBillBo.getCustId());
				// if(null!=cb)
				// costBillBo.setCostBill(cb);
				if (null != billChargeList && billChargeList.size() > 0) {
					CostBillCharge cbc = billChargeList.get(0);
					long amount = cbc.getBillFee();
					amount = costBillBo.getBillFee() + amount;
					costBillBo.setBillFee(amount);
					costBillBo.setCostBillCharge(cbc);
				}
			}
		}
		return billList;

	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public int updateCostBill(CostBillBo costBillbo) {
		log.debug("同步状态【{}】:客户为{}！", costBillbo.getCostId(),
				costBillbo.getCustId());
		StringBuffer sb = new StringBuffer();
		String acctMounth = "";
		sb.append("1");
		if (StringUtil.isNotEmpty(costBillbo.getBillMonth())) {
			acctMounth = costBillbo.getBillMonth().substring(2, 6);
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.add(Calendar.MONTH, -1);
			Date lastDate = calendar.getTime();
			acctMounth = dateFormat.format(lastDate);
		}
		sb.append(acctMounth);
		String billingCycleId = sb.toString();
		costBillbo.setState(GlobalParamSet
				.getInteger(BizConstants.COST_BILL_STATE_SUC));
		costBillbo.setActuMonth(billingCycleId);
		CostBill costBill = costBillbo.toCostBill(costBillbo);
		// CostBill _costBill=costBillbo.getCostBill();
		CostBillCharge billCharge = costBillbo.getCostBillCharge();
		if (null != billCharge) {
			long amount=costBill.getBillFee()-billCharge.getBillFee();
			costBill.setBillFee(amount);
			billCharge.setActuMonth(billingCycleId);
			billCharge.setState(GlobalParamSet
					.getInteger(BizConstants.COST_BILL_STATE_SUC));
			costBillChargeMapper.updateByPrimaryKeySelective(billCharge);
		}

		// _costBill.setActuMonth(billingCycleId);
		// _costBill.setState(GlobalParamSet.getInteger(BizConstants.COST_BILL_STATE_SUC));
		// costBillMapper.updateByPrimaryKeySelective(_costBill);

		return costBillMapper.updateByPrimaryKeySelective(costBill);
	}
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public int updateCostBillCharge(CostBillBo costBillbo) {
		StringBuffer sb = new StringBuffer();
		String acctMounth = "";
		CostBillCharge billCharge = costBillbo.getCostBillCharge();
		if (null != billCharge) {
			log.debug("同步状态【{}】:客户为{}！", billCharge.getCostChargeId(),
					billCharge.getCustId());
			sb.append("1");
			if (StringUtil.isNotEmpty(costBillbo.getBillMonth())) {
				acctMounth = billCharge.getBillMonth().substring(2, 6);
			} else {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(new Date());
				calendar.add(Calendar.MONTH, -1);
				Date lastDate = calendar.getTime();
				acctMounth = dateFormat.format(lastDate);
			}
			sb.append(acctMounth);
			String billingCycleId = sb.toString();
			billCharge.setActuMonth(billingCycleId);
			billCharge.setState(GlobalParamSet
					.getInteger(BizConstants.COST_BILL_STATE_SUC));
			costBillChargeMapper.updateByPrimaryKeySelective(billCharge);
		}
		return 0;
		
	}
	private long onload(List<CostBillItem> billItems) {
		Long _temFee = 0l;
		for (CostBillItem costBillItem : billItems) {

			if (!costBillItem.getRegionId()
					.equals(costBillItem.getCostRegion())) {
				_temFee += costBillItem.getIncome() % 10;
			}
		}
		return _temFee;

	}
}
