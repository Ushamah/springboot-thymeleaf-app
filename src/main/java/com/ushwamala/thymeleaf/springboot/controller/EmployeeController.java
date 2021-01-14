package com.ushwamala.thymeleaf.springboot.controller;

import com.ushwamala.thymeleaf.springboot.entity.Employee;
import com.ushwamala.thymeleaf.springboot.exceptionhandling.EmployeeNotFoundException;
import com.ushwamala.thymeleaf.springboot.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

  private static final Logger logger = LoggerFactory.getLogger("Log_EmployeeController");

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public String getAllEmployees(Model theModel) {
        List<Employee> employees = employeeService.getAllEmployees();
        theModel.addAttribute("employees", employees);
        return "employees/employees-list";
    }

    @GetMapping("/addEmployeeForm")
    public String showFormForAdd(Model theModel) {
        Employee employee = new Employee();
        theModel.addAttribute("employee", employee);
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("employeeSummary")
    public String employeeSummary(@RequestParam("employeeId") int employeeId, Model theModel) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        theModel.addAttribute("employee", employee);
        return "/employees/employee-summary";
    }

    @GetMapping("/deleteEmployee")
    public String deleteCustomer(@RequestParam("employeeId") int employeeId) {
        employeeService.deleteEmployee(employeeId);
        return "redirect:/employees/list";
    }

    @GetMapping("updateEmployeeForm")
    public String updateEmployeeForm(@RequestParam("employeeId") int employeeId, Model theModel) {

        //Retrieve the employee using the employeeId
        Employee employee = employeeService.getEmployeeById(employeeId);

        //Add found employee to the model
        theModel.addAttribute("employee", employee);

        //return view
        return "/employees/employee-form";
    }

    @GetMapping("/search")
    public String delete(@RequestParam("employeeName") String theName,
                         Model theModel) {

        // delete the employee
        List<Employee> theEmployees = employeeService.searchBy(theName);

        // add to the spring model
        theModel.addAttribute("employees", theEmployees);

        // send to /employees/list
        return "/employees/employees-list";

    }

}
