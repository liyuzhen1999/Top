package com.top;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动程序
 * 
 * @author top
 */
@MapperScan("com.top.toptopcrm")
@ComponentScan(basePackages = {"com.top.topcrm","com.top"})
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class topApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(topApplication.class, args);
        System.out.println("道普协同办公平台启动成功！");
    }
}
