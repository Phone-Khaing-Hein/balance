package com.jdc.balance.model.repo.impl;

import java.io.Serializable;

public class EmployeeCodeGenerator implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	
    public synchronized String next() {
        return String.format("EMP-%03d", ++id);
    }

}