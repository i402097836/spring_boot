package com.es.fileservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by LHL on 2016/12/10.
// */
//@MapperScan("com.es.fileservice.dao")
//@EnableAutoConfiguration
@SpringBootApplication
@EnableTransactionManagement //开启事务管理
//@EnableCaching
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

//    @Override
//    public void customize(ConfigurableEmbeddedServletContainer container) {
//        container.setPort(8888);
//    }
}
