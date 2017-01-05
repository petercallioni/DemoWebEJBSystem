/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.callioni.controllers;
import com.callioni.entites.FamilyCar;
import com.callioni.entjbeans.CarEJB;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Peter
 */
@Named(value = "familyCarControllerBean")
@RequestScoped
public class FamilyCarControllerBean
{

	/**
	 * Creates a new instance of CarControllerBean
	 */
	public FamilyCarControllerBean()
	{
	}
	
	@Inject
	private CarEJB carEJB;
	
	private FamilyCar car = new FamilyCar();

	/**
	 * Calls the EJB to create a family car
	 */
	public void createFamilyCar()
	{
		carEJB.createFamilyCar(car);
		car = null;
	}

	/**
	 * Find all family cars
	 * @return 
	 */
	public List<FamilyCar> findAllCars()
	{
		return carEJB.getFamilyCars();
	}

	/**
	 * Find a family car by ID
	 */
	public void findCarById()
	{
		car = (FamilyCar) carEJB.findCarById(car.getId());
	}

	/**
	 * Gets the RJB
	 * @return 
	 */
	public CarEJB getCarEJB()
	{
		return carEJB;
	}

	/** 
	 * Sets the EJB
	 * @param carEJB 
	 */
	public void setCarEJB(CarEJB carEJB)
	{
		this.carEJB = carEJB;
	}

	/**
	 * Gets the family car object
	 * @return 
	 */
	public FamilyCar getCar()
	{
		return car;
	}

	/**
	 * Sets the family car object
	 * @param car 
	 */
	public void setCar(FamilyCar car)
	{
		this.car = car;
	}

	/**
	 * Deletes a car by ID
	 * @param id 
	 */
			public void deleteCar(Long id)
	{
		carEJB.deleteFamilyCar(id);
	}
}
