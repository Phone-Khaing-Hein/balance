<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<div class="balance-summary">
		
		<label for="">Date</label>
		<input type="date" value="2021-08-01" disabled="disabled" class="mr-100" />
		
		<label for="">Employee</label>
		<input type="text" value="Aye Aye" disabled="disabled" class="mr-100" />
		
		<label for="">Items</label>
		<input type="text" value="3" disabled="disabled" class="mr-100 right" />
		
		<label for="">Category</label>
		<input type="text" value="Stationary" disabled="disabled" class="mr-100" />
		
		
		<label for="">Status</label>
		<input type="text" value="Not Approve" disabled="disabled" class="mr-100" />
		
		<label for="">Total</label>
		<input type="text" value="35000" disabled="disabled" class="mr-100 right" />
	</div>
    
    <div class="right mr-100 actions">
    	<a href="" class="btn">Edit</a>
    	<a href="" class="btn2">Approve</a>
    </div>
    
    <h3>Expense Detail</h3>
    <table>
    	<thead>
    		<tr>
    			<th>Item</th>
    			<th>Remark</th>
    			<th class="right">Unit Price</th>
    			<th class="right">Quantity</th>
    			<th class="right">Total</th>
    		</tr>
    	</thead>
    	<tbody>
    		<% for(int i=0; i<10; i++){ %>
				<tr>
					<td>Laptop</td>
					<td>Some Remark</td>
					<td class="right">2000000</td>
					<td class="right">3</td>
					<td class="right">6000000</td>
				</tr>
			<% } %>
    	</tbody>
    </table>