<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

   <form class="form-inline">
   		<!-- <div class="form-group">
   			<label for="category">Category</label>
   			<select name="category" id="category">
   				<option value="">All Category</option>
   			</select>
   		</div> -->
   		
   		<div class="form-group">
   			<label for="from">From</label>
   			<input type="date" name="from" placeholder="Search From" />
   		</div>
   		
   		<div class="form-group">
   			<label for="to">To</label>
   			<input type="date" name="to" placeholder="Search To" />
   		</div>
   		
   		<div>
   			<button type="submit" class="btn">Search</button>
   		</div>
   </form>
   
   <table>
   		<thead>
   			<tr>
   				<td>Date</td>
   				<td>Category</td>
   				<td>Employee</td>
   				<td class="right">Income</td>
   				<td class="right">Expense</td>
   				<td class="right">Balance</td>
   			</tr>
   		</thead>
   		<tbody>
   			<% for(int i=0; i<10; i++){ %>
				<tr>
					<td>2021-08-25</td>
					<td>Java Basic</td>
					<td>Aung Aung</td>
					<td class="right">150,000</td>
					<td class="right"></td>
					<td class="right">2,000,000</td>
				</tr>
			<% } %>
   		</tbody>
   </table>