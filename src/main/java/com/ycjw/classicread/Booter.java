package com.ycjw.classicread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAsync
@EnableCaching
@EnableSpringDataWebSupport
@EnableSwagger2
public class Booter {

	public static void main(String[] args) {
		try {
			SpringApplication.run(Booter.class, args);
			System.out.println("启动完成");
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
