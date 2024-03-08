package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ACCOUNTS")
public class Account {
    public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public int getIFSC() {
		return IFSC;
	}
	public void setIFSC(int iFSC) {
		IFSC = iFSC;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Id
    private String customerId;
    private int accountNo;
    private String type;
    private int mobile;
    private int IFSC;
    public Account(String customerId, int accountNo, String type, int mobile, int iFSC, double amount,
			String password) {
		super();
		this.customerId = customerId;
		this.accountNo = accountNo;
		this.type = type;
		this.mobile = mobile;
		IFSC = iFSC;
		this.amount = amount;
		this.password = password;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	private double amount;
    private String password;

    // Constructors, getters, and setters
}