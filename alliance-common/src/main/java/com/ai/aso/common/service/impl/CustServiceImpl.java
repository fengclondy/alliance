package com.ai.aso.common.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.aso.base.exception.BusinessException;
import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.base.utils.ChineseToHanYuPY;
import com.ai.aso.base.utils.StringUtil;
import com.ai.aso.common.component.AcctRoleComp;
import com.ai.aso.common.component.CustComp;
import com.ai.aso.common.component.LoginAcctComp;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.db.dao.AcctRoleMapper;
import com.ai.aso.common.db.dao.CustMapper;
import com.ai.aso.common.db.model.Cust;
import com.ai.aso.common.db.model.CustExample;
import com.ai.aso.common.exception.BizExInfoEnum;
import com.ai.aso.common.exception.NoAccessException;
import com.ai.aso.common.service.CustService;
import com.ai.aso.common.service.LoginAcctService;
import com.ai.aso.common.service.UserService;
import com.ai.aso.common.sequence.SequenceFactory;

@Service
public class CustServiceImpl implements CustService {

	@Autowired
	private CustComp custComp;
	@Autowired
	private LoginAcctComp loginAcctComponent;
	@Autowired
	private CustMapper custMapper;
	@Autowired
	private SequenceFactory sequenceFactory;
	@Autowired
	private AcctRoleMapper acctRoleMapper;
	@Autowired
	private AcctRoleComp acctRoleComp;
	@Autowired
	private UserService userService;

	@Autowired
	private LoginAcctService loginAcctService;

	@Override
	public List<Cust> findCustListByRegionId(String regionId) {
		if (StringUtil.isEmpty(regionId)) {
			return null;
		} else {
			CustExample example = new CustExample();
			example.createCriteria().andRegionIdEqualTo(regionId).andValidFlagEqualTo((short)1);
			return custMapper.selectByExample(example);
		}

	}

/*	@Override
	public List<CustBo> findCustListByRegion(String regionId) {
		return custComp.findCustByRegionId(regionId);
	}*/

	@Override
	@Transactional(value = "mysqlTransactionManager", rollbackFor = Exception.class)
	public String addCust(Cust cust) {
		String acctId = loginAcctService.addCustAcct(cust.getCrmUserCode());
		cust.setAcctId(acctId);

		// 调用sequence 获取主键ID
		String custId = sequenceFactory.next(BizConstants.SEQ_KEY_CUST);
		cust.setCustId(custId);
		cust.setCustNamePy(ChineseToHanYuPY.convertChineseToPinyin(cust.getCustName()));
		cust.setState(GlobalParamSet.getShort(BizConstants.CUST_STATE_ENABLED));
		cust.setValidFlag(GlobalParamSet.getShort(BizConstants.CUST_VALID_FLAG_ENABLED));
		cust.setCreateDate(new Date());
		cust.setModiDate(new Date());
		cust.setOperFlag(GlobalParamSet.getShort(BizConstants.CUST_OPER_FLAG_NEW));
		custMapper.insertSelective(cust);
		return custId;
	}

	@Override
	@Transactional(value = "mysqlTransactionManager", rollbackFor = Exception.class)
	public void modifyCust(Cust cust, String managerId) {
		custMapper.updateByPrimaryKeySelective(cust);
	}

	@Override
	@Transactional
	public void removeCustById(String custId, String managerId) {
		// 校验managerId是否拥有操作权限
		custComp.removeCustById(custId);
	}

	@Override
	public Cust findCustByCustId(String custId) {
		if (StringUtil.isNotEmpty(custId)) {
			return custMapper.selectByPrimaryKey(custId);
		}

		return null;
	}

	@Override
	public Cust findCustByAcctId(String acctId) {
		if (StringUtil.isNotEmpty(acctId)) {
			CustExample example = new CustExample();
			example.createCriteria().andAcctIdEqualTo(acctId).andValidFlagEqualTo((short)1);
			List<Cust> custList = custMapper.selectByExample(example);
			if (null != custList && custList.size() > 0) {
				return custList.get(0);
			}
		}

		return null;
	}

	@Override
	public Cust findCustByUserCode(String crmUserCode) {
		if (StringUtil.isNotEmpty(crmUserCode)) {
			CustExample example = new CustExample();
			example.createCriteria().andCrmUserCodeEqualTo(crmUserCode);
			List<Cust> custList = custMapper.selectByExample(example);
			if (null != custList && custList.size() > 0) {
				return custList.get(0);
			}
		}

		return null;
	}

	@Override
	public List<Cust> findCustListByCustNameLike(String custName, String regionId) {
		CustExample example = new CustExample();

		CustExample.Criteria c1 = example.createCriteria();
		c1.andCustNameLike(StringUtil.insertSpliterBothSide(custName, "%"));
		if (StringUtil.isNotEmpty(regionId)) {
			c1.andRegionIdEqualTo(regionId);
		}
		c1.andValidFlagEqualTo((short)1);
		CustExample.Criteria c2 = example.createCriteria();
		c2.andCustNamePyLike(StringUtil.insertSpliterBothSide(custName, "%"));
		if (StringUtil.isNotEmpty(regionId)) {
			c2.andRegionIdEqualTo(regionId);
		}
		c2.andValidFlagEqualTo((short)1);
		example.or(c2);

		List<Cust> custList = custMapper.selectByExample(example);
		return custList;
	}

	@Override
	public boolean authView(String custId, String userId) {
		Cust cust = findCustByCustId(custId);
		List<Integer> roles = acctRoleComp.selectByAcctId(userId);
		// 校验user与客户是否对应，或者是省级管理员
		if (userId.equals(String.valueOf(cust.getManagerId()))
				|| (roles.size() > 0 && roles.contains(GlobalParamSet.getInteger(BizConstants.PROVINCIAL_ROLE_ID)))) {
			return true;
		} else {
			throw new NoAccessException();
		}
	}
	
	public void checkCustRegion(String custId, String regionId) {
		// 校验是不是本地市客户
		Cust cust = findCustByCustId(custId);
		if (null != cust && StringUtil.isNotEmpty(cust.getRegionId())) {
			if (!cust.getRegionId().equals(regionId)) {
				// 用户不属于该地区
				throw new BusinessException(BizExInfoEnum.VALIDATE_CUST_NOT_IN_REGION);
			}
		} else {
			// 客户不存在或者资料不全
			throw new BusinessException(BizExInfoEnum.VALIDATE_CUST_NO_EXIST);
		}
	}

}
