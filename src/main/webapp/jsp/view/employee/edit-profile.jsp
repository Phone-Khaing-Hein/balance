<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page extends="com.jdc.balance.BaseView" %>
    
    <jsp:useBean id="loginInfo" scope="session" type="com.jdc.balance.security.LoginUser"></jsp:useBean>
    
<form class="form w-480" method="post">
	<label for="code">Employee Code</label>
	<input type="text" value="<%=loginInfo.profile().getCode() %>" id="code" name="code" readonly="readonly"  />
	
	<label for="name">Employee Name</label>
	<input type="text" value="<%=loginInfo.profile().getName() %>" name="name" id="name" placeholder="Enter Your Name" required="required" />
	
	<label for="phone">Phone Number</label>
	<input type="tel" value="<%=loginInfo.profile().getPhone() %>" name="phone" id="phone" placeholder="Enter Your Phone" required="required" />
	
	<label for="email">Email</label>
	<input type="email" value="<%=loginInfo.profile().getEmail() %>" name="email" id="email" placeholder="Enter Your Email" required="required" />
	
	<button type="submit" class="btn">Save Profile</button>
</form>