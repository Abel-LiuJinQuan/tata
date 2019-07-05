package com.hita.tata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableMongoAuditing
@ComponentScan
//@ServletComponentScan(basePackages = "com.hita.tata")
@MapperScan("com.hita.tata.bbs.block.dao")
public class TataApplication {

	public static void main(String[] args) {
		SpringApplication.run(TataApplication.class, args);
	}

}
