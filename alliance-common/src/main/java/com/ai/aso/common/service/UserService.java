package com.ai.aso.common.service;

import com.ai.aso.common.db.model.User;

/**
 * 用户服务类，提供用户账户信息获取查询
 * Created by wuqiang6 on 2016/9/20.
 */
public interface UserService {

    /**
     * 根据登录者ID，获取登陆者的用户信息
     * @param accId
     * @return
     */
    User findUserByAcctId(String acctId);
    
    /**
     * 新增管理员账户
     * @param loginName
     * @param user
     */
    void addManagerUser(String loginName, String roleId, User user);

    /**
     * 更新管理员账户
     * @param user
     */
	void updateAdminUser(User user);
}
