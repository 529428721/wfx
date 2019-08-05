package com.qf.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.entity.dto.GoodsType;
import com.qf.mapper.GoodsTypeMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoodsTypeService extends ServiceImpl<GoodsTypeMapper, GoodsType> {
	public List<GoodsType> Asclist() {
		QueryWrapper<GoodsType> wrapper = new QueryWrapper();
		wrapper.lambda().orderByAsc(GoodsType::getOrderNum);
		return this.list(wrapper);
	}
}
