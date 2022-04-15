<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<div class="balance-summary">
		
		<label for="">Date</label>
		<input type="date" class="mr-100" name="date" required="required" />
		
		<label for="">Employee</label>
		<input type="text" value="Aye Aye" disabled="disabled" class="mr-100" />
		
		<label for="">Items</label>
		<input type="text" value="0" disabled="disabled" class="mr-100 right" />
		
		<label for="">Category</label>
		<input type="text" class="mr-100" placeholder="Enter Category" required="required" name="category" />
		
		<label for="">Status</label>
		<input type="text" value="Not Approve" disabled="disabled" class="mr-100" />
		
		<label for="">Total</label>
		<input type="text" value="0" disabled="disabled" class="mr-100 right" />
	</div>
    
    <div class="right mr-100 actions">
    	<a href="" class="btn">Add Detail</a>
    	<a href="" class="btn2">Save</a>
    </div>
    
    <h3>Expense Detail</h3>
    <table>
    	<thead>
    		<tr>
    			<th>Item</th>
    			<th>Remark</th>
    			<th>Unit Price</th>
    			<th>Quantity</th>
    			<th>Total</th>
    		</tr>
    	</thead>
    	<tbody>
    		<tr>
				<td>
					<input type="text" placeholder="Enter Item Name" class="w-200" />
				</td>
				<td>
					<input type="text" placeholder="Enter Reason" class="w-200" />
				</td>
				<td>
					<input type="number" placeholder="Enter Unit Price" class="w-150" />
				</td>
				<td>
					<input type="number" placeholder="Enter Quantity" class="w-150" />
				</td>
				<td>
					<input type="number" class="w-150" />
				</td>
    		</tr>
    	</tbody>
    </table>