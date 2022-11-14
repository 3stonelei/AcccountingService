package com.stone.accounting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author stone
 * @date 2022/11/14-@16:51
 *
 * @SpringBootApplication相当于加了
 * @SpringBootConfiguration：表示提供了一个SpringBoot应用程序
 * @EnableAutoConfiguration:开启自动配置
 * @ComponentScan：指定要扫描的包
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
