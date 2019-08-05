package com.qf.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.entity.dto.Goods;
import com.qf.mapper.GoodsMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodsService extends ServiceImpl<GoodsMapper, Goods> {

	@Transactional(readOnly = true)
	public List<Goods> getBytTypeId(Long goodsTypeId) {
		QueryWrapper<Goods> wrapper = new QueryWrapper();
		if (goodsTypeId > 0) {
			wrapper.lambda().eq(Goods::getGoodsTypeId, goodsTypeId);
		}
		wrapper.lambda().orderByAsc(Goods::getOrderNum);
		return this.list(wrapper);
	}

	@Transactional
	public void up(Long goodsId) {
		UpdateWrapper<Goods> wrapper = new UpdateWrapper<>();
		wrapper.lambda().eq(Goods::getId, goodsId).set(Goods::getState, Goods.State.UP.getCode());
		this.update(wrapper);
	}

	@Transactional
	public void down(Long goodsId) {
		UpdateWrapper<Goods> wrapper = new UpdateWrapper<>();
		wrapper.lambda().eq(Goods::getId, goodsId).set(Goods::getState, Goods.State.DOWN.getCode());
		this.update(wrapper);
	}
}
