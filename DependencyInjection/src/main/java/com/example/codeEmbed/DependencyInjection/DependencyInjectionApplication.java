package com.example.codeEmbed.DependencyInjection;

import jakarta.annotation.PreDestroy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:beans.xml"})
public class DependencyInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DependencyInjectionApplication.class, args);

		Employee employee = (Employee) context.getBean("employee1");//here used xml xml xml based configuration

		System.out.println(employee.getName());
		System.out.println(employee.getId());
		System.out.println(employee.getCompany().getBranch());
	}

}
