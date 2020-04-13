package com.example.bootfoodforce.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;



@Entity
public class Order {
	
	
	@Id // indicates a primary key
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "orderSequence")
	@SequenceGenerator(allocationSize = 1, name = "orderSequence", sequenceName = "order_seq")
	private int id;
	
	private String status;
	
	private float total;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CUSTOMERID")
	private Customer customer;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMPLOYEEID")
	private Employee employee;

	public Order() {
		
	}

	public Order(int id, String status, int total, Customer customer, Employee employee) {
		super();
		this.id = id;
		this.status = status;
		this.total = total;
		this.customer = customer;
		this.employee = employee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", status=" + status + ", total=" + total + ", customer=" + customer + ", employee="
				+ employee + "]";
	}
	
	

}
