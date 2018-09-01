package com.ai.aso.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.aso.common.db.dao.ContractItemMapper;
import com.ai.aso.common.db.model.ContractItem;
import com.ai.aso.common.db.model.ContractItemExample;
import com.ai.aso.common.db.model.Goods;
import com.ai.aso.common.service.ContractItemService;
import com.ai.aso.common.service.GoodsService;

@Service
public class ContractItemServiceImpl implements ContractItemService {
	
	@Autowired
	private ContractItemMapper contractItemMapper;
	@Autowired
	private GoodsService goodsService;

	@Override
	public void addContractItem(List<ContractItem> item) {
		for(ContractItem ci : item) {
			Goods goods = goodsService.findGoodsByGoodsId(ci.getGoodsId());
			
			ci.setGoodsName(goods.getGoodsName());
			ci.setGoodsSpecs(goods.getGoodsSpecs());
			ci.setGoodsType(goods.getGoodsType());
			ci.setUnitPrice(goods.getGoodsPrice().intValue());
			ci.setPayableFee(new Long(ci.getUnitPrice()*ci.getOffRate()/100));
			ci.setDiscountFee(ci.getUnitPrice() - ci.getPayableFee());
			ci.setDataType(goods.getDataType());
			ci.setNumber(1);
			ci.setExt1(goods.getBillOfferId());
			
			contractItemMapper.insertSelective(ci);
		}
		
	}

	@Override
	public List<ContractItem> findContractItemByContId(String contId) {
		ContractItemExample example = new ContractItemExample();
		example.createCriteria().andContIdEqualTo(contId);
		return contractItemMapper.selectByExample(example);
	}

}
