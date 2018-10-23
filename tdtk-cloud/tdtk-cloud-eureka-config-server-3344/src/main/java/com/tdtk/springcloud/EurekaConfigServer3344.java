package com.tdtk.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


/**
 * 分布式配置中心：服务端，用于拉取git服务器上的公共配置
 */
@SpringBootApplication
@EnableConfigServer
public class EurekaConfigServer3344 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaConfigServer3344.class, args);
    }
}
