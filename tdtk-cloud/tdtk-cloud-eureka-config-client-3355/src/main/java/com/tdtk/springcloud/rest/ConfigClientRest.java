package com.tdtk.springcloud.rest;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientRest {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServers;

    @Value("${server.port}")
    private String port;

    @Value("${spring.profiles}")
    private String profiles;


    @RequestMapping("/config")
    public String getConfig(){
        String str = "应用名称:"+applicationName+"\n eureka注册中心请求地址:"+eurekaServers+"\n 端口号:"+port+"\n 环境配置:"+profiles;
        System.out.println("******str: "+ str);
        return str;
    }
}
