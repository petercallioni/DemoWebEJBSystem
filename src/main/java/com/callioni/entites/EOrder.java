package com.callioni.entites;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Describes an entity the holds a order
 */
@Entity
public class EOrder implements Serializable
{
		
	@Id
	@Column(name = "EORDER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfPurchase;

	//Customer FK
	@ManyToOne
	@JoinColumn(name="CUSTOMER_ID")
	private Customer customer;

	public Customer getCustomer()
	{
		return customer;
	}

	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}

	public EOrder()
	{
				
	}
	public EOrder(Customer customer, Date date)
	{
		setCustomer(customer);
		setDateOfPurchase(date);
	}
	public Date getDateOfPurchase()
	{
		return this.dateOfPurchase;
	}

	public void setDateOfPurchase(Date dateOfPurchase)
	{
		this.dateOfPurchase = dateOfPurchase;
	}

	public Long getId()
	{
		return this.id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}
	@Override
	public String toString()
	{
		return "ID: "+id+" DATE: "+ dateOfPurchase+" CUSTOMERID: "+customer.getId();
	}
}
