package com.example.codeEmbed.DependencyInjection;

import jakarta.annotation.PreDestroy;

public class Employee {
    private String name;
    private Integer id;
    private double salary;
    private String country;
    //Dependency
    private Company company;

    public Employee(){
        super();
        System.out.println("From single employee class");
    }

//    public Employee(String name, Integer id, double salary, String country, Company company){
//        this.name = name;
//        this.id = id;
//        this.salary = salary;
//        this.country = country;
//        this.company = company;//Dependency
//        System.out.println("From all Employee class");
//    }

    public void setName(String name){
       this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setId(Integer id){
        this.id = id;
    }
    public  Integer getId(){
        return id;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }
    public double getSalary(){
        return salary;
    }

    public void setCountry(String country){
        this.country = country;
    }
    public String getCountry(){
        return country;
    }

    public void setCompany(Company company){
        this.company = company;
    }
    public Company getCompany(){
        return company;
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Employee object destroy");
    }
}
