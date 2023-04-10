package com.brindha.oms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication(scanBasePackages = {"com.brindha.oms.controller"})

@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.brindha.oms", "controller", "service"})
public class OmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmsApplication.class, args);


	}

}
