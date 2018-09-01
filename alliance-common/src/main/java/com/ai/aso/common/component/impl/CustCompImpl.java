package com.ai.aso.common.component.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.aso.base.constants.SysConstants;
import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.base.utils.StringUtil;
import com.ai.aso.common.bo.CustBo;
import com.ai.aso.common.bo.LoginAcctInfo;
import com.ai.aso.common.component.CustComp;
import com.ai.aso.common.component.LoginAcctComp;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.db.dao.CustExtMapper;
import com.ai.aso.common.db.dao.CustMapper;
import com.ai.aso.common.db.dao.UserMapper;
import com.ai.aso.common.db.model.Cust;
import com.ai.aso.common.db.model.CustExample;
import com.ai.aso.common.db.model.CustExample.Criteria;
import com.ai.aso.common.db.model.CustExt;
import com.ai.aso.common.db.model.CustExtExample;
import com.ai.aso.common.db.model.LoginAcct;
import com.ai.aso.common.db.model.LoginName;
import com.ai.aso.common.db.model.Role;
import com.ai.aso.common.exception.CustValidedException;
import com.ai.aso.common.exception.NoAccessException;
import com.ai.aso.common.service.ManagerService;
import com.ai.aso.common.sequence.SequenceFactory;

@Component
public class CustCompImpl implements CustComp {
	
	@Autowired
	private CustMapper custMapper;
	@Autowired
	private CustExtMapper custExtMapper;
	@Autowired
	private LoginAcctComp loginAcctComp;
	@Autowired
	private SequenceFactory sequenceFactory;
	@Autowired
	private ManagerService managerService;
	@Autowired
	private UserMapper userMapper;
	
	
	
	
	//旧代码块
	

	@Override
	public List<CustBo> findCustList(CustBo bo) {
		// TODO Auto-generated method stub
		CustExample custExample = new CustExample();
		//此处追加条件
//		Cust cust = bo.toCust();
		
		List<Cust> custList = custMapper.selectByExample(custExample);
		
		
		CustExtExample custExExample = new CustExtExample();
		//此处追加条件
//		CustExt custExt = bo.toCustExt();
		
		List<CustExt> custExtList = custExtMapper.selectByExample(custExExample);
		
		List<CustBo> custBoList = CustBo.fromCustAndCustExt(custList, custExtList);
		
		return custBoList;
	}

	@Override
	public CustBo findCustById(String id) {
		// TODO Auto-generated method stub
		Cust cust = custMapper.selectByPrimaryKey(id);
		CustExt custExt = null;
		if(null != cust.getCustExtId()) {
			custExt = custExtMapper.selectByPrimaryKey(cust.getCustExtId());
		}
		CustBo bo = CustBo.fromCustAndCustExt(cust, custExt);
		return bo;
	}



	@Override
	public void addExtCustInfo(CustBo bo) {
		// TODO Auto-generated method stub
		CustExt custExt = bo.toCustExt();
		custExtMapper.insertSelective(custExt);
	}

	@Override
	public void modifyCust(CustBo bo) {
		// TODO Auto-generated method stub
		//根据bo转换出需要修改的po
		Cust cust = bo.toCust();
		custMapper.updateByPrimaryKeySelective(cust);
		
		CustExt custExt = bo.toCustExt();
		if (null != custExt && null != custExt.getCustExtId()) {
			custExtMapper.updateByPrimaryKeySelective(custExt);
		}
	}

	@Override
	public void modifyCustPassword(String id, String oldPwd, String newPwd) {
		// TODO Auto-generated method stub
		//调用loginAcct修改密码功能
		loginAcctComp.modifyPassWord(id, oldPwd, newPwd);
	}

	@Override
	public void retrieveCustPassword(String id, String newPwd) {
		// TODO Auto-generated method stub

		//调用loginAcct修改密码功能
		loginAcctComp.resetPassWord(id, newPwd);
	}

	@Override
	public void removeCustById(String custId) {
		// TODO Auto-generated method stub
		//禁用loginAcct
		//删除cust信息
		Cust cust = custMapper.selectByPrimaryKey(custId);
		if (null != cust.getCustExtId()) {
			custExtMapper.deleteByPrimaryKey(cust.getCustExtId());
		}
		custMapper.deleteByPrimaryKey(custId);
	}

	@Override
	public List<CustBo> findCustByRegionId(String regionId) {
		CustExample example = new CustExample();
		example.createCriteria().andRegionIdEqualTo(regionId);
		List<Cust> custList = custMapper.selectByExample(example);
		
		return CustBo.fromCustAndCustExt(custList, null);
	}

	@Override
	public List<CustBo> findCustByManagerId(String managerId) {
		CustExample example = new CustExample();
		example.createCriteria().andManagerIdEqualTo(managerId);
		List<Cust> custList = custMapper.selectByExample(example);
		return CustBo.fromCustAndCustExt(custList, null);
	}
	
