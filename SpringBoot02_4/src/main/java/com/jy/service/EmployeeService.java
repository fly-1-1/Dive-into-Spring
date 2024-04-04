package com.jy.service;

import com.jy.entity.Employee;

import java.util.List;

public interface EmployeeService {

   public List<Employee> listEmployee();

   void add(Employee employee);

   Employee findEmpById(String id);

   void updateEmp(Employee employee);

   void deleteEmplById(String id);
}
