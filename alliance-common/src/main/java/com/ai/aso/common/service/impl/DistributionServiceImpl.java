/**
 * 
 */
package com.ai.aso.common.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ai.aso.common.bo.DataRecBo;
import com.ai.aso.common.db.dao.ContractBookMapper;
import com.ai.aso.common.db.dao.ContractItemMapper;
import com.ai.aso.common.db.dao.ContractMapper;
import com.ai.aso.common.db.dao.DataBookaMapper;
import com.ai.aso.common.db.dao.DataBookaStubMapper;
import com.ai.aso.common.db.dao.ext.DataBookaExtMapper;
import com.ai.aso.common.db.dao.ext.DataRecExtMapper;
import com.ai.aso.common.db.model.Contract;
import com.ai.aso.common.db.model.ContractBook;
import com.ai.aso.common.db.model.ContractBookExample;
import com.ai.aso.common.db.model.ContractExample;
import com.ai.aso.common.db.model.ContractItem;
import com.ai.aso.common.db.model.ContractItemExample;
import com.ai.aso.common.db.model.DataBooka;
import com.ai.aso.common.db.model.DataBookaExample;
import com.ai.aso.common.db.model.DataBookaStub;
import com.ai.aso.common.service.DistributionService;
import com.ai.aso.common.sequence.SequenceFactory;

/**
 * @ClassName: DistributionServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author caiwz
 * @date 2016-9-29 上午10:23:46
 * 
 */
@Service
public class DistributionServiceImpl implements DistributionService {
	@Autowired
	RechargeMsgSenderImpl rechargeMsgSenderImpl;
	
	@Autowired
	private SequenceFactory seq;
	
	@Autowired
	private ContractItemMapper contractItemMapper;
	
	@Autowired
	private ContractMapper contractMapper;

	@Autowired
	private ContractBookMapper contractBookMapper;

	@Autowired
	private DataBookaMapper dataBookaMapper;
	
	@Autowired
	private DataBookaExtMapper dataBookaExtMapper;
	
	@Autowired
	private DataRecExtMapper dataRecExtMapper;
	
	@Autowired
	private DataBookaStubMapper dataBookaStubMapper;
	Logger log = LoggerFactory.getLogger(DistributionServiceImpl.class);
	/**
	 * 查询商品类型、规格
	 */
	@Override
	public List<ContractItem> getGoodsItem(String cont_id) {
		// TODO Auto-generated method stub
		ContractItemExample example = new ContractItemExample();
		example.createCriteria().andContIdEqualTo(cont_id);
		example.setOrderByClause("GOODS_SPECS");
		return contractItemMapper.selectByExample(example);
	}

	@Override
	public List<ContractItem> getGoodsItemByUserId(String custId) {
		// TODO Auto-generated method stub
		Contract c = getContract(custId);
		if( c != null )
		{
			return getGoodsItem(c.getContId());
		}
		return null;
	}

	@Override
	public Contract getContract(String custId) {
		// TODO Auto-generated method stub
		ContractExample example = new ContractExample();
		example.createCriteria().andCustIdEqualTo(custId)
								.andStateEqualTo(1)//合同状态生效
								.andEffDateLessThanOrEqualTo(new Date())//当前日期大于等于生效日期
								.andExpDateGreaterThan(new Date());//当前日期小于失效日期
		List<Contract> cont = contractMapper.selectByExample(example);
		if( cont != null && cont.size() > 0 )
		{
			return cont.get(0);
		}
		return null;
	}

	@Override
	public boolean checkGoods(List<DataRecBo> list,
			List<ContractItem> basedata) {
		// TODO Auto-generated method stub
		log.info("校验商品入参{},{}",list,basedata.get(0).getGoodsId());
		if (list == null || list.size() == 0)
			return false;
		// 1.根据合同编号获取商品类型和商品规格
		if (basedata == null || basedata.size() == 0)
			return false;
		// 2.页面输入商品校验
		log.info("校验商品入参结果：", basedata.containsAll(list));
		return basedata.containsAll(list);
	}

