package com.qf.merchant.controller;

import com.qf.entity.dto.Admin;
import com.qf.entity.vo.JqueryTreeView;
import com.qf.http.Result;
import com.qf.service.AdminModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
	@Autowired
	private AdminModuleService adminModuleService;

	@RequestMapping("index")
	public String toIndex(Model model,Admin admin){
		model.addAttribute("name",admin.getName());
		return "index";
	}

	@RequestMapping("func-list")
	@ResponseBody
	public Result<List<JqueryTreeView>> getModuleList(Admin admin){
		List<JqueryTreeView> result = new ArrayList<>(2);

		JqueryTreeView goods = new JqueryTreeView();
		goods.setFid(1);
		goods.setText("商品管理");
		goods.setHref("goods/list");
		result.add(goods);

		JqueryTreeView order = new JqueryTreeView();
		order.setFid(2);
		order.setText("订单管理");
		order.setHref("order/list");
		result.add(order);

		return Result.success(result);
	}
}
