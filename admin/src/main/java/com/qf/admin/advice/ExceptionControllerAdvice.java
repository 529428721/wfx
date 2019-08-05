package com.qf.admin.advice;

import com.qf.http.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice//controller增强
public class ExceptionControllerAdvice {

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Result<?> handeleBusinessException(HttpServletRequest request,Exception e){
		e.printStackTrace();
		return Result.error(e.getMessage());
	}

}
