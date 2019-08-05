package com.qf.admin.controller;

import com.qf.entity.dto.MerchantUser;
import com.qf.http.Result;
import com.qf.service.MerchantUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("merchant")
public class MerchantController {
	@Autowired
	private MerchantUserService merchantUserService;

	@RequestMapping("list")
	public String toList(Model model) {
		model.addAttribute("merchantUserList", merchantUserService.list());
		return "merchant/list";
	}

	@PostMapping("save")
	@ResponseBody
	public Result<?> save(MerchantUser merchantUser) {
		merchantUserService.saveOrUpdate(merchantUser);
		return Result.success();
	}

	@PostMapping("del")
	@ResponseBody
	public Result<?> delete(@RequestParam(value = "id", required = true) Long id) {
		merchantUserService.removeById(id);
		return Result.success();
	}

	@PostMapping("getById")
	@ResponseBody
	public Result<?> getById(@RequestParam(value = "id", required = true) Long id) {
		return Result.success(merchantUserService.getById(id));
	}
}
