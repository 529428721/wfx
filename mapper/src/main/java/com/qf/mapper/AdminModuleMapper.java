package com.qf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.entity.dto.AdminModule;
import com.qf.entity.vo.JqueryTreeView;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminModuleMapper extends BaseMapper<AdminModule> {
	List<JqueryTreeView> getAdminModuleByAdminId(@Param("adminId")Long adminId);
}
