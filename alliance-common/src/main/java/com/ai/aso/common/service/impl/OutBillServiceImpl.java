package com.ai.aso.common.service.impl;

import com.ai.aso.base.exception.ExInfo;
import com.ai.aso.base.utils.StringUtil;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.db.dao.BillRecMapper;
import com.ai.aso.common.db.dao.ContractBookMapper;
import com.ai.aso.common.db.dao.ContractMapper;
import com.ai.aso.common.db.dao.CustBillMapper;
import com.ai.aso.common.db.dao.CustMapper;
import com.ai.aso.common.db.dao.DataBookaMapper;
import com.ai.aso.common.db.dao.DataRecMapper;
import com.ai.aso.common.db.dao.RegionMapper;
import com.ai.aso.common.db.dao.ext.BillExtMapper;
import com.ai.aso.common.db.dao.ext.BillRecExtMapper;
import com.ai.aso.common.db.dao.ext.CustBillExtMapper;
import com.ai.aso.common.db.model.BillRec;
import com.ai.aso.common.db.model.BillRecExample;
import com.ai.aso.common.db.model.Contract;
import com.ai.aso.common.db.model.ContractBook;
import com.ai.aso.common.db.model.ContractBookExample;
import com.ai.aso.common.db.model.Cust;
import com.ai.aso.common.db.model.CustBill;
import com.ai.aso.common.db.model.CustBillExample;
import com.ai.aso.common.db.model.DataBooka;
import com.ai.aso.common.db.model.DataBookaExample;
import com.ai.aso.common.db.model.DataRec;
import com.ai.aso.common.db.model.DataRecExample;
import com.ai.aso.common.db.model.Region;
import com.ai.aso.common.db.model.RegionExample;
import com.ai.aso.common.exception.BizValidException;
import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.common.service.OutBillService;
import com.ai.aso.common.utils.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 客户出账
 * <p>description:</p>
 *
 * @author lw
 * @2017/5/4
 */
@Service
public class OutBillServiceImpl implements OutBillService {
	private Logger logger = LoggerFactory.getLogger(OutBillServiceImpl.class);

    @Autowired
    private DataRecMapper dataRecMapper;
    @Autowired
    private CustBillExtMapper custBillExtMapper;
    @Autowired
    private BillExtMapper billExtMapper;
    @Autowired
    private BillRecExtMapper billRecExtMapper;
    @Autowired
    private CustMapper custMapper;
    @Autowired
    private RegionMapper regionMapper;
    @Autowired
    private BillRecMapper billRecMapper;
    @Autowired
    private ContractBookMapper contractBookMapper;
    @Autowired
    private DataBookaMapper dataBookaMapper;
    @Autowired
    private CustBillMapper custBillMapper;
    @Autowired
    private ContractMapper contractMapper;

    @Override
    public Map<String, List<DataRec>> groupingBill(String billBatch) {
        Map<String, List<DataRec>> dataRecMap = new HashMap<>();
        DataRecExample example = new DataRecExample();
        //是否已出账，余额
        List<String> contIds = checkOutBill();
        if(contIds.isEmpty())
        	return dataRecMap;      
        List<Integer> billState=new ArrayList<>();
        billState.add(GlobalParamSet.getInteger(BizConstants.OUT_BILL_STATE_NOT));
        billState.add(GlobalParamSet.getInteger(BizConstants.OUT_BILL_STATE_ING));
        example.createCriteria()
                .andBillStateIn(billState)
                .andContIdIn(contIds);
        List<DataRec> dataRecList = dataRecMapper.selectByExample(example);
        for (DataRec dataRec : dataRecList) {
            String contId = dataRec.getContId();

            if (dataRecMap.containsKey(contId)) {
                dataRecMap.get(contId).add(dataRec);
            } else {
                List<DataRec> _dataRecList = new ArrayList<>();
                _dataRecList.add(dataRec);
                dataRecMap.put(contId, _dataRecList);
            }
        }
        return dataRecMap;
    }

    /**
     * 获取本次出账批次
     *
     * @return
     */
    @Override
    public String findNewBillBatch() {
        // 从数据库中获取批次
        String batch = custBillExtMapper.selectNewbillBatch();
        logger.debug("上次出账批次为：【{}】", batch);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        String month = sdf.format(new Date());

        String newBatch = "";
        if (StringUtils.isEmpty(batch)) {
            newBatch = month.concat("01");
            return newBatch;
        }

        String lastMonth = batch.substring(0, 6);
        if (lastMonth.equals(month)) {
            newBatch = String.valueOf(Integer.valueOf(batch) + 1);
        } else {
            newBatch = month.concat("01");
        }
        return newBatch;
    }

