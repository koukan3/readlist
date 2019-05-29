package com.gh.springboot.readlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 这是应用程序的启动引导类（bootstrap class），也是主要的Spring配置类。
 * 该类有两个作用：
 * 1.配置。（虽然springboot是自动配置，但开发人员仍然要进行少量基础配置）
 * 例如：SpringBootApplication配置，用于开启组件扫描(ComponentScan)和自动配置(EnableAutoConfiguration)。
 * 2.启动引导。
 */
@SpringBootApplication
public class ReadlistApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadlistApplication.class, args);  //负责启动引导应用程序
	}

}
