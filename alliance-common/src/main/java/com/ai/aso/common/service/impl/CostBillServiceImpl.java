package com.ai.aso.common.service.impl;

import com.ai.aso.base.exception.BusinessException;
import com.ai.aso.base.exception.ExInfo;
import com.ai.aso.base.utils.StringUtil;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.db.dao.BillRecMapper;
import com.ai.aso.common.db.dao.ContractMapper;
import com.ai.aso.common.db.dao.CostBillItemMapper;
import com.ai.aso.common.db.dao.CostBillMapper;
import com.ai.aso.common.db.dao.CustBillMapper;
import com.ai.aso.common.db.dao.CustMapper;
import com.ai.aso.common.db.dao.ext.BillRecExtMapper;
import com.ai.aso.common.db.dao.ext.CostBillItemExtMapper;
import com.ai.aso.common.db.dao.ext.CustBillExtMapper;
import com.ai.aso.common.db.dao.ext.DataRecExtMapper;
import com.ai.aso.common.db.dao.ext.RegionExtMapper;
import com.ai.aso.common.db.model.BillRec;
import com.ai.aso.common.db.model.BillRecExample;
import com.ai.aso.common.db.model.Contract;
import com.ai.aso.common.db.model.CostBill;
import com.ai.aso.common.db.model.CostBillExample;
import com.ai.aso.common.db.model.CostBillItem;
import com.ai.aso.common.db.model.CostBillItemExample;
import com.ai.aso.common.db.model.Cust;
import com.ai.aso.common.db.model.CustBill;
import com.ai.aso.common.db.model.CustBillExample;
import com.ai.aso.common.exception.BizExInfoEnum;
import com.ai.aso.common.exception.BizValidException;
import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.common.service.CostBillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * <p>description:</p>
 *
 * @author lw
 * @2017/5/8
 */
@Service
public class CostBillServiceImpl implements CostBillService {
	@Autowired
    private CustBillExtMapper custBillExtMapper;
    @Autowired
    private BillRecExtMapper billRecExtMapper;
    @Autowired
    private DataRecExtMapper dataRecExtMapper;
    @Autowired
    private CostBillMapper costBillMapper;
    @Autowired
    private BillRecMapper billRecMapper;
    @Autowired
    private CostBillItemMapper costBillItemMapper;
    @Autowired
    private CustMapper custMapper;
    @Autowired
    private CostBillItemExtMapper costBillItemExtMapper;
    @Autowired
    private RegionExtMapper regionExtMapper;
    @Autowired
    private ContractMapper contractMapper;
    @Autowired
    private CustBillMapper custBillMapper;
    Logger logger = LoggerFactory.getLogger(CostBillServiceImpl.class);
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void dealBill(String billMonth, String contId, String[] billBatch) {
        costBillEntry(billMonth, contId, billBatch);
        repartitionBill(billMonth, contId, billBatch);

    }

