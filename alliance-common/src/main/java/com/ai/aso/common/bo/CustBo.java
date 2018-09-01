package com.ai.aso.common.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ai.aso.common.db.model.Cust;
import com.ai.aso.common.db.model.CustExt;

public class CustBo {

	private LoginAcctInfo loginAccInfo;
	private Cust cust;
	private CustExt custExt;
	
	public CustBo(){
		cust = new Cust();
		custExt = new CustExt();
		loginAccInfo = new LoginAcctInfo();
	}

	public Cust toCust() {
		// TODO Auto-generated method stub
		return this.cust;
	}

	public CustExt toCustExt() {
		// TODO Auto-generated method stub
		return this.custExt;
	}

	public static CustBo fromCustAndCustExt(Cust cust, CustExt custExt) {
		// TODO Auto-generated method stub
		CustBo bo = new CustBo();
		bo.cust = cust;
		bo.custExt = custExt;
		return bo;
	}

	public static List<CustBo> fromCustAndCustExt(List<Cust> custList, List<CustExt> custExtList) {
		List<CustBo> boList = new ArrayList<CustBo>();
		
		Map<Long, CustExt> custExtMap = new HashMap<Long, CustExt>();
		if (null != custExtList){
			for (CustExt ext : custExtList) {
				custExtMap.put(ext.getCustExtId(), ext);
			}
		}
		
		for (Cust cust : custList) {
			CustBo bo = new CustBo();
			if(null != cust) {
				bo.setCust(cust);
				Long custExtId = cust.getCustExtId();
				if(null != custExtId) {
					bo.setCustExt(custExtMap.get(custExtId));
				}
				
				boList.add(bo);
			}
		}
		
		return boList;
	}
	
	
	public LoginAcctInfo getLoginAccInfo() {
		return loginAccInfo;
	}

	public void setLoginAccInfo(LoginAcctInfo loginAccInfo) {
		this.loginAccInfo = loginAccInfo;
	}

	public Cust getCust() {
		return cust;
	}

	public void setCust(Cust cust) {
		this.cust = cust;
	}

	public CustExt getCustExt() {
		return custExt;
	}

	public void setCustExt(CustExt custExt) {
		this.custExt = custExt;
	}
}
