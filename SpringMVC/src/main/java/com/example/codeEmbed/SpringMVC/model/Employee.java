package com.example.codeEmbed.SpringMVC.model;

public class Employee {
    private String name;
    private int id;
    private double salary;
    private String country;

    public Employee(String name, int id, double salary, String country){
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.country = country;
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

    public String toString(){
        return "Employee [EmpName = "+name+ ", EmpID = "+id+", EmpSalary = "+salary+", EmpCountry = "+country+"]";
    }
}
