package com.example.codeEmbed.SpringMVC.controller;

import com.example.codeEmbed.SpringMVC.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {


    @GetMapping("/homes")
    //@RequestMapping("/homes")
    public String homePage(){
        return "Home.html";
    }

//    @RequestMapping("/employeeData")
//    public String employeeData(@RequestParam String EmpName,
//                               @RequestParam int EmpID,
//                               @RequestParam double EmpSalary,
//                               @RequestParam String EmpCountry,
//                               Model model){ //Model used to set the data from one page to another page
//        model.addAttribute("EmpName", EmpName);
//        model.addAttribute("EmpID", EmpID);
//        model.addAttribute("EmpSalary", EmpSalary);
//        model.addAttribute("EmpCountry", EmpCountry);
//        return "EmployeeData.html";
//    }

    //we can also create another method as like as previous one to get data from frontEnd
    //@RequestMapping("") used to get the data from frontEnd page or send data to another page
//    @RequestMapping(value = "/employeeData", method = RequestMethod.POST)
//    //@RequestMapping initially call POST and GET method but its not secure
//    //when we use method = RequestMethod.POST inside @RequestMapping
//    //its randomly call only POST method to post data to server or page
//    //also we can use @PostMapping("") to post data to server of page

    @PostMapping("/employeeData")
    public ModelAndView employeeData(@RequestParam String EmpName,
                                     @RequestParam int EmpID,
                                     @RequestParam double EmpSalary,
                                     @RequestParam String EmpCountry){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("EmployeeData.html");
        modelAndView.addObject("EmpName", EmpName);
        modelAndView.addObject("EmpID", EmpID);
        modelAndView.addObject("EmpSalary", EmpSalary);
        modelAndView.addObject("EmpCountry", EmpCountry);

        return modelAndView;
    }

    @GetMapping("/allEmployee") //to get data from server by using @GetMapping("")
    public String allEmployee(Model model){
        List<Employee> e = new ArrayList<Employee>();
        e.add(new Employee("Rayhan Khan", 1001, 500000.00, "Germany"));
        e.add(new Employee("Mostakin Nilom", 1002, 500000.00, "Canada" ));
        e.add(new Employee("Mamun Abdullah", 1003, 500000.00, "Netherlands"));
        model.addAttribute("AllEmployee", e);

        return "AllEmployee.html";
    }


    //its not working
//    @RequestMapping("/employeeData")
//    public ModelAndView employeeData(@ModelAttribute Employee emp){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("EmployeeData.html");
//
//
//        return modelAndView;
//    }


}
