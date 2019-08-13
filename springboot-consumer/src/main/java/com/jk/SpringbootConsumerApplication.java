package com.jk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("spring-dubbo-consumer.xml")
public class SpringbootConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootConsumerApplication.class, args);
	}

}
