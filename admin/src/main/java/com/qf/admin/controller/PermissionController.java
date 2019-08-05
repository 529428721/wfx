package com.qf.admin.controller;

import com.qf.entity.dto.Admin;
import com.qf.entity.dto.AdminModuleRole;
import com.qf.entity.dto.AdminRole;
import com.qf.http.Result;
import com.qf.service.AdminModuleRoleService;
import com.qf.service.AdminModuleService;
import com.qf.service.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("permission")
public class PermissionController {
	@Autowired
	private AdminRoleService adminRoleService;
	@Autowired
	private AdminModuleRoleService adminModuleRoleService;
	@Autowired
	private AdminModuleService adminModuleService;

	@RequestMapping("list")
	public String toList(Model model) {
		model.addAttribute("roleList", adminRoleService.list());
		model.addAttribute("moduleList",adminModuleService.list());
		return "permission/list";
	}

	@PostMapping("getById")
	@ResponseBody
	public Result<?> getById(@RequestParam(value = "id", required = true) Long id) {
		List<AdminModuleRole> adminModuleRole = adminModuleRoleService.getByRoleId(id);//返回当前登陆者所拥有的权限
		AdminRole adminRole = adminRoleService.getById(id);//返回选中者的信息
		return Result.success(new RoleInfo(adminRole,adminModuleRole));
	}

	@PostMapping("save")
	@ResponseBody
	public Result<?> save(AdminRole adminRole,@RequestParam("moduleRoles") String moduleRoles) {
		adminRoleService.saveRole(adminRole,moduleRoles);
		return Result.success();
	}

	@PostMapping("del")
	@ResponseBody
	public Result<?> delete(@RequestParam(value = "id", required = true) Long id) {
		adminRoleService.removeById(id);
		return Result.success();
	}

	//封装权限信息
	public class RoleInfo{
		private AdminRole adminRole;
		private List<AdminModuleRole> adminModuleRoleList;

		public RoleInfo() {
		}

		public RoleInfo(AdminRole adminRole, List<AdminModuleRole> adminModuleRoleList) {
			this.adminRole = adminRole;
			this.adminModuleRoleList = adminModuleRoleList;
		}

		public AdminRole getAdminRole() {
			return adminRole;
		}

		public void setAdminRole(AdminRole adminRole) {
			this.adminRole = adminRole;
		}

		public List<AdminModuleRole> getAdminModuleRoleList() {
			return adminModuleRoleList;
		}

		public void setAdminModuleRoleList(List<AdminModuleRole> adminModuleRoleList) {
			this.adminModuleRoleList = adminModuleRoleList;
		}
	}

}
