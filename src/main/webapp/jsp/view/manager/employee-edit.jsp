<%@page import="com.jdc.balance.model.domain.Employee"%>
<%@page import="com.jdc.balance.model.repo.impl.EmployeeRepoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page extends="com.jdc.balance.BaseView" %>
    
    <jsp:useBean id="employee" scope="request" class="com.jdc.balance.model.domain.Employee"></jsp:useBean>
    
    <form method="post" class="form w-480">
    	<div class="row">
    		<div>
    			<label for="code">Code</label>
	    		<input type="text" name="code" id="code" value="<%=getProperty(employee.getCode()) %>" readonly="readonly"  class="mr-13 w-150" />
    		</div>
	    	
	    	<div>
	    		<label for="role">Role</label>
		    	<select name="role" id="role" class="w-300">
		    		<option value="Employee">Employee</option>
		    		<option value="Manager">Manager</option>
		    	</select>
	    	</div>
    	</div>
    	
    	<label for="name">Name</label>
    	<input type="text" name="name" id="name" placeholder="Enter Name" value="<%=getProperty(employee.getName()) %>" />
    	
    	<label for="phone">Phone</label>
    	<input type="tel" name="phone" id="phone" placeholder="Enter Phone Number" value="<%=getProperty(employee.getPhone()) %>" />
    	
    	<label for="email">Email</label>
    	<input type="email" name="email" id="email" placeholder="Enter Email" value="<%=getProperty(employee.getEmail()) %>" />

    	<div class="row">
    		<div>
    			<label for="reg">Registration Date</label>
    			<input type="date" name="registrationDate" id="reg" class="w-200 mr-13" value="<%=getDateString(employee.getRegistrationDate()) %>" />
    		</div>
    		<div>
    			<label for="reg">Retire Date</label>
    			<input type="date" name="retireDate" id="reg" class="w-200" value="<%=getDateString(employee.getRetireDate()) %>" />
    		</div>
    	</div>
    	
    	<button type="submit" class="btn">Save Employee</button>
    
    </form>