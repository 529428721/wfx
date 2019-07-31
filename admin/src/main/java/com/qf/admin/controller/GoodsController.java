package com.qf.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qf.entity.dto.Goods;
import com.qf.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class GoodsController {

	@Autowired
	private GoodsService goodsService;

	@RequestMapping("goodList")
	public ModelAndView goodList(Model model,@RequestParam(value = "pageNum",required = true,defaultValue = "0") Integer pageNum){
		QueryWrapper<Goods> wrapper = new QueryWrapper<>();
		wrapper.lambda().orderByAsc(Goods::getId);
		IPage<Goods> page = goodsService.page(new Page<>(pageNum, 3), wrapper);
		model.addAttribute("list",page.getRecords());
		return new ModelAndView("goodList");
	}

	@RequestMapping("deleted")
	@ResponseBody
	public String deleted(@RequestParam(value = "id",required = true) Integer id){
		goodsService.removeById(id);
		return "删除成功";
	}
}
