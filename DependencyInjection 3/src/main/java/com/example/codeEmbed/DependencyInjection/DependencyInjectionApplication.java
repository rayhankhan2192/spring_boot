package com.example.codeEmbed.DependencyInjection;

import com.example.codeEmbed.DependencyInjection.config.BeanConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({BeanConfig.class})//java config based setter injection
public class DependencyInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DependencyInjectionApplication.class, args);

		Employee employee = (Employee) context.getBean("employee1");//java config based setter injection

		System.out.println("Name     : "+employee.getName());
		System.out.println("ID       : "+employee.getId());
		System.out.println("Salary   : "+employee.getSalary());
		System.out.println("Country  : "+employee.getCountry());
		System.out.println("Branch   : "+employee.getCompany().getBranch());
		System.out.println("BranchID : "+employee.getCompany().getBranchId());
	}

}
