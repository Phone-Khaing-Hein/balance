<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  	<form method="post" class="form w-480">
    	<label for="old-password">Original Password</label>
    	<input type="password" id="old-password" name="old-password" placeholder="Enter Old Password" required="required" />
    	
    	<label for="new-password">New Password</label>
    	<input type="password" id="new-password" name="new-password" placeholder="Enter New Password" required="required" />
    	
    	<label for="confirm-password">Original Password</label>
    	<input type="password" id="confirm-password" name="confirm-password" placeholder="Enter New Password Again" required="required" />
    	
    	<button type="submit" class="btn">Change Password</button>
    </form>
