package com.cg;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class AddressBookApplication {

	public static void main(String[] args) {

		ApplicationContext context =SpringApplication.run(AddressBookApplication.class, args);

		log.info("Address Book App Started in {} Envinorment ",
				context.getEnvironment().getProperty("envinorment"));
		log.info("Address Book DB User is {} ",
				context.getEnvironment().getProperty("spring.datasource.username"));

	}

}
