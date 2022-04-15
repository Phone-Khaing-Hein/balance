package com.jdc.balance.controller;

import java.io.IOException;

import com.jdc.balance.BaseController;
import com.jdc.balance.Destination;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({
	"/employee/transaction/search",
	"/employee/transaction/details",
	"/employee/transaction/edit",
	"/manager/transaction/approve"
})
public class TransactionController extends BaseController {

	private static final long serialVersionUID = 1L;

	private static final String LIST_VIEW = "/employee/transactions";
	private static final String DETAIL_VIEW = "/employee/transactions-details";
	private static final String EDIT_VIEW = "/employee/transactions-edit";
	@Override
	protected void process(HttpServletRequest req, HttpServletResponse resp, String path) throws ServletException, IOException {
		switch(path) {
		case "/employee/transaction/search" -> search(req, resp);
		case "/employee/transaction/details" -> showDetails(req, resp);
		case "/employee/transaction/edit" -> edit(req, resp);
		case "/manager/transaction/approve" -> approve(req, resp);
		}
	}
	
	private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       navigate(destinationBuilder(LIST_VIEW, "Income".equals(req.getParameter("type"))).req(req).resp(resp).bulid());
    }

    private void showDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       navigate(destinationBuilder(DETAIL_VIEW, "Income".equals(req.getParameter("type"))).req(req).resp(resp).bulid());
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       if(isPostRequest(req)) {
    	   redirect(req, resp, "/employee/transaction/details?id=");
       }else {
   			navigate(destinationBuilder(EDIT_VIEW, "Income".equals(req.getParameter("type"))).req(req).resp(resp).bulid());
       }
    }

    private void approve(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	redirect(req, resp, "/employee/transaction/search");
    }

    private Destination.Bulider destinationBuilder(String view, boolean income){
    	Destination.Bulider builder = new Destination.Bulider().view(view);
		
    	if(income) {
     	   builder.pageTitle("Incomes").viewTitle("Daily Incomes").activeMenu("incomes");
        }else {
     	   builder.pageTitle("Expenses").viewTitle("Daily Expenses").activeMenu("expenses");
        }
		
		return builder;
    }
}