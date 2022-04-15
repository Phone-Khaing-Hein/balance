package com.jdc.balance.model.domain;

import java.io.Serializable;
import java.time.LocalDate;

import com.jdc.balance.security.UserProfile;

public class Employee implements UserProfile, Serializable{
	
	private static final long serialVersionUID = 1L;

	private String code;

    private String name;

    private String phone;

    private String email;
    
    private String password;

    private LocalDate registrationDate;

    private LocalDate retireDate;

    private Role role;
    
	public enum Role {
        Employee,
        Manager
    }

    public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public LocalDate getRegistrationDate() {
		return registrationDate;
	}


	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}


	public LocalDate getRetireDate() {
		return retireDate;
	}


	public void setRetireDate(LocalDate retireDate) {
		this.retireDate = retireDate;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}
	
}