package com.jdc.balance;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Destination {
	private HttpServletRequest req;
	private HttpServletResponse resp;
	private String view;
	private String pageTitle;
	private String viewTitle;
	private String activeMenu;
	
	public static class Bulider{
		private HttpServletRequest req;
		private HttpServletResponse resp;
		private String view;
		private String pageTitle;
		private String viewTitle;
		private String activeMenu;
		
		public Destination bulid() {
			return new Destination(req, resp, view, pageTitle, viewTitle, activeMenu);
		}
		
		public Bulider req(HttpServletRequest req) {
			this.req = req;
			return this;
		}
		
		public Bulider resp(HttpServletResponse resp) {
			this.resp = resp;
			return this;
		}
		
		public Bulider view(String view) {
			this.view = view;
			return this;
		}
		
		public Bulider pageTitle(String pageTitle) {
			this.pageTitle = pageTitle;
			return this;
		}
		
		public Bulider viewTitle(String viewTitle) {
			this.viewTitle = viewTitle;
			return this;
		}
		
		public Bulider activeMenu(String activeMenu) {
			this.activeMenu = activeMenu;
			return this;
		}
	}
	
	private Destination(HttpServletRequest req, HttpServletResponse resp, String view, String pageTitle,
			String viewTitle, String activeMenu) {
		super();
		this.req = req;
		this.resp = resp;
		this.view = view;
		this.pageTitle = pageTitle;
		this.viewTitle = viewTitle;
		this.activeMenu = activeMenu;
	}

	public HttpServletRequest getReq() {
		return req;
	}

	public void setReq(HttpServletRequest req) {
		this.req = req;
	}

	public HttpServletResponse getResp() {
		return resp;
	}

	public void setResp(HttpServletResponse resp) {
		this.resp = resp;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public String getViewTitle() {
		return viewTitle;
	}

	public void setViewTitle(String viewTitle) {
		this.viewTitle = viewTitle;
	}

	public String getActiveMenu() {
		return activeMenu;
	}

	public void setActiveMenu(String activeMenu) {
		this.activeMenu = activeMenu;
	}
}
