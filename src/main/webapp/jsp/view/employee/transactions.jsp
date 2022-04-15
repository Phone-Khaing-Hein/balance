<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page extends="com.jdc.balance.BaseView" %>
    <form class="form-inline">
    <!-- 	<div class="form-group">
	  		<label for="employee">Employee</label>
	 		<input type="text" id="employee" placeholder="Employee Name"/>
	  	</div>
	 -->  	

    	<div class="form-group">
   			<label for="from">From</label>
   			<input type="date" name="from" placeholder="Search From" />
   		</div>
   		
   		<div class="form-group">
   			<label for="to">To</label>
   			<input type="date" name="to" placeholder="Search To" />
   		</div>
   		
   		<div class="form-group">
    		<label for="category">Category</label>
    		<input type="text" placeholder="Search Category" name="category" id="category" />
    	</div>

   		<div class="form-group">
			<button class="btn" type="submit">Search</button>
			<a href="<%=getPath("/employee/transaction/edit") %>" class="btn2">Add New</a>
		</div>
    </form>
    
    <table>
    	<thead>
    		<tr>
    			<th>Date</th>
    			<th>Employee</th>
    			<th>Category</th>
    			<th>Approved</th>
    			<th class="right">Items</th>
    			<th class="right">Amount</th>
    		</tr>
    	</thead>
    	<tbody>
    		<% for(int i=0; i<10; i++){ %>
				<tr>
					<td>
						<a href="<%=getPath("/employee/transaction/details") %>">2021-08-25</a>
					</td>
					<td>Aung Aung</td>
					<td>Drinks</td>
					<td>Yes</td>
					<td class="right">6</td>
					<td class="right">500,000</td>
				</tr>
			<% } %>
    	</tbody>
    </table>
