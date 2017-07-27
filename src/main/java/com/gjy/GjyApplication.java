package com.gjy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gjy.mapper*")
public class GjyApplication {

	public static void main(String[] args) {
		SpringApplication.run(GjyApplication.class, args);
	}
}
