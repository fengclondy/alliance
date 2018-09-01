package com.ai.aso.common.component.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.aso.common.component.CostBillItemComp;
import com.ai.aso.common.db.dao.CustMapper;
import com.ai.aso.common.db.dao.ext.BillRecExtMapper;
import com.ai.aso.common.db.dao.ext.CostBillItemExtMapper;
import com.ai.aso.common.db.dao.ext.RegionExtMapper;
import com.ai.aso.common.db.model.BillRec;
import com.ai.aso.common.db.model.CostBillItem;
import com.ai.aso.common.db.model.Cust;

@Service
public class CostBillItemCompImpl implements CostBillItemComp {

    @Autowired
    private BillRecExtMapper billRecExtMapper;
    @Autowired
    private CostBillItemExtMapper costBillItemExtMapper;
    @Autowired
    private RegionExtMapper regionExtMapper;
    @Autowired
    private CustMapper custMapper;

    @Override
    public void repartitionBill(String billMonth) {
        // 根据成本中心地区分摊客户收入
        // 取出所有入账清单
        List<BillRec> recList = billRecExtMapper
                .selectBillRecGroupRegion(billMonth);
        // 把入账清单按客户进行分组
        Map<String, List<BillRec>> map = new HashMap<String, List<BillRec>>();
        for (BillRec rec : recList) {
            if (map.containsKey(rec.getCustId())) {
                map.get(rec.getCustId()).add(rec);
            } else {
                List<BillRec> temp = new ArrayList<BillRec>();
                temp.add(rec);
                map.put(rec.getCustId(), temp);
            }
        }

        // 获取所有地市的id
        List<Integer> regionIdList = regionExtMapper.selectRegionId();
        // 如果某客户的一些地市没有清单，则加入一条使用流量为0的清单。
        for (String key : map.keySet()) {
            List<BillRec> tlist = map.get(key);

            List<BillRec> addList = tlist;

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
                    BeanUtils.copyProperties(tlist.get(0), rect);
                    rect.setCostRegion(regionId);
                    rect.setBillFee(0l);
                    rect.setTotalFee(0l);
                    rect.setOffFee(0l);
                    rect.setDiscount(0);
                    rect.setDataVal(0l);
                    tlist.add(rect);
                }
            }
        }

        List<CostBillItem> iList = new ArrayList<CostBillItem>();

        for (String key : map.keySet()) {
            List<BillRec> tt = map.get(key);
            Double amount = 0.0;
            // 当前地市的入账摊分项
            CostBillItem curItem = new CostBillItem();

            // 根据客户ID获取摊分比例
            Cust cust = custMapper.selectByPrimaryKey(key);
            Double tanRate = Double.valueOf(cust.getExt1()) / 100;

            // 根据比例计算各地区收入
            for (BillRec rec : tt) {
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
                    Double amountemp = _total * tanRate;// TODO
                    amount += amountemp;
                    item.setIncome(_total - amountemp.longValue());
                } else {
                    amount += rec.getBillFee();
                    curItem = item;
                }

                iList.add(item);
            }
            curItem.setIncome(amount.longValue());
        }

        // 插入数据至客户收入摊分表
        costBillItemExtMapper.batchInsert(iList);

    }

}