	@Override
	public List<DataRecBo> improveGoodsInfo(String cust_id,List<DataRecBo> list,
			List<ContractItem> basedata,String region_id,String cont_no) {
		Long batchNo = seq.nextLong("sqName_bacthNo");
		List<String> sqlList = seq.next("sqName_dataRec", list.size());
		log.info("充值入参{},{},{},{}",batchNo,cust_id,basedata.get(0).getGoodsId(),cont_no);
		for (int i = 0; i < list.size(); i++) {
			DataRecBo bo = list.get(i);
			for (int j = 0; j < basedata.size(); j++) {
				ContractItem ci = basedata.get(j);
				log.info("合同项和入参比较：{}",bo.equals(ci));
				if (bo.equals(ci)) {
					
					bo.setGoodsId(ci.getGoodsId());
					bo.setGoodsName(ci.getGoodsName());
					bo.setGoodsType(ci.getGoodsType());
					bo.setDataType(ci.getDataType());
					bo.setDataVal(ci.getGoodsSpecs());// 额度   = 规格
					bo.setTotalFee((long)ci.getUnitPrice());//原价
					bo.setDiscount(ci.getOffRate());//折扣
					bo.setBillFee((long)ci.getUnitPrice() * (long)ci.getOffRate() / 100l);//折扣后的实际费用
					bo.setContId(ci.getContId());
					bo.setCustId(cust_id);
					bo.setBusiMode(100);
					bo.setRecNo(sqlList.get(i));
					bo.setBatchCode(batchNo);
					bo.setState((short)0);
					bo.setCreateDate(new Date());
					bo.setBillRule(0);
					bo.setVer(0);
					bo.setOfferId(ci.getExt1());
					bo.setRegionId(region_id);
					bo.setBillState(100);
					break;
				}
			}
		}

		return list;
	}

	@Override
	public long getContractBookBalance(String cont_id) {
		// TODO Auto-generated method stub
		log.info("合同账本余额：{}",cont_id);
		ContractBookExample example = new ContractBookExample();
		example.createCriteria().andContIdEqualTo(cont_id);
		List<ContractBook> list = contractBookMapper.selectByExample(example);
		long value = 0l;
		for (ContractBook book : list) {
			if (book.getBookType() == 200 || book.getBookType() == 300) {
				value += book.getAmount();
			}
		}
		return value;
	}

	@Override
	public boolean checkBalance(List<DataRecBo> list,
			long contractBookLimit, long dataBookLimit) {
		// TODO Auto-generated method stub
		long balance = 0l;
		for (int i = 0; i < list.size(); i++) {
			DataRecBo bo = list.get(i);
			balance += bo.getBillFee();
			if (balance + dataBookLimit > contractBookLimit) {
				return false;
			}
		}
		return true;
	}

	@Override
	public long countPrice(List<DataRecBo> list) {
		// TODO Auto-generated method stub
		long balance = 0l;
		for (int i = 0; i < list.size(); i++) {
			DataRecBo bo = list.get(i);
			balance += bo.getBillFee();
		}
		return balance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ai.aso.biz.service.DistributionService#getDataBookBalance(java.lang
	 * .String)
	 */
	@Override
	public long getDataBookBalance(String cont_id) {
		// TODO Auto-generated method stub
		DataBookaExample example = new DataBookaExample();
		example.createCriteria().andContIdEqualTo(cont_id);
		List<DataBooka> list = dataBookaMapper.selectByExample(example);
		long value = 0l;
		if (list != null && list.size() > 0) {
			DataBooka db = list.get(0);
			// 返回量本累计额 value = a.getAcct
			value = db.getCumuVal();
		}
		return value;
	}

	@Override
	public DataBooka getDataBook(String cont_id) {
		// TODO Auto-generated method stub
		DataBookaExample example = new DataBookaExample();
		example.createCriteria().andContIdEqualTo(cont_id);
		List<DataBooka> list = dataBookaMapper.selectByExample(example);
		DataBooka db = list.get(0);
		return db;
	}

