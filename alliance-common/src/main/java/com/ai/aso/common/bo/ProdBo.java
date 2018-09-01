package com.ai.aso.common.bo;

import java.util.ArrayList;
import java.util.List;
import com.ai.aso.common.db.model.DiscountRule;
import com.ai.aso.common.db.model.Goods;


public class ProdBo {
	private DiscountRule discountRule;

	private Goods goods;

	public ProdBo() {
		discountRule = new DiscountRule();
		goods = new Goods();
	}
	public Goods toGoods() {
		return this.goods;
	}

	public DiscountRule toDiscountRule() {
		return this.discountRule;
	}

	public static ProdBo fromGoods(Goods goods) {
		// TODO Auto-generated method stub
		ProdBo bo = new ProdBo();
		bo.goods = goods;

		return bo;
	}

	public static ProdBo fromDiscountRule(DiscountRule discountRule) {
		// TODO Auto-generated method stub
		ProdBo bo = new ProdBo();
		bo.discountRule = discountRule;
		return bo;
	}

	public static List<ProdBo> fromGoods(List<Goods> goodsList) {
		List<ProdBo> boList = new ArrayList<ProdBo>();

		for (Goods goods : goodsList) {
			ProdBo bo = new ProdBo();
			if (null != goods) {
				bo.setGoods(goods);

				boList.add(bo);
			}
		}

		return boList;
	}

	public static List<ProdBo> fromDiscountRule(List<DiscountRule> discountRuleList) {
		List<ProdBo> boList = new ArrayList<ProdBo>();

		for (DiscountRule discountRule : discountRuleList) {
			ProdBo bo = new ProdBo();
			if (null != discountRule) {
				bo.setDiscountRule(discountRule);

				boList.add(bo);
			}
		}

		return boList;
	}

	public DiscountRule getDiscountRule() {
		return discountRule;
	}

	public void setDiscountRule(DiscountRule discountRule) {
		this.discountRule = discountRule;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

}
