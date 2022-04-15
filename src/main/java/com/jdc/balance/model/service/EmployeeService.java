package com.jdc.balance.model.service;

import java.util.List;

import com.jdc.balance.model.domain.Employee;
import com.jdc.balance.model.domain.Employee.Role;

public interface EmployeeService {

    public List<Employee> search(Role role, String name);

    public Employee save(Employee emp);

    public Employee findByCode(String code);

}