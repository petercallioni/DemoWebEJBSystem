package com.callioni.entites;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Describes a generic car entity
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Car implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String colour;

	private String model;

	private String make;

	public Car()
	{

	}

	public Car(String colour, String make, String model)
	{
		this.colour = colour;
		this.model = model;
		this.make = make;
	}
	

	public String getColour()
	{
		return this.colour;
	}

	public void setColour(String colour)
	{
		this.colour = colour;
	}

	
	public String getModel()
	{
		return this.model;
	}

	public void setModel(String model)
	{
		this.model = model;
	}

	public Long getId()
	{
		return this.id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getMake()
	{
		return this.make;
	}

	public void setMake(String make)
	{
		this.make = make;
	}

	@Override
	public String toString()
	{
		return "Car{" + "id=" + id + ", colour=" + colour + ", model=" + model + ", make=" + make + '}';
	}
}
