package com.tdtk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com.tdtk.springcloud"})
@ComponentScan("com.tdtk.springcloud")
public class EurekaConsumer80feign{
	public static void main(String[] args){
		SpringApplication.run(EurekaConsumer80feign.class, args);
	}
}
