package com.jdc.balance.model.service;

import com.jdc.balance.model.domain.Employee;

public interface UserService {

    public void changePassword(String code, String oldPassword, String newPassword);

    public Employee login(String code, String password);

}