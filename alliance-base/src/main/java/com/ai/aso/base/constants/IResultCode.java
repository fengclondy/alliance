package com.ai.aso.base.constants;

/**
 * 结果码定义<br>
 * 如："111100001":"登录成功"；"F111100002":"账号不存在"
 * 编码规则：前缀(0或1位)+模块编码(2位)+功能编码(3位)+序号(4位)<br>
 * 前缀：错误码用"F"作为前缀，成功操作返回码无前缀<br>
 * 模块编码及功能编码：参照ISystemCode及其子类中的模块及功能定义<br>
 * 序号：顺序号
 */
public interface IResultCode {

	// 全局结果码
	String SYS_SUCCESS = "1"; // 成功
	String SYS_FAILED = "0"; // 失败

}
