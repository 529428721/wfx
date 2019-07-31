package com.qf.admin.controller;

import com.qf.entity.dto.Admin;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("index")
	public String toIndex(Model model,Admin admin){
		model.addAttribute("name",admin.getName());
		return "index";
	}
}
