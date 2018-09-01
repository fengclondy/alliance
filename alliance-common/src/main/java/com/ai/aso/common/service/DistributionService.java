/**
 * 
 */
package com.ai.aso.common.service;

import java.util.List;

import com.ai.aso.common.bo.DataRecBo;
import com.ai.aso.common.db.model.Contract;
import com.ai.aso.common.db.model.ContractItem;
import com.ai.aso.common.db.model.DataBooka;

/** 
 * @ClassName: DistributionService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author caiwz
 * @date 2016-9-29 上午10:02:55
 *  涉及表： 合同流量信息  合同账本  分销量本 分销表
 */
public interface DistributionService {
	
	public class State {
//		状态：0 未处理；1 处理中；2 充值成功；3 超时待确认；-1 充值失败；
		public static final int ST_FAILD = -1;
		public static final int ST_NO_DEAL = 0;
		public static final int ST_DEALING = 1;
		public static final int ST_SUCCESS = 2;
		public static final int ST_TIMEOUT = 3;
	} 
	
	/**
	 * 获取所有商品类型、规格
	 * @param cont_id
	 * @return
	 */
    public List<ContractItem> getGoodsItem(String cont_id);
    
    /**
     * 
     * @param custId
     * @return
     */
    public List<ContractItem> getGoodsItemByUserId(String custId);
	/**
	 * 校验商品类型和规格
	 * @return
	 */
	public boolean checkGoods(List<DataRecBo> list, List<ContractItem> basedata);
	
	/**
	 * 增强充值输入信息
	 * 
	 */
	public List<DataRecBo> improveGoodsInfo(String cust_id, List<DataRecBo> list, List<ContractItem> basedata, String region_id, String cont_no);
	
	/**
	 * 根据合同id获取合同账本可用额度
	 * @param cont_id
	 * @return
	 */
	public long getContractBookBalance(String cont_id);
	
	/**
	 * 根据合同id获取分销量本累计额
	 * @param cont_id
	 * @return
	 */
	public long getDataBookBalance(String cont_id);
	
	/**
	 * 校验余额
	 * 
	 * 根据充值商品列表 和 合同额、量本累计额 校验 可用余额 
	 * @return
	 */
	public boolean checkBalance(List<DataRecBo> list, long contractBookLimit, long dataBookLimit);
	
	/**
	 * 计算分销冲量
	 * @param list
	 * @return
	 */
	public long countPrice(List<DataRecBo> list);
	
	/**
	 * 分销数据入库
	 */
	public void insertDistribution(List<DataRecBo> list);
	
	/**
	 * 获取量本信息
	 * @param cont_id
	 * @return
	 */
	public DataBooka getDataBook(String cont_id);
	
	/**
	 * 更新量本额度
	 */
	public void updateDataBookBalance(String cont_id, long amount);
	
	/**
	 * 分销操作聚合
	 */
	public void aggregation(String cont_id, long amount, List<DataRecBo> list);
	
	
	/**
	 * 
	 * 获取合同
	 * @param custId
	 * @return
	 */
	public Contract getContract(String custId);
	
	/**
	 * 
	 * 获取可用余额
	 * @param cont_id //可用合同编号
	 * 
	 */
	public long getRemaining(String cont_id);
	
	/**
	 * 
	 * 
	 * @param rec_no
	 * @param state 状态：0 未处理；1 处理中；2 充值成功；3 超时待确认；-1 充值失败；
	 * @return
	 */
	public int updateDataRecState(String rec_no, int state);
	
	/**
	 * 
	 * @param cont_id
	 * @param amount
	 * @return
	 */
	public int updateDataBookaReduce(String cont_id, long amount);
	
	public int reduceDataBooka(String cont_id, long amount, String rec_no, int state);
	/**
	 * 
	 * @param cont_id
	 * @return
	 */
	public long getRemainingCheckContract(String cont_id);
	
	public int crmSuccResult(DataRecBo bo);
	
	public int crmFieldResult(DataRecBo bo);
}
