package com.jdc.balance.model.repo;

import java.util.List;
import java.util.function.Predicate;

import com.jdc.balance.model.domain.Employee;

public interface EmployeeRepo {

    public List<Employee> search(Predicate<Employee> filter);

    public Employee create(Employee data);

    public Employee update(Employee data);

    public Employee findByCode(String code);

	public int employeeCount();

}