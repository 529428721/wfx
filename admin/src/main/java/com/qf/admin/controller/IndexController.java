package com.qf.admin.controller;

import com.qf.entity.dto.Admin;
import com.qf.entity.vo.JqueryTreeView;
import com.qf.http.Result;
import com.qf.service.AdminModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		return Result.success(adminModuleService.getAdminModuleByAdminId(admin.getId()));
	}
}
