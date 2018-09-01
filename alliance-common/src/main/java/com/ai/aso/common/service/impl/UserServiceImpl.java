package com.ai.aso.common.service.impl;

import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.base.utils.StringUtil;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.db.dao.RegionMapper;
import com.ai.aso.common.db.dao.UserMapper;
import com.ai.aso.common.db.model.User;
import com.ai.aso.common.db.model.UserExample;
import com.ai.aso.common.exception.BizExInfoEnum;
import com.ai.aso.common.exception.BizValidException;
import com.ai.aso.common.service.LoginAcctService;
import com.ai.aso.common.service.UserService;
import com.ai.aso.common.sequence.SequenceFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by wuqiang6 on 2016/9/20.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SequenceFactory sequenceFactory;
    @Autowired
    private RegionMapper regionMapper;
    @Autowired
    private LoginAcctService loginAcctService;

    @Override
    public User findUserByAcctId(String accId) {
        assert StringUtil.isNotEmpty(accId);

        UserExample example = new UserExample();
        example.createCriteria().andAcctIdEqualTo(accId);
        List<User> users = userMapper.selectByExample(example);

        assert null != users && users.size() > 0;
        return users.get(0);
    }

	public void addManagerUser(String loginName, String roleId,User user) {
		String acctId = loginAcctService.addManagerAcct(loginName,roleId);
		addUser(acctId, user);
	}
	
	private void addUser(String acctId, User user){
		validRegion(user.getRegionId());
		//4. 新增user表
		User newUser = new User();
		newUser.setAcctId(acctId);
		newUser.setCreateDate(new Date());
		newUser.setEmail(user.getEmail());
		newUser.setMobile(user.getMobile());
		newUser.setModiDate(new Date());
		newUser.setRegionId(user.getRegionId());
		newUser.setState(GlobalParamSet.getShort(BizConstants.USER_STATE_DEFAULT));
		newUser.setUserId(sequenceFactory.next(BizConstants.SEQUENCENAME_USER));
		newUser.setUserName(user.getUserName());
		userMapper.insertSelective(newUser);
	}
	
	private void validRegion(String regionId) {
		try{
			Integer.parseInt(regionId);
		} catch (NumberFormatException e) {
			throw new BizValidException(BizExInfoEnum.USER_REGION_ID_ILLEGAL);
		}
		if (null == regionMapper.selectByPrimaryKey(Integer.parseInt(regionId))) {
			throw new BizValidException(BizExInfoEnum.USER_REGION_ID_ILLEGAL);
		}
	}
	
	@Override
	public void updateAdminUser(User user) {
		//4. 新增user表
		User newUser = new User();
		newUser.setEmail(user.getEmail());
		newUser.setMobile(user.getMobile());
		newUser.setModiDate(new Date());
		newUser.setUserId(user.getUserId());
		newUser.setUserName(user.getUserName());
		newUser.setPhone(user.getPhone());
		userMapper.updateByPrimaryKeySelective(newUser);
	}
}
