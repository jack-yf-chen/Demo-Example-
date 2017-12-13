package com.example;

import org.apache.log4j.PropertyConfigurator;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.example.mapper")
public class DemoApplication {

	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	static {
		try{
			// 初始化log4j
			String log4jPath = "";
			log4jPath = DemoApplication.class.getClassLoader().getResource("").getPath()+"log4j.properties";
			logger.info("初始化Log4j。。。。");
			logger.info("path is "+ log4jPath);
			PropertyConfigurator.configure(log4jPath);
		}catch (Exception e){
			e.printStackTrace();
			logger.error(e.toString());
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
