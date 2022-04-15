package com.jdc.balance.controller;

import java.io.IOException;

import com.jdc.balance.BaseController;
import com.jdc.balance.Destination;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({
	"/employee/home",
	"/employee/change-password",
	"/employee/edit-profile",
	"/employee/save-profile"
})
public class UserController extends BaseController {

	private static final long serialVersionUID = 1L;

	@Override
	protected void process(HttpServletRequest req, HttpServletResponse resp, String path) throws ServletException, IOException {
		switch(path) {
		case "/employee/home" -> loadHome(req, resp);
		case "/employee/change-password" -> changePassword(req, resp);
		case "/employee/edit-profile" -> editProfile(req, resp);
		}
	}
	
	private void loadHome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//TODO user load home action
		
		Destination.Bulider builder = new Destination.Bulider();
		builder.req(req).resp(resp).view("employee/home").pageTitle("Home").viewTitle("Dashboard").activeMenu("home");
        navigate(builder.bulid());
	}
	
    private void changePassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	if(isPostRequest(req)) {
    		//TODO save password
    		
    		redirect(req, resp, "/employee/home");
    	}else {
    		Destination.Bulider builder = new Destination.Bulider();
    		builder.req(req).resp(resp).view("employee/change-password").pageTitle("Password").viewTitle("Change Password").activeMenu("home");
            navigate(builder.bulid());
    	}
    }

    private void editProfile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	var profileEditPage = new Destination.Bulider()
    										 .req(req).resp(resp)
    										 .view("/employee/edit-profile")
    										 .pageTitle("Profile")
    										 .viewTitle("Edit Profile")
    										 .activeMenu("home").bulid();
    	
    	if(isPostRequest(req)) {
    		handleBussinessError(() -> {
    			var code = req.getParameter("code");
    			var employee = employeeService().findByCode(code);
    			
    			employee.setName(req.getParameter("name"));
    			employee.setPhone(req.getParameter("phone"));
    			employee.setEmail("email");
    			
    			var user = employeeService().save(employee);
    			
    			getLoginInfo(req).login(user);
    			
    			redirect(req, resp, "/employee/home");
    		}, profileEditPage);
    	}else {
            navigate(profileEditPage);
    	}
    }
}