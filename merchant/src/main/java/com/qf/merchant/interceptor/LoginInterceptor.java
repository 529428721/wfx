package com.qf.merchant.interceptor;

import com.qf.constant.Constants;
import com.qf.entity.dto.Admin;
import com.qf.entity.po.LoginMerchant;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//springboot的拦截器，需要集成自HandlerInterceptorAdpater
public class LoginInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		Subject subject = SecurityUtils.getSubject();
		LoginMerchant loginMerchant = (LoginMerchant) subject.getPrincipal();

		if (loginMerchant == null) {
			response.sendRedirect("/");
			//throw new RuntimeException(ResultCode.LOGIN_ERROR.getDescription());
		}
		request.setAttribute(Constants.CURRENT_MERCHANT_USER, loginMerchant);
		return super.preHandle(request, response, handler);
	}
}