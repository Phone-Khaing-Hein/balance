package com.jdc.balance.model.repo.impl;

import java.io.Serializable;

public class TransactionIdGenerator implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	
    public synchronized int next() {
        return ++id;
    }

}