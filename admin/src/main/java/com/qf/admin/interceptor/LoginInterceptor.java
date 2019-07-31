package com.qf.admin.interceptor;

import com.qf.constant.Constants;
import com.qf.entity.dto.Admin;
import com.qf.http.ResultCode;
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
		Admin admin = (Admin) subject.getPrincipal();

		if (admin == null) {
			//response.sendRedirect("/");
			throw new RuntimeException(ResultCode.LOGIN_ERROR.getDescription());
		}
		request.setAttribute(Constants.CURRENT_ADMIN, admin);
		return super.preHandle(request, response, handler);
	}
}