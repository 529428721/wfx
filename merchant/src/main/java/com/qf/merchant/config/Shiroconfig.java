package com.qf.merchant.config;

import com.qf.constant.Constants;
import com.qf.merchant.shiro.CustomRealm;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class Shiroconfig {

	//将realm交给springmvc容器管理
	@Bean
	public CustomRealm customRealm() {
		return new CustomRealm();
	}

	//初始化shiro的三大核心之一 -  SecurityManager
	@Bean
	public SecurityManager securityManager() {
		DefaultSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(customRealm());
		return securityManager;
	}

	//配置shiro的请求过滤链
	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		shiroFilterFactoryBean.setLoginUrl("/login");
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
		for (String path : Constants.EXCLUDE_PATHS) {
			filterChainDefinitionMap.put(path, "anon"); // 允许匿名访问
		}
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}

	@Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	/**
	 * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
	 */
	@Bean
	@DependsOn({"lifecycleBeanPostProcessor"})
	public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
		advisorAutoProxyCreator.setProxyTargetClass(true); //开启cglib
		return advisorAutoProxyCreator;
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
		return authorizationAttributeSourceAdvisor;
	}

}
