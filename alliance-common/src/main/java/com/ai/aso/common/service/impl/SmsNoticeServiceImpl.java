package com.ai.aso.common.service.impl;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.base.utils.StringUtil;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.db.dao.ContractBookMapper;
import com.ai.aso.common.db.dao.ContractMapper;
import com.ai.aso.common.db.dao.CustMapper;
import com.ai.aso.common.db.dao.DataBookaMapper;
import com.ai.aso.common.db.model.Contract;
import com.ai.aso.common.db.model.ContractBook;
import com.ai.aso.common.db.model.ContractBookExample;
import com.ai.aso.common.db.model.Cust;
import com.ai.aso.common.db.model.DataBooka;
import com.ai.aso.common.db.model.DataBookaExample;
import com.ai.aso.common.service.SmsNoticeService;

public class SmsNoticeServiceImpl implements SmsNoticeService {
	Logger log = LoggerFactory.getLogger(SmsNoticeServiceImpl.class);
	@Autowired
	private ContractBookMapper contractBookMapper;
	@Autowired
	private ContractMapper contractMapper;
	@Autowired
	CustMapper custMapper;
//	@Autowired
//	private SmsQueueSender smsSender;
	@Autowired
	private DataBookaMapper dataBookaMapper;

	@Override
	public void arrearage() {
		// TODO Auto-generated method stub
		// 查看所有用户的合同现金账本的额度
		log.debug("欠费用户短信提醒定时任务开始");
		ContractBookExample example = new ContractBookExample();
		example.createCriteria().andBookTypeEqualTo(
				GlobalParamSet
						.getShort(BizConstants.CONTRACT_BOOK_TYPE_PAYMENT));
		List<ContractBook> contractBooks = contractBookMapper
				.selectByExample(example);
		for (ContractBook contractBook : contractBooks) {
			if (null != contractBook) {
				DataBookaExample example2 = new DataBookaExample();
				example2.createCriteria().andContIdEqualTo(
						contractBook.getContId());
				List<DataBooka> dataBookas = dataBookaMapper
						.selectByExample(example2);
				// 总使用金额
				Long cumuVal = dataBookas.get(0).getCumuVal();
				Double currentVal = (contractBook.getAmount() - cumuVal)/1000.000;
				
				if (currentVal <= 0) {
					DecimalFormat df = new DecimalFormat( "###############0.000 ");//   16位整数位，两小数位 
					String  strCurrentVal  = df.format(currentVal); 

					Contract contract = contractMapper
							.selectByPrimaryKey(contractBook.getContId());
					Cust cust = custMapper.selectByPrimaryKey(contract
							.getCustId());
					if (null != cust
							&& StringUtil.isNotEmpty(cust.getUserMobile())) {
						String content = GlobalParamSet
								.getString(BizConstants.SMS_TEMPLATE_ARREARAGE_NOTICE);
						SimpleDateFormat sdf = new SimpleDateFormat(
								"yyyy年MM月dd日HH时mm分ss秒");
						String date = (sdf.format(new Date()));
						content = content.replace("${REMAINING}",
								strCurrentVal);
						content = content.replace("${DATE}", date);
						String custName = "";
						if (StringUtil.isNotEmpty(cust.getCustName())) {
							custName = cust.getCustName();
						}
						content = content.replace("${CUSTNAME}", custName);
						log.debug(content);
//						smsSender.sendSMS(cust.getUserMobile(), content);
					}

				}

			}
		}
		log.debug("欠费用户短信提醒定时任务结束");
	}

	public static void main(String[] args) {
		String content = "【河南电信流量分销】尊敬的${CUSTNAME}用户,截止${DATE}，您的可用余额为${REMAINING}元，为不影响您的正常使用请及时缴费！";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
		String str = "";
		String date = (sdf.format(new Date()));
		content = content.replace("${REMAINING}", "-200");
		content = content.replace("${DATE}", date);
		content = content.replace("${CUSTNAME}", str);
		Double currentVal = (0l - 0l)/1000.00;
		
		DecimalFormat   df   =     new   DecimalFormat( "###############0.000 ");//   16位整数位，两小数位 
		String   temp    =   df.format(currentVal);
			
			System.out.println(temp);
	}
}
