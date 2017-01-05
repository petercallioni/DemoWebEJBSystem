
package com.callioni.entites;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity to link an EOrder with a Car
 */
@Entity
public class Order_Line implements Serializable
{

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer quantity;
	private Double price;

	public Double getPrice()
	{
		return price;
	}

	public Order_Line(){}
	public Order_Line(EOrder eOrder, Car car, Double price, Integer quantity)
	{
		eorder = eOrder;
		this.car = car;
		this.price = price;
		this.quantity = quantity;
	}
	public void setPrice(Double price)
	{
		this.price = price;
	}
	
	//Car FK
	@ManyToOne
	@JoinColumn(name="CAR_ID")
	private Car car;
	
	//EOrder FK
	@ManyToOne 
	@JoinColumn(name="EORDER_ID")
	private EOrder eorder;

	public Car getCar()
	{
		return car;
	}

	public void setCar(Car car)
	{
		this.car = car;
	}

	public EOrder getEorder()
	{
		return eorder;
	}

	public void setEorder(EOrder eorder)
	{
		this.eorder = eorder;
	}

	public Integer getQuantity()
	{
		return quantity;
	}

	public void setQuantity(Integer quantity)
	{
		this.quantity = quantity;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	@Override
	public int hashCode()
	{
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object)
	{
		if (!(object instanceof Order_Line))
		{
			return false;
		}
		Order_Line other = (Order_Line) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return "ID :" + id + " QUANTITY: "+quantity+" EORDERID: "+eorder.getId()+" CARID: "+ car.getId();
	}
	
}
