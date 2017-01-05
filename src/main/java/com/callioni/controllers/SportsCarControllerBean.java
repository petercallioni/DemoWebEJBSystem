/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.callioni.controllers;
import com.callioni.entites.Customer;
import com.callioni.entites.SportsCar;
import com.callioni.entjbeans.CarEJB;
import com.callioni.entjbeans.CustomerEJB;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Peter
 */
@Named(value = "sportsCarControllerBean")
@RequestScoped
public class SportsCarControllerBean
{

	/**
	 * Creates a new instance of CarControllerBean
	 */
	public SportsCarControllerBean()
	{
	}
	
	@Inject
	private CarEJB carEJB;
	
	private SportsCar car = new SportsCar();

	/**
	 * Calls the EJB to create a sports car
	 */
	public void createSportsCar()
	{
		carEJB.createSportsCar(car);
		car = null;
	}

	/**
	 * finds all sports cars
	 * @return 
	 */
	public List<SportsCar> findAllCars()
	{
		return carEJB.getSportsCars();
	}

	/**
	 * finds a sports car by ID
	 */
	public void findCarById()
	{
		car = (SportsCar) carEJB.findCarById(car.getId());
	}

	/**
	 * Gets the EJB object
	 * @return 
	 */
	public CarEJB getCarEJB()
	{
		return carEJB;
	}

	/**
	 * sets the EJB object
	 * @param carEJB 
	 */
	public void setCarEJB(CarEJB carEJB)
	{
		this.carEJB = carEJB;
	}

	/**
	 * gets the car object 
	 * @return 
	 */
	public SportsCar getCar()
	{
		return car;
	}

	/***
	 * Sets the car object
	 * @param car 
	 */
	public void setCar(SportsCar car)
	{
		this.car = car;
	}

	/**
	 * Deletes a car by ID
	 * @param id 
	 */
		public void deleteCar(Long id)
	{
		carEJB.deleteSportsCar(id);
	}
}
