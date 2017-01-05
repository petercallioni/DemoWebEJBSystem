/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.callioni.entjbeans;

import com.callioni.entites.Car;
import com.callioni.entites.Customer;
import com.callioni.entites.FamilyCar;
import com.callioni.entites.SportsCar;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Peter
 */
@Stateless
public class CarEJB
{

	@PersistenceContext(unitName = "assignment2PU")
	private EntityManager em;

	/**
	 * Returns all sport car entities in database
	 *
	 * @return
	 */
	public List<SportsCar> getSportsCars()
	{
		List<SportsCar> results;
		TypedQuery<SportsCar> query = em.createQuery("SELECT c FROM SportsCar c", SportsCar.class);
		results = query.getResultList();
		return results;
	}

	/**
	 * Returns all family car entities in database
	 *
	 * @return
	 */
	public List<FamilyCar> getFamilyCars()
	{
		List<FamilyCar> results;
		TypedQuery<FamilyCar> query = em.createQuery("SELECT c FROM FamilyCar c", FamilyCar.class);
		results = query.getResultList();
		return results;
	}

	/**
	 * Create a sports car
	 *
	 * @param sportsCar
	 */
	public void createSportsCar(Car sportsCar)
	{
		em.persist(sportsCar);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Sports Car " + sportsCar.getMake() + " " + sportsCar.getModel() + " successfully created"));
	}

	/**
	 * Create a family car
	 *
	 * @param familyCar
	 */
	public void createFamilyCar(Car familyCar)
	{
		em.persist(familyCar);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Family Car " + familyCar.getMake() + " " + familyCar.getModel() + " successfully created"));
	}

	/**
	 * Finds a car by ID
	 *
	 * @param id
	 * @return
	 */
	public Car findCarById(Long id)
	{
		return em.find(Car.class, id);
	}

	/**
	 * Deletes a family car
	 *
	 * @param id
	 */
	public void deleteFamilyCar(Long id)
	{
		em.remove(em.find(FamilyCar.class, id));
	}

	/**
	 * Deletes a sports car
	 *
	 * @param id
	 */
	public void deleteSportsCar(Long id)
	{
		em.remove(em.find(SportsCar.class, id));
	}
}
