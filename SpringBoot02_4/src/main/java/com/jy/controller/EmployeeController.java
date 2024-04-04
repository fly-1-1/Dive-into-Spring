package com.jy.controller;

import com.jy.entity.Employee;
import com.jy.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@RequestMapping("/employee")
@SessionAttributes(value = {"employee"})
@RequiredArgsConstructor
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
    private final EmployeeService employeeService;

    @RequestMapping("list")
    public String listEmployee(Model model) {
        List<Employee> employees = employeeService.listEmployee();
        model.addAttribute("employees", employees);
        return "emplist";
    }

    @RequestMapping("add")
    public String add(Employee employee) {
        log.info("employee:{},{},{},{}", employee.getName(), employee.getSalary(), employee.getBirthday(), employee.getGender());
        employeeService.add(employee);
        return "redirect:/employee/list";
    }

    @RequestMapping("/findById")
    public String findEmpById(String id,Model model) {
        log.info("Id:{}", id);
        Employee employee = employeeService.findEmpById(id);
        model.addAttribute("employee",employee);
        System.out.println(employee);
        return "updateEmp";
    }

    @RequestMapping("/update")
    public String updateEmployee(Employee employee) {
        log.info("update employee:{},{},{},{},{}",employee.getId(), employee.getName(), employee.getSalary(), employee.getBirthday(), employee.getGender());
        employeeService.updateEmp(employee);
        return "redirect:/employee/list";
    }

    @RequestMapping("/deleteById")
    public String deleteById(String id) {
        employeeService.deleteEmplById(id);
        return "redirect:/employee/list";
    }

}
