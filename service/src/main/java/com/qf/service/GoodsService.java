package com.qf.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.entity.dto.Goods;
import com.qf.mapper.GoodsMapper;
import org.springframework.stereotype.Service;

@Service
public class GoodsService extends ServiceImpl<GoodsMapper, Goods> {
}
