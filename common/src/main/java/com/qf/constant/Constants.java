package com.qf.constant;

import java.util.Arrays;
import java.util.List;

public class Constants {
	public static final String CURRENT_ADMIN="CURRENT_ADMIN";
	public static final String CURRENT_MERCHANT_USER="CURRENT_MERCHANT_USER";
	public static final List<String>  EXCLUDE_PATHS = Arrays.asList("/", "/login", "/login.do", "/css/**", "/fonts/**", "/img/**", "/js/**", "/favicon.ico","/error");
}
