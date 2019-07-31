package com.qf.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.entity.dto.Admin;
import com.qf.mapper.AdminMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminService extends ServiceImpl<AdminMapper, Admin> {

	@Transactional(readOnly = true)
	public Admin getByName(String account) {
		QueryWrapper<Admin> wrapper = new QueryWrapper<>();
		wrapper.lambda().eq(Admin::getAccount,account);
		return this.getOne(wrapper);
	}
}
