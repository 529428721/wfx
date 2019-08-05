package com.qf.merchant.shiro;

import com.qf.entity.dto.MerchantUser;
import com.qf.entity.po.LoginMerchant;
import com.qf.http.ResultCode;
import com.qf.service.MerchantUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;


public class CustomRealm extends AuthorizingRealm {
	@Autowired
	private MerchantUserService merchantUserService;

	//登录成功后 添加权限
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		return new SimpleAuthorizationInfo();
	}

	//验证并返回登陆者信息
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		String username = token.getUsername();
		String password = new String(token.getPassword());
		MerchantUser merchantUser = merchantUserService.getByName(username);
		if (merchantUser == null){
			throw new RuntimeException(ResultCode.LOGIN_ERROR.getDescription());
		}
		if (!merchantUser.getPassword().equals(password)){
			throw new RuntimeException(ResultCode.LOGIN_ERROR.getDescription());
		}
		LoginMerchant loginMerchant = new LoginMerchant();
		BeanUtils.copyProperties(merchantUser,loginMerchant);
		return new SimpleAuthenticationInfo(loginMerchant, merchantUser.getPassword(), merchantUser.getUserName());
	}

}
