package com.callioni.entites;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Column;
/**
 * Describes an entity that holds customer information
 * @author Peter
 */
@Entity
public class Customer implements Serializable
{
	@Id
	@Column(name = "CUSTOMER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String firstName;

	private String lastName;

	private Integer phone;

	private Integer postCode;

	private String customerState;

	private String email;

	private String address;

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public Customer()
	{

	}

	public Customer(String firstName, String lastName, Integer phone, String address, Integer postCode, String _state, String email)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
		this.postCode = postCode;
		this.customerState = _state;
		this.email = email;
	}

	public String getFirstName()
	{
		return this.firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return this.lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public Integer getPhone()
	{
		return this.phone;
	}

	public void setPhone(Integer phone)
	{
		this.phone = phone;
	}

	public Integer getPostCode()
	{
		return this.postCode;
	}

	public void setPostCode(Integer postCode)
	{
		this.postCode = postCode;
	}

	public Long getId()
	{
		return this.id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getCustomerState()
	{
		return this.customerState;
	}

	public void setCustomerState(String state)
	{
		this.customerState = state;
	}

	public String getEmail()
	{
		return this.email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}
	@Override
	public String toString()
	{
		return "ID: "+id+" FIRSTNAME: "+firstName+" LASTNAME: "+lastName+" PHONE: "+phone+" ADDRESS: "+address+" POSTCODE: "+postCode+" STATE: "+customerState+" EMAIL: "+email;
	}
}
