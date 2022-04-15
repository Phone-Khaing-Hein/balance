package com.jdc.balance;

import java.io.IOException;

import com.jdc.balance.model.ServiceManager;
import com.jdc.balance.model.service.BalanceBussinessException;
import com.jdc.balance.model.service.EmployeeService;
import com.jdc.balance.model.service.TransactionService;
import com.jdc.balance.model.service.UserService;
import com.jdc.balance.security.LoginUser;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class BaseController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected abstract void process(HttpServletRequest req, HttpServletResponse resp, String path) throws ServletException, IOException;

    protected void navigate(Destination destination) throws ServletException, IOException {
    	String content = String.format("/jsp/view/%s.jsp", destination.getView());
    	destination.getReq().setAttribute("content", content);
    	
    	destination.getReq().setAttribute("page-title", destination.getPageTitle());
    	destination.getReq().setAttribute("view-title", destination.getViewTitle());
    	destination.getReq().setAttribute("active-menu", destination.getActiveMenu());
    	
    	getServletContext().getRequestDispatcher("/jsp/template.jsp").forward(destination.getReq(), destination.getResp());
    }

    protected void redirect(HttpServletRequest req, HttpServletResponse resp, String path) throws ServletException, IOException {
       resp.sendRedirect(getServletContext().getContextPath().concat(path));
    }
    
    protected void handleBussinessError(Action action, Destination errorDestination) throws ServletException, IOException{
    	try {
    		action.execute();
    	}catch(BalanceBussinessException e) {
    		errorDestination.getReq().setAttribute("message", e.getMessage());
    		navigate(errorDestination);
    	}
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doPost(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	process(req, resp, req.getServletPath());
    }
    
    protected LoginUser getLoginInfo(HttpServletRequest req) throws ServletException, IOException{
    	LoginUser loginUser = (LoginUser) req.getSession(true).getAttribute("loginInfo");
    	
    	if(null == loginUser) {
    		loginUser = new LoginUser();
    		req.getSession().setAttribute("loginInfo", loginUser);
    	}
    	return loginUser;
    }
    
    protected void logout(HttpServletRequest req) throws ServletException, IOException {
    	getLoginInfo(req).logout();
    }
    
    protected boolean isPostRequest(HttpServletRequest req) {
    	return "POST".equals(req.getMethod());
    }
    
    protected UserService userService() {
    	return (UserService) getServletContext().getAttribute(ServiceManager.EMPLOYEE_KEY);
    }
    
    protected EmployeeService employeeService() {
    	return (EmployeeService) getServletContext().getAttribute(ServiceManager.EMPLOYEE_KEY);
    }
    
    protected TransactionService transactionService() {
    	return (TransactionService) getServletContext().getAttribute(ServiceManager.TRANSACTION_KEY);
    }
    
    protected boolean isEmpty(String str) {
    	return null == str || str.isEmpty();
    }
    
    protected interface Action{
    	void execute() throws IOException, ServletException;
    }
}