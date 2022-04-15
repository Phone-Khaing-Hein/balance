package com.jdc.balance;

import java.time.LocalDate;

import org.apache.jasper.runtime.HttpJspBase;

import com.jdc.balance.utils.DateUtils;

import jakarta.servlet.http.HttpServletRequest;

public abstract class BaseView extends HttpJspBase{

	private static final long serialVersionUID = 1L;

	protected String getPath(String path){
		return getServletContext().getContextPath().concat(path);
	}
	
	protected String getSvg(String name) {
		return String.format("%s/assets/svg/%s.svg", getServletContext().getContextPath(), name);
	}
	
	protected String getActiveClass(HttpServletRequest req, String menu){
		 return req.getAttribute("active-menu").equals(menu) ? "active" : "";
	}
	
	protected String getSelectedOption(HttpServletRequest req, String name,String value){
		String requestValue = req.getParameter(name);
		if(null != requestValue && requestValue.equals(value)){
			return "selected=selected";
		}
		return "";
	}
	
	protected String getDateString(LocalDate date) {
		return DateUtils.dateToString(date);
	}
	
	protected String getProperty(String value) {
		return null == value ? "" : value;
	}
}
