package com.qf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement(proxyTargetClass = true) //开启transactional事务注解
@MapperScan(basePackages = {"com.qf.mapper"})  //mapper包扫描
@SpringBootApplication  //标识为springboot应用程序
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
