package br.com.bravi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("br.com.bravi")
@EnableJpaRepositories
public class ContactsApp {
		
	private static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		context = SpringApplication.run(ContactsApp.class, args);
	}

	public static ConfigurableApplicationContext getContext() {
		return context;
	}
}