    /**
     * 统计入账数据
     *
     * @param billMonth 入账账期
     * @param contId    客户
     * @param billBatch 出账批次数组
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int costBillEntry(String billMonth, String contId, String[] billBatch) {
        // 从客户账单表获取需要统计的入账数据
        List<CustBill> cbList = custBillExtMapper.selectCustBillByCust(billBatch, contId);
        int rs = 0;
        if (cbList.isEmpty()) {
        	throw new BusinessException(ExInfo.create("F200200036", "合同"+"【"+contId+"】"+"客户账单数据异常!", "合同"+"【"+contId+"】"+"客户账单数据异常!"));
        }
        logger.debug("本次【{}】统计入账数据开始",contId);
        List<CostBill> costBills = null;
        for (CustBill cb : cbList) {
            CostBillExample _example = new CostBillExample();
            _example.createCriteria().andCustIdEqualTo(cb.getCustId()).andBillMonthEqualTo(billMonth).andExt1EqualTo("100");
            costBills = costBillMapper.selectByExample(_example);
            if (!costBills.isEmpty()) {
                CostBill cost = costBills.get(0);
                cost.setBillMonth(billMonth);
                cost.setCustId(cb.getCustId());
                cost.setCustName(cb.getCustName());
                cost.setRegionId(cb.getRegionId());
                cost.setRegionName(cb.getRegionName());
                cost.setContId(cb.getContId());
                cost.setUsedData(cb.getDataVal() + cost.getUsedData());
                cost.setExpData(0l);
                cost.setBillFee(cb.getAmount() + cost.getBillFee());
                cost.setOffFee(cb.getOffFee() == null ? 0 : cb.getOffFee() + cost.getOffFee());
                cost.setTotalFee(cost.getBillFee() + (cb.getOffFee() == null ? 0 : cb.getOffFee()));
                cost.setDiscount(0);
                cost.setState(GlobalParamSet.getInteger(BizConstants.COST_BILL_STATE_NOT));
                cost.setIsInvcd(GlobalParamSet.getInteger(BizConstants.IS_INVCD_NOT));
                cost.setBegDate(new Date());
                cost.setCreateDate(new Date());
                cost.setExt1("100");
                logger.debug("【{}】合同多次入账更新入账数据",contId);
                rs = costBillMapper.updateByPrimaryKeySelective(cost);
            } else {
                CostBill cost = new CostBill();
                cost.setBillMonth(billMonth);
                cost.setCustId(cb.getCustId());
                cost.setCustName(cb.getCustName());
                cost.setRegionId(cb.getRegionId());
                cost.setRegionName(cb.getRegionName());
                cost.setContId(cb.getContId());
                cost.setUsedData(cb.getDataVal());
                cost.setExpData(0l);
                cost.setBillFee(cb.getAmount());
                cost.setTotalFee(cb.getAmount() + (cb.getOffFee() == null ? 0 : cb.getOffFee()));
                cost.setOffFee(cb.getOffFee() == null ? 0 : cb.getOffFee());
                cost.setDiscount(0);
                cost.setState(GlobalParamSet.getInteger(BizConstants.COST_BILL_STATE_NOT));
                cost.setIsInvcd(GlobalParamSet.getInteger(BizConstants.IS_INVCD_NOT));
                cost.setBegDate(new Date());
                cost.setCreateDate(new Date());
                cost.setExt1("100");
                logger.debug("【{}】合同首次入账更新入账数据",contId);
                rs = costBillMapper.insertSelective(cost);
            }
        }
        // 更新表的入账账期
        CustBill custBill = new CustBill();
        custBill.setBillMonth(billMonth);
        custBill.setBillState(GlobalParamSet.getInteger(BizConstants.CUST_BILL_STATE_INBILL));
        custBill.setBillDate(new Date());
        logger.debug("更新【{}】客户账单状态及账期",contId);
        rs += custBillExtMapper.updateBillMonthByCust(custBill, contId, billBatch);
        logger.debug("更新【{}】流量计费清单状态及账期",contId);
        rs += billRecExtMapper.updateBillMonthByCust(billMonth, contId, billBatch);
        logger.debug("更新【{}】流量分发记录状态及账期",contId);
        rs += dataRecExtMapper.updateBillMonthByCust(billMonth, GlobalParamSet.getInteger(BizConstants.OUT_BILL_STATE_IN), contId, billBatch);
        logger.debug("本次【{}】统计入账数据结束",contId);
        return rs;
    }

    /**
     * 收入摊分
     *
     * @param billMonth 入账账期
     * @param contId    客户
     * @param billBatch 出账批次数组
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int repartitionBill(String billMonth, String contId, String[] billBatch) {
        // 根据成本中心地区分摊客户收入
        int rs = 0;
        List<BillRec> recList = billRecExtMapper.selectBillRecByCust(contId, billBatch);
        if (recList.isEmpty()) {
            throw new BusinessException(ExInfo.create("F200200036", "合同"+"【"+contId+"】"+"计费清单数据异常!", "合同"+"【"+contId+"】"+"计费清单数据异常!"));
        }
        logger.debug("本次【{}】收入摊分开始",contId);
        // 获取所有地市的id
        List<Integer> regionIdList = regionExtMapper.selectRegionId();

        // 如果某客户的一些地市没有清单，则加入一条使用流量为0的清单。

        List<BillRec> addList = recList;

        for (Integer regionId : regionIdList) {
            boolean flag = false;
            for (BillRec rec : addList) {
                if (rec.getCostRegion().equals(regionId)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                BillRec rect = new BillRec();
                BeanUtils.copyProperties(recList.get(0), rect);
                rect.setCostRegion(regionId);
                rect.setBillFee(0l);
                rect.setTotalFee(0l);
                rect.setOffFee(0l);
                rect.setDiscount(0);
                rect.setDataVal(0l);
                recList.add(rect);
            }
        }
        List<CostBillItem> iList = new ArrayList<>();

        Double amount = 0.0;
        // 当前地市的入账摊分项
        CostBillItem curItem = new CostBillItem();

        // 根据客户ID获取摊分比例
       Contract contract= contractMapper.selectByPrimaryKey(contId);
        if(null==contract||StringUtil.isEmpty(contract.getCustId()))
        	throw new BizValidException(BizExInfoEnum.CONTRACT_NOT_FOUND);
        Cust cust = custMapper.selectByPrimaryKey(contract.getCustId());
        Double tanRate = Double.valueOf(cust.getExt1()) / 100;
        // 查看该账期客户是否有摊分如果有的话就在原来摊分上累加，没有则新增一条
        CostBillItemExample example = new CostBillItemExample();
        example.createCriteria().andBillMonthEqualTo(billMonth).andCustIdEqualTo(contract.getCustId());
        List<CostBillItem> costBillItems = costBillItemMapper
                .selectByExample(example);
        if (costBillItems.isEmpty())

        {
            amount = 0.0;
            // 根据比例计算各地区收入
            for (BillRec rec : recList) {
                CostBillItem item = new CostBillItem();
                item.setBillMonth(rec.getBillMonth());
                item.setCustId(rec.getCustId());
                item.setCustName(rec.getCustName());
                item.setRegionId(rec.getRegionId());
                item.setRegionName(rec.getRegionName());
                item.setCostRegion(rec.getCostRegion());
                item.setCostCenter(rec.getCostCenter());
                item.setBusiMode(rec.getBusiMode());
                item.setPayType(rec.getPayType());
                item.setContId(rec.getContId());
                item.setUsedData(rec.getDataVal());
                item.setExpData(0l);
                item.setBillFee(rec.getBillFee());
                item.setTotalFee(rec.getTotalFee());
                item.setOffFee(rec.getOffFee());
                item.setDiscount(rec.getDiscount());

                if (!rec.getRegionId().equals(rec.getCostRegion())) {
                    Long _total = rec.getBillFee();
                    Double amountTemp = _total * tanRate;// TODO
                    amount += amountTemp;
                    item.setIncome(_total - amountTemp.longValue());
                } else {
                    amount += rec.getBillFee();
                    curItem = item;
                }

                iList.add(item);
            }
            curItem.setIncome(amount.longValue());

            // 插入数据至客户收入摊分表
            logger.debug("【{}】本月首次入账收入摊入",contId);
            rs = costBillItemExtMapper.batchInsert(iList);
        } else {
            amount = 0.0;
            List<CostBillItem> belongItems = null;
            for (BillRec rec : recList) {
                if (rec.getRegionId().equals(rec.getCostRegion())) {
                    //取出合同归属地摊分
                    CostBillItemExample example_ = new CostBillItemExample();
                    example_.createCriteria().andBillMonthEqualTo(rec.getBillMonth())
                            .andCustIdEqualTo(rec.getCustId()).andCostRegionEqualTo(rec.getRegionId());
                    belongItems = costBillItemMapper
                            .selectByExample(example_);
                }
            }
            for (BillRec rec : recList) {
                CostBillItemExample _example = new CostBillItemExample();
                _example.createCriteria().andBillMonthEqualTo(rec.getBillMonth())
                        .andCustIdEqualTo(rec.getCustId()).andCostRegionEqualTo(rec.getCostRegion());
                List<CostBillItem> costBillItem = costBillItemMapper.selectByExample(_example);
                CostBillItem opItem = null;
                if (!costBillItem.isEmpty()) {
                    opItem = costBillItem.get(0);
                    CostBillItem belongItem = belongItems.get(0);            
                    curItem = belongItem;
                    opItem.setCostItemId(opItem.getCostItemId());
                    opItem.setBillFee(rec.getBillFee() + opItem.getBillFee());
                    opItem.setTotalFee(rec.getTotalFee() + opItem.getTotalFee());
                    opItem.setOffFee(0L);
                    opItem.setUsedData(rec.getDataVal()+opItem.getUsedData());
                    if (!rec.getRegionId().equals(rec.getCostRegion())) {
                        Long _total = rec.getBillFee();
                        Double amountTemp = _total * tanRate;// TODO
                       
                        amount += amountTemp;
                        opItem.setIncome(_total - amountTemp.longValue() + opItem.getIncome());
                    } else {
                        curItem.setBillFee(opItem.getBillFee());
                        curItem.setTotalFee(opItem.getTotalFee());
                        curItem.setUsedData(opItem.getUsedData());
                        amount += rec.getBillFee();
                        opItem.setCostItemId(opItem.getCostItemId());
                    }
                    logger.debug("【{}】本月多次入账更新非属地摊分",contId);
                    rs = costBillItemMapper.updateByPrimaryKeySelective(opItem);
                }
            }
            curItem.setIncome(amount.longValue() + curItem.getIncome());
            curItem.setCostItemId(curItem.getCostItemId());
            logger.debug("【{}】本月多次入账更新属地摊分",contId);
            rs += costBillItemMapper.updateByPrimaryKeySelective(curItem);
        }
        BillRecExample _example = new BillRecExample();
        _example.createCriteria().
                andContIdEqualTo(contId).andBillMonthEqualTo(billMonth).andBillBatchIn(Arrays.asList(billBatch));
        BillRec _billRec = new BillRec();
        _billRec.setState(200);
        logger.debug("【{}】更新流量计费清单入账状态",contId);
        rs += billRecMapper.updateByExampleSelective(_billRec, _example);
        logger.debug("本次【{}】收入摊分结束",contId);
        return rs;
    }

	@Override
	public int lockInbill(List<Long> billIdList) {
		CustBillExample example = new CustBillExample();
		example.createCriteria().andBillIdIn(billIdList);
		CustBill record = new CustBill();
		record.setBillState(400);
		
		return custBillMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int deblockingBill(List<Long> billIdList) {
		CustBillExample example = new CustBillExample();
		example.createCriteria().andBillIdIn(billIdList);
		CustBill record = new CustBill();
		record.setBillState(GlobalParamSet.getInteger(BizConstants.CUST_BILL_STATE_CONFIRMED));		
		return custBillMapper.updateByExampleSelective(record, example);
	}
}
