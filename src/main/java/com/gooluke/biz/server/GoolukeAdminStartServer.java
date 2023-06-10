package com.gooluke.biz.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 咕噜科
 * ClassName: GoolukeAdminStartServer
 * date: 2023-06-10 14:39
 * Description: 管理台系统
 * version 1.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "com.gooluke")
public class GoolukeAdminStartServer {

    public static void main(String[] args) {
        SpringApplication.run(GoolukeAdminStartServer.class,args);
    }

}
