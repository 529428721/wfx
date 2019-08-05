package com.qf.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.entity.dto.AdminModuleRole;
import com.qf.entity.dto.AdminRole;
import com.qf.mapper.AdminRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminRoleService extends ServiceImpl<AdminRoleMapper, AdminRole> {
	@Autowired
	private AdminModuleRoleService adminModuleRoleService;

	@Transactional
	public void saveRole(AdminRole adminRole, String moduleRoles) {
		this.saveOrUpdate(adminRole);//先保存角色信息

		if (adminRole.getId() != null) {
			QueryWrapper<AdminModuleRole> deleteWrapper = new QueryWrapper<>();
			deleteWrapper.lambda().eq(AdminModuleRole::getAdminRoleId,adminRole.getId());
			adminModuleRoleService.remove(deleteWrapper);
		}

		String[] moduleIdArray = moduleRoles.split("|");
		List<AdminModuleRole> needInsert = new ArrayList<>(moduleIdArray.length);

		//如果权限id != |  就新建对象加入到数组中
		for (String moduleId :moduleIdArray){
			if (!"|".equals(moduleId)){
				AdminModuleRole adminModuleRole = new AdminModuleRole();
				adminModuleRole.setAdminModuleId(Long.parseLong(moduleId));
				adminModuleRole.setAdminRoleId(adminRole.getId());
				needInsert.add(adminModuleRole);
			}
		}

		//批量插入
		adminModuleRoleService.saveBatch(needInsert,needInsert.size());
	}
}
