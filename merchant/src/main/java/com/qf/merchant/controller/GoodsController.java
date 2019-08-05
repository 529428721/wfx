package com.qf.merchant.controller;

import com.qf.http.Result;
import com.qf.service.GoodsService;
import com.qf.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("goods")
public class GoodsController {
	@Autowired
	private GoodsTypeService goodsTypeService;
	@Autowired
	private GoodsService goodsService;

	@RequestMapping("list")
	public String toList(Model model, @RequestParam(value = "goodsTypeId", required = false, defaultValue = "0") Long goodsTypeId) {
		model.addAttribute("goodsTypes", goodsTypeService.Asclist());
		model.addAttribute("goodsList", goodsService.getBytTypeId(goodsTypeId));
		return "goods/list";
	}

	@RequestMapping("up")
	@ResponseBody
	public Result<?> up(@RequestParam(value = "id", required = true) Long goodsId) {
		goodsService.up(goodsId);
		return Result.success();
	}

	@RequestMapping("down")
	@ResponseBody
	public Result<?> down(@RequestParam(value = "id", required = true) Long goodsId) {
		goodsService.down(goodsId);
		return Result.success();
	}

	@RequestMapping("del")
	@ResponseBody
	public Result<?> del(@RequestParam(value = "id", required = true) Long goodsId) {
		goodsService.removeById(goodsId);
		return Result.success();
	}
}
