package com.jdc.balance.model.repo;

import java.util.List;
import java.util.function.Predicate;

import com.jdc.balance.model.domain.Transaction;

public interface TransactionRepo {

    public Transaction create(Transaction data);

    public Transaction update(Transaction data);

    public Transaction findById(int id);

    public List<Transaction> search(Predicate<Transaction> filter);

}