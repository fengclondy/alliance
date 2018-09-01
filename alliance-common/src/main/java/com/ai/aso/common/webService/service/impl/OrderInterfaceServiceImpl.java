package com.ai.aso.common.webService.service.impl;

import java.net.URL;
import java.util.Calendar;
import org.codehaus.xfire.client.Client;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.base.utils.StringUtil;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.constants.ResultMsg;
import com.ai.aso.common.webService.service.OrderInterfaceService;
import com.alibaba.fastjson.JSONObject;

@Service("orderInterfaceService")
public class OrderInterfaceServiceImpl implements OrderInterfaceService {
	private static final Logger log = LoggerFactory.getLogger(OrderInterfaceServiceImpl.class);
	private static final Logger logger2 = LoggerFactory.getLogger("RECHARGE.CRM");

	@Override
	public JSONObject orderSprom(String orderSeq, String accNbr, String offerSpecId) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 31);
		log.debug("调用CRM订购接口({})入参：{},{}", GlobalParamSet.getString(BizConstants.CRM_WEBSERVICE_ORDER_METHOD), orderSeq, accNbr);

		JSONObject jsonObject = new JSONObject();
		String offerId = null;//
		String actionCd = GlobalParamSet.getString(BizConstants.CRM_WEBSERVICE_ORDER_ACTIONCODE);// 动作0代表开
		String areaCode = null;// 地区编码
		String channelId = GlobalParamSet.getString(BizConstants.CRM_WEBSERVICE_ORDER_CHANNELID);// 渠道
		String orderInfo =montageXML(orderSeq, accNbr, offerId, offerSpecId, actionCd, areaCode, channelId);
		log.debug("调用CRM订购接口({})入参报文：{},{}", GlobalParamSet.getString(BizConstants.CRM_WEBSERVICE_ORDER_METHOD), orderInfo);
		String serviceName = GlobalParamSet.getString(BizConstants.CRM_WEBSERVICE_ORDER_METHOD);
		String resultinfo = null;
		Object[] obj = new Object[] {orderInfo};
		Object[] results = null;
		logger2.debug("【{}-{}】订购开始，【{}】", orderSeq, accNbr, offerId);
		long startMills = System.currentTimeMillis();
		try {
			Client client = new Client(new URL(GlobalParamSet.getString(BizConstants.CRM_WEBSERVICE_ORDER_URL)));

			try {
				results = client.invoke(serviceName, obj);
				resultinfo = results[0].toString();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.error(ResultMsg.MSG_WEBSERVICE_RESPONSE_ERR, e);
				jsonObject.put("result", ResultMsg.OPER_FAILED);
				jsonObject.put("errmsg", ResultMsg.MSG_SYSTEM_ERR);
				jsonObject.put("resultCode", ResultMsg.OPER_MSGCODE_RESPONSE_FAIL);
				jsonObject.put("resultMsg", ResultMsg.MSG_WEBSERVICE_RESPONSE_ERR);
				return jsonObject;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(ResultMsg.MSG_WEBSERVICE_URL_ERR, e);
			jsonObject.put("result", ResultMsg.OPER_FAILED);
			jsonObject.put("errmsg", ResultMsg.MSG_SYSTEM_ERR);
			jsonObject.put("resultCode", ResultMsg.OPER_MSGCODE_URL_FAIL);
			jsonObject.put("resultMsg", ResultMsg.MSG_WEBSERVICE_URL_ERR);
			return jsonObject;
		}
		try {
			log.debug("调用webService接口调用CRM订购插入数据");
			Document document = DocumentHelper.parseText(resultinfo);
			Element rootElement = document.getRootElement();
			String result = rootElement.elementText("result");
			String resultMsg = "";
			String resultCode = "";
			String areaCodeRs = "";
			String prodId = "";
			String olId = "";
			if (ResultMsg.OPER_SUCCESS.equals(result)) {
				olId =StringUtil.splitString(rootElement.elementText("resultMsg"));
				resultMsg = rootElement.elementText("resultMsg");
				//olId = rootElement.elementText("olId");
				areaCodeRs = rootElement.elementText("areaCode");
				prodId = rootElement.elementText("prodId");
				jsonObject.put("result", ResultMsg.OPER_SUCCESS);
				jsonObject.put("resultMsg", resultMsg);
				jsonObject.put("olId", olId);
				jsonObject.put("areaCode", areaCodeRs);
				jsonObject.put("prodId", prodId);

			} else {
				resultCode = rootElement.elementText("resultCode");
				resultMsg = rootElement.elementText("resultMsg");
				jsonObject.put("result", ResultMsg.OPER_FAILED);
				String errmsg[]=resultMsg.split(";");
				if(StringUtil.isNotEmpty(resultMsg)){
					
					jsonObject.put("errmsg", errmsg[1]);
				}else{
					jsonObject.put("errmsg", "未知错误!");
				}
				jsonObject.put("resultCode", resultCode);
				jsonObject.put("resultMsg", resultMsg);
			}

		} catch (Exception e) {
			log.error(ResultMsg.MSG_ANALYTICAL_XML_ERR, e);
			jsonObject.put("result", ResultMsg.OPER_FAILED);
			jsonObject.put("errmsg", ResultMsg.MSG_SYSTEM_ERR);
			jsonObject.put("resultCode", ResultMsg.OPER_MSGCODE_XML_FAIL);
			jsonObject.put("resultMsg", ResultMsg.MSG_ANALYTICAL_XML_ERR);
			return jsonObject;

		}
		long endMills = System.currentTimeMillis();
		long asume = endMills - startMills;
		logger2.debug("调用CRM订购接口结束,耗时{}", asume);
		logger2.debug("【{}-{}】订购CRM结束，【{}】", orderSeq, accNbr, jsonObject);
		return jsonObject;
	}

	@Override
	public JSONObject queryOrderResult(String orderSeq, String accNbr) {

		log.debug("CRM订购查询接口({})入参：{},{}", GlobalParamSet.getString(BizConstants.CRM_WEBSERVICE_ORDER_QUERY_METHOD), orderSeq, accNbr);

		JSONObject jsonObject = new JSONObject();
		String serviceName = GlobalParamSet.getString(BizConstants.CRM_WEBSERVICE_ORDER_QUERY_METHOD);
		String resultinfo = null;
		Object[] obj = new Object[] { orderSeq, accNbr };
		Object[] results = null;
		try {
			Client client = new Client(new URL(GlobalParamSet.getString(BizConstants.CRM_WEBSERVICE_ORDER_URL)));

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
			log.info("调用webService接口调用CRM订购查询信息");
			Document document = DocumentHelper.parseText(resultinfo);
			Element rootElement = document.getRootElement();
			String result = rootElement.elementText("result");
			String resultMsg = "";
			String resultCode = "";
			String areaCodeRs = "";
			String prodId = "";
			String olId = "";
			if (ResultMsg.OPER_SUCCESS.equals(result)) {
				resultMsg = rootElement.elementText("resultMsg");
				olId = rootElement.elementText("olId");
				areaCodeRs = rootElement.elementText("areaCode");
				prodId = rootElement.elementText("prodId");
				jsonObject.put("result", ResultMsg.OPER_SUCCESS);
				jsonObject.put("resultMsg", resultMsg);
				jsonObject.put("olId", olId);
				jsonObject.put("areaCode", areaCodeRs);
				jsonObject.put("prodId", prodId);

			} else {
				resultCode = rootElement.elementText("resultCode");
				resultMsg = rootElement.elementText("resultMsg");
				jsonObject.put("result", ResultMsg.OPER_FAILED);
				jsonObject.put("resultCode", resultCode);
				jsonObject.put("resultMsg", resultMsg);
			}

		} catch (Exception e) {
			log.error(ResultMsg.MSG_ANALYTICAL_XML_ERR, e);
			jsonObject.put("result", ResultMsg.OPER_FAILED);
			jsonObject.put("resultCode", ResultMsg.OPER_MSGCODE_XML_FAIL);
			jsonObject.put("resultMsg", ResultMsg.MSG_ANALYTICAL_XML_ERR);
			return jsonObject;

		}
		log.info("调用CRM订购查询接口结束");
		return jsonObject;
	}

	private String montageXML(String orderSeq, String accNbr, String offerId, String offerSpecId, String actionCd,
			String areaCode, String channelId) {
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=");
		sb.append("\"1.0\"");
		sb.append(" encoding=");
		sb.append("\"UTF-8\"");
		sb.append("?>");
		sb.append("<orderInfo>");
		sb.append("<orderSeq>");
		sb.append(orderSeq);
		sb.append("</orderSeq>");
		sb.append("<accNbr>");
		sb.append(accNbr);
		sb.append("</accNbr>");
		sb.append("<offerId>");
		sb.append(offerId);
		sb.append("</offerId>");
		sb.append("<offerSpecId>");
		sb.append(offerSpecId);
		sb.append("</offerSpecId>");
		sb.append("<actionCd>");
		sb.append(actionCd);
		sb.append("</actionCd>");
		sb.append("<areaCode>");
		sb.append(areaCode);
		sb.append("</areaCode>");
		sb.append("<channelId>");
		sb.append(channelId);
		sb.append("</channelId>");
		sb.append("<effDate/>");
		sb.append("<expDate/>");
		sb.append("</orderInfo>");
		return sb.toString();
	}
	public static void main(String[] args) {
		String resultMsg = "该产品[18039333169]有在途订单暂不能再办理业务，你可以通过这样操作来完成";
		//String errmsg=resultMsg.substring(0,resultMsg.lastIndexOf("，"));
		//System.out.println(errmsg+"!");
		String errmsg[]=resultMsg.split("，");
		if(StringUtil.isNotEmpty(resultMsg)){
			
			System.out.println(errmsg[0]+"!");
		}else{
			System.out.println("未知错误!");
		}
	}
}
