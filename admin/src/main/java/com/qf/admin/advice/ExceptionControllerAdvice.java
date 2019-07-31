package com.qf.admin.advice;

import com.qf.http.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler
	@ResponseBody
	public Result<?> handeleBusinessException(HttpServletRequest request,Exception e){
		String errmsg = e.getMessage();
		return Result.error(errmsg);
	}

}
