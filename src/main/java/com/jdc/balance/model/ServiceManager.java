package com.jdc.balance.model;

import com.jdc.balance.model.service.impl.EmployeeServiceImpl;
import com.jdc.balance.model.service.impl.TransactionServiceImpl;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ServiceManager implements ServletContextListener{

	public static final String EMPLOYEE_KEY = "com.jdc.employee";
	public static final String TRANSACTION_KEY = "com.jdc.transaction";
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		var storage = sce.getServletContext().getRealPath("data");
		
		var employee = new EmployeeServiceImpl(storage);
		sce.getServletContext().setAttribute(EMPLOYEE_KEY, employee);
		employee.load();
		
		var transaction = new TransactionServiceImpl(storage);
		sce.getServletContext().setAttribute(TRANSACTION_KEY, transaction);
		transaction.load();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		var employee = (Lifecycle)sce.getServletContext().getAttribute(EMPLOYEE_KEY);
		employee.save();
		
		var transaction = (Lifecycle)sce.getServletContext().getAttribute(TRANSACTION_KEY);
		transaction.save();
	}
	
	public interface Lifecycle{
		void load();
		void save();
	}

}
