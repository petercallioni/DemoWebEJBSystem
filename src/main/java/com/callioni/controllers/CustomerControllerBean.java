/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.callioni.controllers;

import com.callioni.entites.Customer;
import com.callioni.entjbeans.CustomerEJB;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Peter
 */
@Named(value = "customerController")
@RequestScoped
public class CustomerControllerBean
{

	public CustomerControllerBean()
	{

	}

	@Inject
	private CustomerEJB customerEJB;

	private Customer customer = new Customer();

	/**
	 * Call EJB to create customer
	 */
	public void createCustomer()
	{
		customerEJB.createCustomer(customer);
		customer = null;
	}

	/**
	 * Call EJB to get list of all customers
	 * @return 
	 */
	public List<Customer> findAllCustomers()
	{
		return customerEJB.getCustomers();
	}

	/**
	 * Call EJB to find customer by ID
	 */
	public void findCustomerById()
	{
		customer = customerEJB.findCustomerById(customer.getId());
	}

	/**
	 * Gets EJB in use
	 * @return 
	 */
	public CustomerEJB getCustomerEJB()
	{
		return customerEJB;
	}

	/**
	 * Sets an EJB
	 * @param customerEJB
	 */
	public void setCustomerEJB(CustomerEJB customerEJB)
	{
		this.customerEJB = customerEJB;
	}

	/**
	 * Returns the customer object
	 * @return 
	 */
	public Customer getCustomer()
	{
		return customer;
	}

	/**
	 * Sets the customer object
	 * @param customer 
	 */
	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}

	/**
	 * Calls deleteCustomer(Long id) in the EJB. Deletes the associated customer
	 * @param id 
	 */
	public void deleteCustomer(Long id)
	{
		customerEJB.deleteCustomer(id);
	}
}
