package com.qf.merchant.controller;


import com.qf.http.Result;
import com.qf.http.ResultCode;
import com.qf.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController {
	@Autowired
	private AdminService adminService;

	@RequestMapping({"/"})
	public String toLogin(){
		return "login";
	}

	@RequestMapping("login")
	public String doLogin(Model model , String username,String password){
		if (username == null || password == null) {
			return "forward:/";
		}
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			if (subject.isAuthenticated()){
				return "redirect:/index"; //登陆成功
			}
		}catch (AuthenticationException e){
		}
		model.addAttribute("username", username);
		model.addAttribute("error", ResultCode.LOGIN_ERROR.getDescription());
		return "forward:/"; //登陆失败
	}

	@RequiresPermissions(value={"老师"})
	@RequestMapping("test")
	@ResponseBody
	public Result<?> test(){
		return Result.success("我是老师");
	}

}
