package com.tdtk.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 分布式配置中心：客户端，先经过springConfig的服务端3344端口服务，通过服务端拉取git服务器上的公共配置
 */
@SpringBootApplication
public class EurekaConfigClient3355 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaConfigClient3355.class, args);
    }
}
