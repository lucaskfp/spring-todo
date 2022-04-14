package br.com.lucaskfp.springtodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SpringtodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringtodoApplication.class, args);
	}

}
