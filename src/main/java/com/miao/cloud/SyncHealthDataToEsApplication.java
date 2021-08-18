package com.miao.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.stereotype.Repository;

@SpringBootApplication
@MapperScan(annotationClass = Repository.class, basePackages = "com.miao.cloud.mapper")
public class SyncHealthDataToEsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SyncHealthDataToEsApplication.class, args);
    }

}