	/*
	 * (non-Javadoc)
	 * 更新量本
	 * @see
	 * com.ai.aso.biz.service.DistributionService#updateDataBookBalance(long)
	 */
	@Override
	public void updateDataBookBalance(String cont_id, long amount) {
		// TODO Auto-generated method stub
		DataBooka db = getDataBook(cont_id);
		dataBookaExtMapper.updateDataBooka(cont_id, db.getVer(), amount);
	}

	@Override
	public void insertDistribution(List<DataRecBo> list) {
		// TODO Auto-generated method stub
		dataRecExtMapper.batchInsert(list);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	protected void intoDatabase(String cont_id, long amount,List<DataRecBo> list){
		int size = list.size();
		int step = 1000;
		int mod = (size % step == 0 ? size / step : size /step + 1);
		int start,end=0;
		if( size > step )
		{
			for ( int i = 0;i< mod;i++ )
			{
				start = i*step;
				if( i == mod-1 )
				{
					end = size;
				}
				else
				{
					end = (i+1)*step;
				}
				insertDistribution(list.subList(start,end));
			}
		}
		else
		{
			insertDistribution(list);
		}
		updateDataBookBalance(cont_id,amount);
	}

	@Override
	public void aggregation(String cont_id, long amount,List<DataRecBo> list) {
		// TODO Auto-generated method stub
		intoDatabase(cont_id,amount,list);
		rechargeMsgSenderImpl.sendMsgToActiveQ(list);
	}

	@Override
	public long getRemaining(String cont_id) {
		// TODO Auto-generated method stub
		return dataRecExtMapper.getRemaining(cont_id) == null ? 0 : dataRecExtMapper.getRemaining(cont_id);
	}

	@Override
	public long getRemainingCheckContract(String cont_id) {
		
		// TODO Auto-generated method stub
		
		ContractExample example = new ContractExample();
		example.createCriteria().andContIdEqualTo(cont_id)
								.andStateEqualTo(1)//合同状态生效
								.andEffDateLessThanOrEqualTo(new Date())//当前日期大于等于生效日期
								.andExpDateGreaterThan(new Date());//当前日期小于失效日期
		List<Contract> cont = contractMapper.selectByExample(example);
		if( cont == null || cont.size() == 0 )
		{
			return 0l;
		}
		
		return getRemaining(cont_id);
	}
	
	@Override
	public int updateDataRecState(String rec_no, int state) {
		// TODO Auto-generated method stub
		return dataRecExtMapper.dataRecUpdateState(rec_no, state);
	}

	@Override
	public int updateDataBookaReduce(String cont_id, long amount) {
		// TODO Auto-generated method stub
		return dataBookaExtMapper.updateDataBookaReduce(cont_id, amount);
	}

	@Override
	@Transactional
	public int reduceDataBooka(String cont_id, long amount, String rec_no,
			int state) {
		// TODO Auto-generated method stub
		
		return updateDataRecState(rec_no,state)
				& updateDataBookaReduce(cont_id,amount) 
				& reduceDataRecStub(cont_id,amount,rec_no);
	}

	private int reduceDataRecStub(String cont_id, long amount, String rec_no){
		DataBookaStub dbs = new DataBookaStub();
		dbs.setRecNo(rec_no);
		dbs.setBookId(cont_id);
		dbs.setBackDate(new Date());
		dbs.setBackType(1000);
		dbs.setAmount(amount);
		return dataBookaStubMapper.insert(dbs);
	}
	
	@Override
	public int crmSuccResult(DataRecBo bo) {
		// TODO Auto-generated method stub
		return dataRecExtMapper.crmResultUpdate(bo);
	}

	@Override
	@Transactional
	public int crmFieldResult(DataRecBo bo) {
		// TODO Auto-generated method stub
		return dataRecExtMapper.crmResultUpdate(bo) & updateDataBookaReduce(bo.getContId(),bo.getBillFee());
	}
	
}
