package com.example.codeEmbed.DependencyInjection.config;

import com.example.codeEmbed.DependencyInjection.Company;
import com.example.codeEmbed.DependencyInjection.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    //Qualifier annotation used for declare dependency of Company class to understand properly for Employee
    //class to where used the dependency for multiple Employee object
    @Bean
    public Employee employee1(@Qualifier("company1") Company company){ //java config based setter injection
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



    @Bean
    public Employee employee2(@Qualifier("company2") Company company){ //java config based setter injection
        Employee employee2 = new Employee();
        employee2.setName("Mamun Abdullah");
        employee2.setId(3002);
        employee2.setSalary(400000.00);
        employee2.setCountry("Netherlands");
        employee2.setCompany(company);

        return employee2;
    }
    @Bean
    public Company company2(){
        Company company2 = new Company();
        company2.setBranch("Munich");
        company2.setBranchId(4342412);

        return company2;
    }
}
