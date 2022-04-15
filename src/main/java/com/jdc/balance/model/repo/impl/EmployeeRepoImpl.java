package com.jdc.balance.model.repo.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import com.jdc.balance.model.domain.Employee;
import com.jdc.balance.model.repo.EmployeeRepo;

public class EmployeeRepoImpl implements EmployeeRepo, Serializable{

	private static final long serialVersionUID = 1L;

	private Map<String, Employee> domain;

    private EmployeeCodeGenerator codeGenerator;
    
    public EmployeeRepoImpl() {
		domain = new HashMap<>();
		codeGenerator = new EmployeeCodeGenerator();
	}

	@Override
	public List<Employee> search(Predicate<Employee> filter) {
		return domain.values().stream().filter(filter).toList();
	}

	@Override
	public Employee create(Employee data) {
		var code = codeGenerator.next();
		data.setCode(code);
		domain.put(code, data);
		return data;
	}

	@Override
	public Employee update(Employee data) {
		domain.put(data.getCode(), data);
		return data;
	}

	@Override
	public Employee findByCode(String code) {
		return domain.get(code);
	}

	@Override
	public int employeeCount() {
		return domain.size();
	}

}