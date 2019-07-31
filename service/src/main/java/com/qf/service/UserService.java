package com.qf.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.entity.dto.User;
import com.qf.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {
	public User getByName(String name) {
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.lambda().eq(User::getName,name);
		return this.getOne(wrapper);
	}
}