	@Override
	public boolean custIsManage(CustBo bo) {
		String managerId = bo.getCust().getManagerId();
		String custId = bo.getCust().getCustId();
		CustBo custBo = findCustById(custId);
		Cust cust = custBo.getCust();
		if(cust.getManagerId().equals(managerId))
		{
			return true;
		}else
		{
			throw new NoAccessException();
		}
		
	}

	@Override
	public CustBo addCustAcct(CustBo bo) {
		String custId = bo.getCust().getCustId();
		Cust cust = findCustById(custId).getCust();
		
		LoginAcctInfo loginAcctInfo = bo.getLoginAccInfo();
		LoginAcct loginAcct = loginAcctInfo.getLoginAcct();
		
		//构造登录账户
		loginAcct.setUsername(cust.getUserName());
		loginAcct.setNickname(cust.getShortName());
		loginAcct.setSystemCode(GlobalParamSet.getString(SysConstants.SUB_SYS_MAN_CODE));//定义systemCode
		loginAcct.setState(GlobalParamSet.getShort(BizConstants.ACCT_STATE_ENABLED));//定义账号状态
		loginAcct.setCreateDate(new Date());
		loginAcct.setEffDate(new Date());
		loginAcct.setPwMdate(new Date());
		
		return bo;
	}

	@Override
	public CustBo addCustAcctName(CustBo bo) {
		String custId = bo.getCust().getCustId();
		Cust cust = findCustById(custId).getCust();
		
		List<LoginName> nameList = new ArrayList<LoginName>();
		LoginName loginName = new LoginName();
		loginName.setId(Long.parseLong("001"));
		loginName.setAcctId(bo.getLoginAccInfo().getLoginAcct().getAcctId());
		loginName.setLoginName(cust.getUserMobile());
		loginName.setSystemCode(GlobalParamSet.getString(SysConstants.SUB_SYS_MAN_CODE));
		nameList.add(loginName);
		bo.getLoginAccInfo().setLoginNameList(nameList);
		return bo;
	}

	@Override
	public CustBo addCustAcctRole(CustBo bo, List<String> roleIds) {
		List<Role> roleList = new ArrayList<Role>();
		//此处默认为合作伙伴角色
		Role role = new Role();
		role.setRoleId(GlobalParamSet.getInteger(BizConstants.PARTNER_ROLE_ID));
		roleList.add(role);
//		if(roleIds.size()>0 && roleIds != null)
//		{
//			for(String roleid : roleIds)
//			{
//				role.setRoleId(Integer.parseInt(roleid));
//				roleList.add(role);
//			}
//		}
		bo.getLoginAccInfo().setRoleList(roleList);
		return bo;
	}

	@Override
	public void noAuditCust(String custId) {
		Cust cust = findCustById(custId).getCust();
		cust.setState(GlobalParamSet.getShort(BizConstants.CUST_STATE_FAILED));
		cust.setAcctId(null);
		custMapper.updateByPrimaryKey(cust);
	}

	@Override
	public void auditCust(Cust cust) {
		Cust custom = findCustById(cust.getCustId()).getCust();
		custom.setAcctId(cust.getAcctId());
		custom.setState(GlobalParamSet.getShort(BizConstants.CUST_STATE_ENABLED));
		custMapper.updateByPrimaryKey(custom);
	}

	@Override
	public boolean custIsValid(String custId) {
		Cust custom = findCustById(custId).getCust();
		if(!custom.getState().equals(GlobalParamSet.getShort(BizConstants.CUST_STATE_ENABLED)))
		{
			return true;
		}else
		{
			throw new CustValidedException();
		}
	}

	@Override
	public List<CustBo> findCustListByCustNameLike(String custName, String managerId) {
		// TODO Auto-generated method stub

		CustExample example = new CustExample();
		example.or().andCustNameLike(StringUtil.insertSpliterBothSide(custName, "%"));
		example.or().andCustNamePyLike(StringUtil.insertSpliterBothSide(custName, "%"));
		
		if(StringUtil.isNotEmpty(managerId)){
			example.createCriteria().andManagerIdEqualTo(managerId);
		}
		
		List<Cust> custList = custMapper.selectByExample(example);
		
		List<CustBo> boList = CustBo.fromCustAndCustExt(custList, null);
		
		return boList;
	}

	@Override
	public Cust findCustByAcctId(String acctId) {
		CustExample example = new CustExample();
		Criteria criteria = example.createCriteria();
		
		criteria.andAcctIdEqualTo(acctId);
		
		List<Cust> list = custMapper.selectByExample(example);
		
		if(list!=null && list.size()>0)
		{
			return list.get(0);
		}
		return null;
	}
	
}
