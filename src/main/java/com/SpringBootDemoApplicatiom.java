package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableTransactionManagement  // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
//@ComponentScan("com.service")
@MapperScan("com.dao")

public class SpringBootDemoApplicatiom implements WebMvcConfigurer{
   public static void main(String[] args) {
	SpringApplication.run(SpringBootDemoApplicatiom.class,args);
}
}
