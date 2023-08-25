package com.example.codeEmbed.DependencyInjection;

import jakarta.annotation.PreDestroy;

public class Company {
    private String branch;
    private Integer branchId;

    public Company(){
        super();
        System.out.println("From single Company class");
    }
//    public Company(String branch, Integer branchId){
//        super();
//        this.branch = branch;
//        this.branchId = branchId;
//        System.out.println("From all Company class");
//    }

    public void setBranch(String branch){
        this.branch = branch;
    }
    public String getBranch(){
        return branch;
    }

    public void setBranchId(Integer branchId){
        this.branchId = branchId;
    }
    public Integer getBranchId(){
        return branchId;
    }
    @PreDestroy
    public void destroy(){
        System.out.println("Company object destroy");
    }

}
