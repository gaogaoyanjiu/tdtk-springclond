package com.tdtk.springcloud;

import com.tdtk.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "TDTK-CLOUD-DEPT", configuration = MySelfRule.class)
public class EurekaConsumer80{
	public static void main(String[] args){
		SpringApplication.run(EurekaConsumer80.class, args);
	}
}
