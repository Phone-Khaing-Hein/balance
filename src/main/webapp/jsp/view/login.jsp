<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page extends="com.jdc.balance.BaseView" %>
<section class="card w-480">
	<h3 class="form-title">
		<img src="<%=getSvg("enter") %>" class="icon" alt="" />
		Member Login
	</h3>
	<jsp:include page="/jsp/includes/error-message.jsp"></jsp:include>
	<form action="login" class="form" method="post">
		<label for="loginId">Login Id</label>
		<input placeholder="Enter Login Id" id="loginId" name="loginId" required="required"/>
		
		<label for="password">Password</label>
		<input type="password" placeholder="Enter Password" id="password" name="password" required="required"/>
		
		<button type="submit" class="btn icon-btn">
			<img src="<%=getSvg("checkmark2") %>" class="icon" alt="" />
			Login
		</button>
	</form>
</section>