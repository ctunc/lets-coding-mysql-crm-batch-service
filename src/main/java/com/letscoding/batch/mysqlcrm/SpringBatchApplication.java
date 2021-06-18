package com.letscoding.batch.mysqlcrm;

import com.letscoding.batch.annotation.BatchAutoConfigurationApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.SimpleThreadScope;
import org.springframework.core.env.StandardEnvironment;

import java.util.HashMap;
import java.util.Map;



@BatchAutoConfigurationApplication
public class SpringBatchApplication implements ApplicationContextAware {

	private ApplicationContext applicationContext;
	Logger logger=  LoggerFactory.getLogger(this.getClass());
	public static void main(String[] args) {
		SpringApplication application=new SpringApplication(SpringBatchApplication.class);
		application.setWebApplicationType(WebApplicationType.NONE);
		application.setEnvironment(new StandardEnvironment());
		application.addListeners(new ApplicationPidFileWriter("./application.pid"));
		application.run(args);

	}


	@Bean
	public static CustomScopeConfigurer customScopeConfigurer(){
		CustomScopeConfigurer customScopeConfigurer=new CustomScopeConfigurer();
		Map<String,Object> threadScope=new HashMap<>();
		threadScope.put("thread",new SimpleThreadScope());
		customScopeConfigurer.setScopes(threadScope);
		return customScopeConfigurer;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	this.applicationContext=applicationContext;
	logger.info("-----------spring.batch--------->: " + applicationContext.getEnvironment().
			getProperty("letscoding.datasource.mysql.repository-base-packages"));
	}
}
