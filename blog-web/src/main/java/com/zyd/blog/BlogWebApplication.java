package com.zyd.blog;

import me.zhyd.braum.spring.boot.annotation.EnableBraumConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 程序启动类
 */
@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
@EnableBraumConfiguration
public class BlogWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogWebApplication.class, args);
    }

}
