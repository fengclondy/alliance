package com.ai.aso.manager.web.quick.dao;

import com.ai.aso.manager.web.vo.UserVo;

import java.util.List;

public interface QuickUserMapper {
    List<UserVo> selectListByUserVo(UserVo vo);

	UserVo selectUserByUserId(String userId);

	UserVo selectUserByAcctId(String acctId);
}