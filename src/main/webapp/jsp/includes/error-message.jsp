<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String message = (String)request.getAttribute("message");
	
	if(message != null && !message.isEmpty()){
		
%>
	<p class="message"><%=message %></p>
<%		
	}
%>