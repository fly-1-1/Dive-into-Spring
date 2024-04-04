package com.jy.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jy.entity.Employee;
import com.jy.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService{

    @Autowired
    private EmployeeMapper mapper;

    @Override
    public List<Employee> listEmployee() {
       return list();
    }

    @Override
    public void add(Employee employee) {
        //employee.setId(null);
        mapper.insert(employee);
    }

    @Override
    public Employee findEmpById(String id) {
        return getById(id);
    }

    @Override
    public void updateEmp(Employee employee) {
//       lambdaUpdate().eq(Employee::getId,employee.getId())
//               .set(Employee::getName,employee.getName())
//               .set(Employee::getSalary,employee.getSalary())
//               .set(Employee::getGender,employee.getGender())
//               .set(Employee::getBirthday,employee.getBirthday()).update();
        updateById(employee);
    }

    @Override
    public void deleteEmplById(String id) {
        removeById(id);
    }
}
