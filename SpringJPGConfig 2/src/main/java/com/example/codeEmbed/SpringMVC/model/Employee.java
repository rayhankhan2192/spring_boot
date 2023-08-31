package com.example.codeEmbed.SpringMVC.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
    private String name;
    @Id//defines id is a primary key
    private int id;
    private double salary;
    private String country;

    public Employee(String name, int id, double salary, String country){
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.country = country;
    }

    public Employee(){
        super();
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }


    public void setId(int id){
        this.id = id;
    }
    public int getId(){
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
}
