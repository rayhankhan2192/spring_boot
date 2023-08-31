package com.example.codeEmbed.SpringMVC.controller;

import com.example.codeEmbed.SpringMVC.model.Employee;
import com.example.codeEmbed.SpringMVC.JPArepository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    EmployeeRepository employeeRepository;//initialized the interface class to send data to the database

    @GetMapping("/homes")
    //@RequestMapping("/homes")
    public String homePage(){
        return "Home.html";
    }

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

        Employee employee = new Employee();
        employee.setName(EmpName);
        employee.setId(EmpID);
        employee.setSalary(EmpSalary);
        employee.setCountry(EmpCountry);
        // Save the employee object using the repository/EmployeeRepository
        employeeRepository.save(employee);


        //modelAndView.setViewName("EmployeeData.html");
        modelAndView.addObject("EmpName", EmpName);
        modelAndView.addObject("EmpID", EmpID);
        modelAndView.addObject("EmpSalary", EmpSalary);
        modelAndView.addObject("EmpCountry", EmpCountry);

        modelAndView.setViewName("redirect:/homes"); //this line refresh the page after click submit button
        return modelAndView;

    }

    //to search the employee details by using ID
    @PostMapping("/findByID")
    public String findByID(@RequestParam int EmpID, @org.jetbrains.annotations.NotNull Model m){
        Employee emp = employeeRepository.getOne(EmpID);
        m.addAttribute("AllEmployee", emp);

        return "AllEmployee.html";
    }

    //this method for delete employee information from dataBase
    @PostMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam int EmpID, Model model){
        employeeRepository.deleteById(EmpID);
        return "redirect:/homes";
    }


    @PostMapping("/updateEmployee")
    public ModelAndView updateEmployee(
            @RequestParam int EmpID,
            @RequestParam String EmpName,
            @RequestParam double EmpSalary,
            @RequestParam String EmpCountry) {
        ModelAndView modelAndView = new ModelAndView();

        // Retrieve the employee by ID
        Optional<Employee> optionalEmployee = employeeRepository.findById(EmpID);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();

            // Update the employee's details
            employee.setName(EmpName);
            employee.setSalary(EmpSalary);
            employee.setCountry(EmpCountry);

            // Save the updated employee object using the repository
            employeeRepository.save(employee);

            modelAndView.addObject("EmpName", EmpName);
            modelAndView.addObject("EmpID", EmpID);
            modelAndView.addObject("EmpSalary", EmpSalary);
            modelAndView.addObject("EmpCountry", EmpCountry);
            modelAndView.setViewName("EmployeeData.html");

            System.out.println(EmpName);
            System.out.println(EmpID);
        }else {
            modelAndView.setViewName("EmployeeData.html");
            System.out.println("Employee Not found");
        }

        return modelAndView;
    }
}

