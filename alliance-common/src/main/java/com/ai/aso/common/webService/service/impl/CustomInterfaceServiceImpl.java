package com.ai.aso.common.webService.service.impl;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import org.codehaus.xfire.client.Client;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.ai.aso.base.exception.BusinessException;
import com.ai.aso.base.exception.ExInfoEnum;
import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.constants.ResultMsg;
import com.ai.aso.common.webService.model.UserInfo;
import com.ai.aso.common.webService.service.CustomInterfaceService;
import com.alibaba.fastjson.JSONObject;

/**
 * 客户信息查询接口
 * <p>
 * Description:
 * </p>
 *
 * @author liuwu
 * @date 2016年10月25日
 *
 */
@Service("customInterfaceService")
public class CustomInterfaceServiceImpl implements CustomInterfaceService {
	private static final Logger log = LoggerFactory.getLogger(CustomInterfaceServiceImpl.class);
	@Resource(name = "redisTemplate")
	private RedisTemplate<String, Object> redisTemplate;
	@Resource(name = "redisTemplate")
	private ValueOperations<String, Object> valueOps;
	
	private static final String preKey = "CUST:CRM:";

	@Override
	public JSONObject getCustInfoByPhoneNumber(String accNbr) {

		log.debug("查询用户信息接口("+GlobalParamSet.getString(BizConstants.CRM_WEBSERVICE_CUST_METHOD)+")入参：" + accNbr);
		JSONObject jsonObject = new JSONObject();
		// 用户号码类型
		Integer inType = 1;
		// 不分页查询
		Integer inSeq = 0;
		// 手机号
		String inValue = accNbr;
		String serviceName = GlobalParamSet.getString(BizConstants.CRM_WEBSERVICE_CUST_METHOD);// 按号码查询
		String resultinfo = null;
		Object[] obj = new Object[] { inType, inValue, inSeq };
		Object[] results = null;
		List<UserInfo> list = new ArrayList<UserInfo>();
		try {
			Client client = new Client(new URL(GlobalParamSet.getString(BizConstants.CRM_WEBSERVICE_CUST_URL)));
			
			try {	
				results = client.invoke(serviceName, obj);
				resultinfo = results[0].toString();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.error(ResultMsg.MSG_WEBSERVICE_RESPONSE_ERR, e);
				jsonObject.put("result", ResultMsg.OPER_FAILED);
				jsonObject.put("resultCode", ResultMsg.OPER_MSGCODE_RESPONSE_FAIL);
				jsonObject.put("resultMsg", ResultMsg.MSG_WEBSERVICE_RESPONSE_ERR);
				return jsonObject;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(ResultMsg.MSG_WEBSERVICE_URL_ERR, e);
			jsonObject.put("result", ResultMsg.OPER_FAILED);
			jsonObject.put("resultCode", ResultMsg.OPER_MSGCODE_URL_FAIL);
			jsonObject.put("resultMsg", ResultMsg.MSG_WEBSERVICE_URL_ERR);
			return jsonObject;
		}
		try {
			Document doc = DocumentHelper.parseText(resultinfo);
			Element rootElt = doc.getRootElement();
			if (resultinfo.contains("PRODUCTLIST")) {
				log.debug("调用webService接口  查询到有用户信息");
				Element e = rootElt.element("PRODUCTLIST");
				for (Iterator<?> iter = e.elementIterator(); iter.hasNext();) {
					Element ee = (Element) iter.next();
					String prodSpecName = ee.elementText("PROD_SPEC");
					String prodSpec_s = prodSpecName.substring(prodSpecName.lastIndexOf("["),
							prodSpecName.lastIndexOf("]"));
					String prodSpec = prodSpec_s.substring(1, prodSpec_s.length());
					// 仅需要取CDMA类型的用户:PROD_SPEC=1;
					if ((GlobalParamSet.getString(BizConstants.PROD_SPEC_CDMA)).equals(prodSpec)) {
						UserInfo userInfo = new UserInfo();
						userInfo.setCustName(ee.elementText("CUST_NAME"));
						userInfo.setCertNumber(ee.elementText("CERT_NUMBER"));
						String certTypeName = ee.elementText("CERT_TYPE");
						String certType_s = certTypeName.substring(certTypeName.lastIndexOf("["),
								certTypeName.lastIndexOf("]"));
						String certType = certType_s.substring(1, certType_s.length());
						userInfo.setCertType(certType);
						userInfo.setCustId(ee.elementText("CUST_ID"));
						userInfo.setProdId(ee.elementText("PROD_ID"));
						userInfo.setAcctId(ee.elementText("ACCT_ID"));
						userInfo.setZoneNumber(ee.elementText("ZONE_NUMBER"));
						userInfo.setProdSpec(ee.elementText("PROD_SPEC"));
						userInfo.setResult(rootElt.elementText("RESULT"));
						userInfo.setResultCode(rootElt.elementText("MSGCODE"));
						userInfo.setResultMsg(rootElt.elementText("MSG"));
						list.add(userInfo);
					} else {
						jsonObject.put("result", rootElt.elementText("RESULT"));
						jsonObject.put("resultCode", rootElt.elementText("MSGCODE"));
						jsonObject.put("resultMsg", rootElt.elementText("MSG"));
						return jsonObject;
					}
				}

			} else {
				log.debug("调用webService接口 没有用户信息");
				jsonObject.put("result", rootElt.elementText("RESULT"));
				jsonObject.put("resultCode", rootElt.elementText("MSGCODE"));
				jsonObject.put("resultMsg", rootElt.elementText("MSG"));
				return jsonObject;
			}

		} catch (Exception e) {
			log.error(ResultMsg.MSG_ANALYTICAL_XML_ERR, e);
			jsonObject.put("result", ResultMsg.OPER_FAILED);
			jsonObject.put("resultCode", ResultMsg.OPER_MSGCODE_XML_FAIL);
			jsonObject.put("resultMsg", ResultMsg.MSG_ANALYTICAL_XML_ERR);
			return jsonObject;


		}
		jsonObject.put("result", ResultMsg.OPER_SUCCESS);
		jsonObject.put("resultCode", ResultMsg.OPER_MSGCODE_SUCC);
		jsonObject.put("resultMsg", ResultMsg.MSG_SUCCESS);
		jsonObject.put("list", list);
		log.info("调用根据号码查询客户接口结束");
		return jsonObject;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public UserInfo customExternalService(String accNbr) {
		JSONObject jsonObject = null;
		List<UserInfo> list = null;
		UserInfo userInfo = null;
		if (!redisTemplate.hasKey(preKey + accNbr)) {
			jsonObject = getCustInfoByPhoneNumber(accNbr);
			list = (List<UserInfo>) jsonObject.get("list");

			if (ResultMsg.OPER_SUCCESS.equals(jsonObject.get("result"))) {
					if(null!=list&&list.size()>0){
						
						userInfo = list.get(0);
						JSONObject jsonUserInfo = (JSONObject) JSONObject.toJSON(userInfo);
						valueOps.set(preKey + accNbr, jsonUserInfo.toJSONString(), 600L, TimeUnit.SECONDS);
					}else{
					throw new BusinessException(ExInfoEnum.SYS_GLOBAL_ERROR_CRMCUST);
					}

			}else{
				userInfo=new UserInfo();
				userInfo.setResult(jsonObject.get("result").toString());
				userInfo.setResultCode(jsonObject.getString("resultCode").toString());
				userInfo.setResultMsg(jsonObject.getString("resultMsg").toString());
				
			}
		} else {
			String jsuserInfo = (String) valueOps.get(preKey + accNbr);

			JSONObject jsonUserInfo = (JSONObject) JSONObject.parse(jsuserInfo);
			userInfo = JSONObject.toJavaObject(jsonUserInfo, UserInfo.class);

		}
		return userInfo;

	}
}
