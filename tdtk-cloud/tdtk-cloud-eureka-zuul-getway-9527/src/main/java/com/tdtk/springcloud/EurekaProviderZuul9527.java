package com.tdtk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@SpringBootApplication
@EnableZuulProxy
public class EurekaProviderZuul9527{

	/**
	 * [1] 主机名称做hosts文件的虚拟映射 ：127.0.0.1 myzuul.com
	 * [2] 访问规则是：
	 *    （1）默认方式：域名+服务名称+请求的restful的api方法
	 *    http://myzuul.com:9527/tdtk-cloud-dept/dept/get/2
	 *
	 *    （2）隐藏服务名称：
	 *    <1>按照如下配置application.yml文件：
	 *   zuul:
	 *   prefix: /tdtk                             #前缀
	 *   ignored-services: "*"                     #忽略服务名称访问，单个使用具体的服务名称，多个可以用*号代替
	 *   routes:
	 *     mydept.serviceId: tdtk-cloud-dept       #对应的服务
	 *     mydept.path: /mydept/**                 #访问的匹配规则
	 *
	 *   <2>访问方式：
	 *   1、不配置前缀的访问方式：http://myzuul.com:9527/mydept/dept/get/2
	 *   2、配置前缀的访问方式：http://myzuul.com:9527/tdtk/mydept/dept/get/2
	 *
	 *
	 */
	public static void main(String[] args){
		SpringApplication.run(EurekaProviderZuul9527.class, args);
	}
}
