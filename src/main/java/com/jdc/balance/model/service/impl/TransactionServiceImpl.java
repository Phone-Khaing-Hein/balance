package com.jdc.balance.model.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

import com.jdc.balance.model.ServiceManager.Lifecycle;
import com.jdc.balance.model.domain.Transaction;
import com.jdc.balance.model.domain.Transaction.Type;
import com.jdc.balance.model.repo.TransactionRepo;
import com.jdc.balance.model.service.BalanceBussinessException;
import com.jdc.balance.model.service.TransactionService;

public class TransactionServiceImpl implements TransactionService, Lifecycle {

    private static final String FILE_NAME = "transaction.dat";

	private TransactionRepo repo;
    
    private String storage;
    
    public TransactionServiceImpl(String storage) {
    	this.storage = storage;
    }

	@Override
	public List<Transaction> search(Type type, Date from, Date to, String category) {
		Predicate<Transaction> filter = data -> true;
		
		if(type != null) {
			filter = filter.and(data -> data.getType() == type);
		}
		
		if(from != null) {
			filter = filter.and(data -> data.getDate().compareTo(from) >= 0);
		}
		
		if(to != null) {
			filter = filter.and(data -> data.getDate().compareTo(to) <= 0);
		}
		
		if(null != category && !category.isEmpty()) {
			filter = filter.and(data -> data.getCategory().toLowerCase().startsWith(category.toLowerCase()));
		}
		
		return repo.search(filter);
	}

	@Override
	public Transaction fingById(int id) {
		return repo.findById(id);
	}

	@Override
	public Transaction save(Transaction data) {
		if(data.getDate() == null) {
			throw new BalanceBussinessException("Transaction Date is required!");
		}
		
		if(data.getType() == null) {
			throw new BalanceBussinessException("Transaction Type is required!");
		}
		
		if(data.getCategory() == null || data.getCategory().isEmpty()) {
			throw new BalanceBussinessException("Transaction Category is required!");
		}
		
		if(data.getEmployee() == null) {
			throw new BalanceBussinessException("Employee is required!");
		}
		
		if(data.getDetails() == null || data.getDetails().isEmpty()){
			throw new BalanceBussinessException("Transaction Detail is required!");
		}
		
		if(data.getId() == 0) {
			return repo.create(data);
		}
		
		return repo.update(data);
	}

	@Override
	public void approve(int id) {
		var data = repo.findById(id);
		data.setApproved(true);
		repo.update(data);
	}

	@Override
	public void load() {
		try(var input = new ObjectInputStream(new FileInputStream(getDataFile()))){
			var object = input.readObject();
			
			if(object != null) {
				repo = (TransactionRepo) object;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void save() {
		try(var output = new ObjectOutputStream(new FileOutputStream(getDataFile()))){
			output.writeObject(repo);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private File getDataFile() throws IOException {
		var file = new File(FILE_NAME);
		if(!file.exists()) {
			var fileStorage = new File(storage);
			if(!fileStorage.exists()) {
				fileStorage.mkdir();
			}
			file.createNewFile();
		}
		
		return file;
	}
}