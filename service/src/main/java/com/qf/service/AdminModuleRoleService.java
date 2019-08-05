package com.qf.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.entity.dto.AdminModuleRole;
import com.qf.mapper.AdminModuleRoleMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminModuleRoleService extends ServiceImpl<AdminModuleRoleMapper, AdminModuleRole> {
	public List<AdminModuleRole> getByRoleId(Long roleId) {
		QueryWrapper<AdminModuleRole> wrapper = new QueryWrapper<>();
		wrapper.lambda().eq(AdminModuleRole::getAdminRoleId,roleId);
		return this.list(wrapper);
	}
}
