package com.qf.merchant.resolver;

import com.qf.constant.Constants;
import com.qf.entity.dto.Admin;
import com.qf.entity.po.LoginMerchant;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

import javax.servlet.http.HttpServletRequest;

public class ArgumentResolver implements WebArgumentResolver {
	@Override
	public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest webRequest) throws Exception {
		Class<?> parameterType = methodParameter.getParameterType();
		if (parameterType != null) {
			if (parameterType.equals(LoginMerchant.class)){
				HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
				return request.getAttribute(Constants.CURRENT_MERCHANT_USER);
			}
		}
		return UNRESOLVED;
	}
}
