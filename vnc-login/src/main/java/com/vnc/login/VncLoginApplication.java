package com.vnc.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
//import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
//@ComponentScan(value = "com.vnc.login.repositories")
public class VncLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(VncLoginApplication.class, args);
	}

}
