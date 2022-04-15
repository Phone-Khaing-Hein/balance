package com.jdc.balance.controller;

import java.io.IOException;

import com.jdc.balance.BaseController;
import com.jdc.balance.Destination;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({
	"/login",
	"/logout"
})
public class SecurityController extends BaseController {

	private static final long serialVersionUID = 1L;

	@Override
	protected void process(HttpServletRequest req, HttpServletResponse resp, String path) throws IOException, ServletException {
		switch(path) {
		case "/login" -> login(req, resp);
		case "/logout" -> logout(req, resp); 
		}
	}

	private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Destination loginPage = new Destination.Bulider().req(req).resp(resp).view("login").pageTitle("Login").bulid();
		
       if(isPostRequest(req)) {
    	  handleBussinessError(() -> {
    		  var loginId = req.getParameter("loginId");
	       	   var password = req.getParameter("password");
	       	   
	       	   var employee = userService().login(loginId, password);
	       	   
	       	   getLoginInfo(req).login(employee);
	       	   
	       	   redirect(req, resp, "/employee/home");
    	  }, loginPage);
    	   
       }else {
           navigate(loginPage);
       }
    }


    private void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logout(req);
    	redirect(req, resp, "/login");
    }
}