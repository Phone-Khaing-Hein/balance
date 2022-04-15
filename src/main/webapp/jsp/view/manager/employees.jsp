<%@page import="com.jdc.balance.model.domain.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page extends="com.jdc.balance.BaseView" %>

<form class="form-inline">
	<div class="form-group">
		<label for="role">Role</label>
		<select name="role" id="role">
			<option value="">All</option>
			<option value="Employee" <%=getSelectedOption(request, "role", "Employee") %>>Employee</option>
			<option value="Manager" <%=getSelectedOption(request, "role", "Manager") %>>Manager</option>
		</select>
	</div>
	
	<div class="form-group">
		<label for="name">Name</label>
		<input type="text" name="name" id="name" value="<%=request.getParameter("name") == null ? "" : request.getParameter("name") %>" placeholder="Search Name" />
	</div>
	
	<div class="form-group">
		<div class="employee-icon">
			<button class="btn  icon-btn" type="submit">
				<img src="<%=getSvg("search") %>" class="icon" alt="" />
				Search
			</button>
			<a href="<%=getPath("/manager/employee/edit") %>" class="btn2  icon-btn">
				<img src="<%=getSvg("user-plus") %>" class="icon" alt="" />
				Add New
			</a>
		</div>
	</div>
</form>

<table>
	<thead>
		<tr>
			<th>Code</th>
			<th>Name</th>
			<th>Role</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Registration</th>
			<th>Retire</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<jsp:useBean id="list" scope="request" type="java.util.List<com.jdc.balance.model.domain.Employee>"></jsp:useBean>
		<% for(Employee emp : list){ %>
		<tr>
			<td><%=emp.getCode() %></td>
			<td><%=emp.getName() %></td>
			<td><%=emp.getRole() %></td>
			<td><%=emp.getEmail() %></td>
			<td><%=emp.getPhone() %></td>
			<td><%=getDateString(emp.getRegistrationDate()) %></td>
			<td><%=getDateString(emp.getRetireDate()) %></td>
			<td>
				<a href="<%=getPath("/manager/employee/edit?code=" + emp.getCode()) %>">
					<img src="<%=getSvg("pencil") %>" class="icon" alt="" />
				</a>
			</td>
		</tr>
		<% } %>
	</tbody>
</table>