    /**
     * 锁定本次出账的充值记录
     * @param contId
     * @param billBatch
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int lockBillDataRec(String contId, String billBatch) {
        DataRec dataRec = new DataRec();
        dataRec.setBillBatch(billBatch);
        dataRec.setBillState(GlobalParamSet.getInteger(BizConstants.OUT_BILL_STATE_ING));
        // 锁定充值失败记录
        DataRecExample _example1 = new DataRecExample();
        _example1
                .createCriteria()
                .andBillStateEqualTo(GlobalParamSet.getInteger(BizConstants.OUT_BILL_STATE_NOT))
                .andStateEqualTo((short) -1).andContIdEqualTo(contId)
                .andEndDateLessThan(DateTimeUtil.getBeginDate(new Date()));
        int fCount = dataRecMapper.updateByExampleSelective(dataRec, _example1);
        List<Integer> billState=new ArrayList<>();
        billState.add(GlobalParamSet.getInteger(BizConstants.OUT_BILL_STATE_NOT));
        billState.add(GlobalParamSet.getInteger(BizConstants.OUT_BILL_STATE_ING));
        logger.debug("本次{}出账中充值失败的记录数有：{}条，这些记录不需要抽取，仅标识出账状态", contId, fCount);

        // 锁定充值成功记录
        DataRecExample _example2 = new DataRecExample();
        _example2
                .createCriteria()
                .andBillStateIn(billState)                		
                .andStateEqualTo((short) 2)
                .andContIdEqualTo(contId)
                .andEndDateLessThan(DateTimeUtil.getBeginDate(new Date()));
        int count = dataRecMapper.updateByExampleSelective(dataRec, _example2);
        logger.debug("本次{}出账中充值成功的记录数有：{}条", contId, count);
        return count;
    }

    /**
     * 抽取本次出账成功充值记录，并进行计费摊分处理
     * @param contId
     * @param billBatch
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void billingRec(String contId, String billBatch) {

        int count = billExtMapper.ObtainBillRec(contId, billBatch);
        logger.warn("本次{}出账抽取记录数为：{}", contId,count);
        if (count == 0) {
            return;
        }
       Contract contract= contractMapper.selectByPrimaryKey(contId);
       if(null==contract||StringUtil.isEmpty(contract.getCustId()))
    	  throw new BizValidException(ExInfo.create("F20001700522", contId+"合同数据异常", contId+"合同数据异常")); 
    	   String custId=contract.getCustId();
        // 处理地区名称
        RegionExample example = new RegionExample();
        List<Region> regionList = regionMapper.selectByExample(example);
        for (Region region : regionList) {
            if (GlobalParamSet.getInteger(BizConstants.PROVINCE_ADMIN_REGION) == region.getRegionId()) {
                continue;
            }
            // 更新合同地区名称
            BillRec billRec = new BillRec();
            billRec.setCustId(custId);
            billRec.setRegionName(region.getRegionName());
            BillRecExample billRecExample = new BillRecExample();
            billRecExample.createCriteria().andBillBatchEqualTo(billBatch).andContIdEqualTo(contId)
                    .andRegionIdEqualTo(region.getRegionId());
            billRecMapper.updateByExampleSelective(billRec, billRecExample);
            // 更新充值地区名称
            BillRec billRec2 = new BillRec();
            billRec2.setCostRegionName(region.getRegionName());
            BillRecExample billRecExample2 = new BillRecExample();
            billRecExample2.createCriteria().andBillBatchEqualTo(billBatch).andContIdEqualTo(contId)
                    .andCostRegionEqualTo(region.getRegionId());
            billRecMapper.updateByExampleSelective(billRec2, billRecExample2);
        }

        // 处理
        List<BillRec> billRecList = billRecExtMapper
                .queryBillRecByCont(billBatch, contId);
        List<CustBill> cbList = new ArrayList<CustBill>();
        for (BillRec rec : billRecList) {
            Cust cust = custMapper.selectByPrimaryKey(custId);
            billExtMapper.updateCostRateCont(billBatch, contId,
                    cust.getCustName(), Integer.parseInt(cust.getExt1()));

            // 账单统计
            CustBill cb = new CustBill();
            cb.setCustId(custId);
            cb.setCustName(cust.getCustName());
            cb.setRegionId(rec.getRegionId());
            cb.setRegionName(rec.getRegionName());
            // cb.setBillDesc(rec.getbil);
            cb.setDataVal(rec.getDataVal());
            cb.setAmount(rec.getBillFee());
            cb.setOweFee(0l);
            // cb.setDiscount(rec.getDiscount());
            cb.setOffFee(0l);
            cb.setBillBatch(billBatch);
            cb.setBillState(GlobalParamSet.getInteger(BizConstants.CUST_BILL_STATE_UNCONFIRM));
            cb.setContId(rec.getContId());
            cb.setPayType(rec.getPayType());
            cb.setCreateDate(new Date());

            cbList.add(cb);
        }
        custBillExtMapper.batchInsert(cbList);
    }

    /**
     * 更新出账批次状态
     * @param contId
     * @param billBatch
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void completeBillState(String contId, String billBatch) {
        DataRec dataRec = new DataRec();
        dataRec.setBillState(GlobalParamSet.getInteger(BizConstants.OUT_BILL_STATE_OK));
        DataRecExample example = new DataRecExample();
        example.createCriteria()
                .andBillStateEqualTo(GlobalParamSet.getInteger(BizConstants.OUT_BILL_STATE_ING))
                .andBillBatchEqualTo(billBatch).andContIdEqualTo(contId);
        dataRecMapper.updateByExampleSelective(dataRec, example);
        logger.warn("本次{}客户完成{}出账状态更新", contId,billBatch);
    }

    /**
     * 获取存在余额的合同
     * @return
     */
    private List<String> checkCurrBalance() {
        List<String> contIds = null;
        ContractBookExample example = new ContractBookExample();
        example.createCriteria()
                .andBookTypeEqualTo(GlobalParamSet.getShort(BizConstants.CONTRACT_BOOK_TYPE_PAYMENT)).andStateEqualTo(GlobalParamSet.getInteger(BizConstants.CONTRACT_BOOK_STATE_NORMAL));
        List<ContractBook> contractBooks = contractBookMapper
                .selectByExample(example);
        if (null != contractBooks && contractBooks.size() > 0) {
            contIds = new ArrayList<>();
            for (ContractBook contractBook : contractBooks) {
                DataBookaExample example2 = new DataBookaExample();
                example2.createCriteria().andContIdEqualTo(contractBook.getContId());
                List<DataBooka> dataBookas = dataBookaMapper
                        .selectByExample(example2);
                // 总使用金额
                Long cumuVal = 0l;
                if (!dataBookas.isEmpty()) {
                    cumuVal = dataBookas.get(0).getCumuVal();
                }
                Double currentVal = (contractBook.getAmount() - cumuVal) / 1000.000;
                if (currentVal > 0) {
                    contIds.add(contractBook.getContId());
                }
            }

        }
        return contIds;
    }

    /**
     * 是否已出账
     *
     * @return
     */
    private List<String> checkOutBill() {
        List<String> contIds = checkCurrBalance();
        // 根据当前时间获取入账账期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        String billMonth = sdf.format(new Date());
        if (null != contIds && !contIds.isEmpty()) {
            CustBillExample _example = new CustBillExample();
            CustBillExample.Criteria criteria = _example.createCriteria();
            CustBillExample.Criteria _criteria = _example.createCriteria();
            criteria.andBillMonthIsNull().andBillBatchLike("%" + billMonth + "%");
            _criteria.andBillMonthEqualTo(billMonth);

            _example.or(_criteria);
            List<CustBill> custBills = custBillMapper.selectByExample(_example);
            if (!custBills.isEmpty()) {
                List<String> _contList = new ArrayList<>();
                for (CustBill custBill : custBills) {
                    _contList.add(custBill.getContId());
                }
                for (int i = 0; i < contIds.size(); i++) {
                    String contId = contIds.get(i);
                    for (int j = 0; j < _contList.size(); j++) {
                        String _cont = _contList.get(j);
                        if (contId.equals(_cont)) {
                            contIds.remove(i);
                            i--;
                        }
                    }
                }
            }
        }
        return contIds;
    }
}