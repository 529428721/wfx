package com.qf.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.entity.dto.AdminModule;
import com.qf.entity.vo.JqueryTreeView;
import com.qf.mapper.AdminModuleMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminModuleService extends ServiceImpl<AdminModuleMapper, AdminModule> {
	public List<JqueryTreeView> getAdminModuleByAdminId(Long adminId){
		return this.baseMapper.getAdminModuleByAdminId(adminId);
	}
}
