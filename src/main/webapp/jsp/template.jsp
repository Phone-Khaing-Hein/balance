<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page extends="com.jdc.balance.BaseView" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Balance | <%=request.getAttribute("page-title") %></title>
<link rel="stylesheet" href="<%=getPath("/assets/css/style.css") %>" />
</head>
<body>
	<jsp:useBean id="content" type="java.lang.String" scope="request" />
	<jsp:useBean id="loginInfo" class="com.jdc.balance.security.LoginUser" scope="session"/>
	
	<%
		if(loginInfo.isLogin()){
	%>
			<!-- Employee Template -->
			<main class="employee">
				<header class="container shadow">
					<div class="brand-logo">
						<img src="<%=getSvg("home") %>" class="icon" alt="" />
						Balance
					</div>
					
					<nav>
						<a class='<%=getActiveClass(request, "home") %>' href="<%=getPath("/employee/home") %>">
							<img src="<%=getSvg("meter") %>" class="icon" alt="" />
							Dashboard
						</a>
						<a class='<%=getActiveClass(request, "incomes") %>' href="<%=getPath("/employee/transaction/search?type=Income") %>">
							<img src="<%=getSvg("folder-plus") %>" class="icon" alt="" />
							Incomes
						</a>
						<a class='<%=getActiveClass(request, "expenses") %>' href="<%=getPath("/employee/transaction/search?type=Expense") %>">
							<img src="<%=getSvg("folder-minus") %>" class="icon" alt="" />
							Expenses
						</a>
						<%if(loginInfo.isManager()){ %>
						<a class='<%=getActiveClass(request, "reports") %>' href="<%=getPath("/manager/balance") %>">
							<img src="<%=getSvg("stats-dots") %>" class="icon" alt="" />
							Balance Report
						</a>
						<a class='<%=getActiveClass(request, "employees") %>' href="<%=getPath("/manager/employee/search") %>">
							<img src="<%=getSvg("users") %>" class="icon" alt="" />
							Employees
						</a>
						<%} %>
						<a href="<%=getPath("/logout") %>">
							<img src="<%=getSvg("exit") %>" class="icon" alt="" />
							Logout
						</a>
					</nav>
				</header>
				
				<aside class="sidebar box shadow rounded">
					<!-- Profile Image -->
					<img src="<%=getPath("/assets/images/profile.png") %>" alt="" class="profile-image" />
					
					<!-- Personal Info -->
					<div class="user-name">
						<jsp:getProperty property="name" name="loginInfo"/>
					</div>
					<div class="user-role">
						<jsp:getProperty property="role" name="loginInfo"/>
					</div>
					
					<!-- User Actions -->
					<div class="user-actions">
						<a class="btn2" href="#">Upload Photo</a>
						<a class="btn2" href="<%=getPath("/employee/edit-profile") %>">Edit Profile</a>
						<a class="btn2" href="<%=getPath("/employee/change-password") %>">Change Password</a>
					</div>
				</aside>
			
				<section class="box shadow rounded">
					<div class="view-title">
						<%=request.getAttribute("view-title") %>
					</div>
					
					<jsp:include page="<%= content %>"></jsp:include>
				</section>
			</main>
	<%
		}else {
	%>
			<main class="anonymous">
				<!-- Anonymous Template -->
				<jsp:include page="<%= content %>"></jsp:include>
			</main>
	<%
		}
	%>
	
</body>
</html>