package com.qf.admin.shiro;

import com.qf.entity.dto.Admin;
import com.qf.http.ResultCode;
import com.qf.service.AdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {
	@Autowired
	private AdminService adminService;

	//登录成功后 添加权限
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		Set<String> permissionSet = new HashSet<>();
		permissionSet.add("ADMINISTRATOR");
		simpleAuthorizationInfo.setStringPermissions(permissionSet);
		return simpleAuthorizationInfo;
	}

	//验证并返回登陆者信息
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		String username = token.getUsername();
		String password = new String(token.getPassword());
		Admin admin = adminService.getByName(username);
		if (admin == null){
			throw new RuntimeException(ResultCode.LOGIN_ERROR.getDescription());
		}
		if (!admin.getPassword().equals(password)){
			throw new RuntimeException(ResultCode.LOGIN_ERROR.getDescription());
		}
		return new SimpleAuthenticationInfo(admin, admin.getPassword(), admin.getAccount());
	}

}
