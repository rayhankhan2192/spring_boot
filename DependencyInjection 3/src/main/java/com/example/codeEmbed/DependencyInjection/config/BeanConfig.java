package com.example.codeEmbed.DependencyInjection.config;

import com.example.codeEmbed.DependencyInjection.Company;
import com.example.codeEmbed.DependencyInjection.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public Employee employee1(Company company){ //java config based setter injection
        Employee employee1 = new Employee();
        employee1.setName("Rayhan Khan");
        employee1.setId(3001);
        employee1.setSalary(400000.00);
        employee1.setCountry("Germany");
        employee1.setCompany(company);

        return employee1;
    }

    @Bean
    public Company company1(){
        Company company1 = new Company();
        company1.setBranch("Munich");
        company1.setBranchId(4342412);

        return company1;
    }
}
