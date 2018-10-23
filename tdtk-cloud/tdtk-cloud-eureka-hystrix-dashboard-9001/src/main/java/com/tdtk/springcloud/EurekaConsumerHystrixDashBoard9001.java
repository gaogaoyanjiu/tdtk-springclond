package com.tdtk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableHystrix
@EnableHystrixDashboard
public class EurekaConsumerHystrixDashBoard9001{
	public static void main(String[] args){
		SpringApplication.run(EurekaConsumerHystrixDashBoard9001.class, args);
	}
}
