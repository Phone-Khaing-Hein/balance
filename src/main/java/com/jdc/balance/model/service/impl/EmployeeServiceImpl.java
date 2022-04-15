package com.jdc.balance.model.service.impl;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

import com.jdc.balance.model.ServiceManager.Lifecycle;
import com.jdc.balance.model.domain.Employee;
import com.jdc.balance.model.domain.Employee.Role;
import com.jdc.balance.model.repo.EmployeeRepo;
import com.jdc.balance.model.repo.impl.EmployeeRepoImpl;
import com.jdc.balance.model.service.BalanceBussinessException;
import com.jdc.balance.model.service.EmployeeService;
import com.jdc.balance.model.service.UserService;

public class EmployeeServiceImpl implements EmployeeService, UserService, Lifecycle{

    private EmployeeRepo repo;

    private String storage;
    
    private static final String FILE_NAME = "employee.dat";
    
    public EmployeeServiceImpl(String storage) {
    	this.storage = storage;
    	repo = new EmployeeRepoImpl();
    }
    
	@Override
	public void changePassword(String code, String oldPassword, String newPassword) {
		var employee = repo.findByCode(code);
		
		if(!oldPassword.equals(employee.getPassword())) {
			throw new BalanceBussinessException("Please Enter Correct Password!");
		}
		
		employee.setPassword(newPassword);
		repo.update(employee);
	}

	@Override
	public Employee login(String code, String password) {
		var employee = repo.findByCode(code);
		
		if(employee == null) {
			throw new BalanceBussinessException("Login ID or Password required!");
		}
		
		if(!password.equals(employee.getPassword())) {
			throw new BalanceBussinessException("Please Enter Correct Password!");
		}
		
		if(LocalDate.now().compareTo(employee.getRegistrationDate()) < 0) {
			throw new BalanceBussinessException("You can't use the system right now!");
		}
		
		if(employee.getRetireDate() != null && LocalDate.now().compareTo(employee.getRetireDate()) > 0) {
			throw new BalanceBussinessException("You are retired from the System!");
		}
		
		return employee;
	}

	@Override
	public List<Employee> search(Role role, String name) {
		
		Predicate<Employee> filter = data -> true;
				
		if(role != null) {
			filter = filter.and(emp->emp.getRole() == role);
		}
		
		if(name != null) {
			filter = filter.and(emp-> emp.getName().toLowerCase().startsWith(name.toLowerCase()));
		}
		
		return repo.search(filter);
	}

	@Override
	public Employee save(Employee emp) {
		//Validation
		if(emp.getName() == null || emp.getName().isEmpty()) {
			throw new BalanceBussinessException("Please Enter Employee Name!");
		}
		
		if(null == emp.getRole()) {
			throw new BalanceBussinessException("Please Enter Employee Role!");
		}
		
		if(emp.getEmail() == null || emp.getEmail().isEmpty()) {
			throw new BalanceBussinessException("Please Enter Employee Email!");
		}
		
		if(null == emp.getRegistrationDate()) {
			throw new BalanceBussinessException("Please Enter Employee Registration Date!");
		}
		
		if(emp.getCode() == null || emp.getCode().isEmpty()) {
			emp.setPassword(emp.getEmail());
			return repo.create(emp);
		}
		return repo.update(emp);
	}

	@Override
	public Employee findByCode(String code) {
		return repo.findByCode(code);
	}

	@Override
	public void load() {
		try(var input = new ObjectInputStream(new FileInputStream(getDataFile()))){
			
			var object = input.readObject();
			
			if(object != null) {
				repo = (EmployeeRepo) object;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(repo.employeeCount() == 0) {
			var manager = new Employee();
			manager.setRole(Role.Manager);
			manager.setName("Manager");
			manager.setEmail("manager@gmail.com");
			manager.setPhone("0987654321");
			manager.setRegistrationDate(LocalDate.now());
			
			save(manager);
		}
	}

	@Override
	public void save() {
		try(var output = new ObjectOutputStream(new FileOutputStream(getDataFile()))){
			output.writeObject(repo);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private File getDataFile() throws IOException {
		var file = new File(FILE_NAME);
		if(!file.exists()) {
			var fileStorage = new File(storage);
			if(!fileStorage.exists()) {
				fileStorage.mkdir();
			}
			file.createNewFile();
		}
		
		return file;
	}

}