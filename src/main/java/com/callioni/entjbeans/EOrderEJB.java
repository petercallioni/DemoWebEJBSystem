/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.callioni.entjbeans;

import com.callioni.entites.Customer;
import com.callioni.entites.EOrder;
import com.callioni.entites.Order_Line;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
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
public class EOrderEJB
{

	@EJB
	private CustomerEJB customerEJB;

	@EJB
	private CarEJB carEJB;

	@PersistenceContext(unitName = "assignment2PU")
	private EntityManager em;

	/**
	 * Gets a list of all entity orders
	 * @return 
	 */
	public List<EOrder> getOrders()
	{
		List<EOrder> results;
		TypedQuery<EOrder> query = em.createQuery("SELECT c FROM EOrder c", EOrder.class);
		results = query.getResultList();
		return results;
	}

	/**
	 * Creates an order
	 * @param id
	 * @param date 
	 */
	public void createEorder(Long id, Date date)
	{
		em.persist(new EOrder(customerEJB.findCustomerById(id), date));
	}

	/**
	 * Creates an order with an order line
	 * @param custId
	 * @param date
	 * @param carId
	 * @param price
	 * @param quantity
	 * @return 
	 */
	public int createEorder(Long custId, Date date, Long carId, Double price, Integer quantity)
	{
		if (customerEJB.findCustomerById(custId) == null)
		{
			return 1;
		}
		if (carEJB.findCarById(carId) == null)
		{
			return 2;
		}
		EOrder order = new EOrder(customerEJB.findCustomerById(custId), date);
		em.persist(order);
		Order_Line line = new Order_Line(order, carEJB.findCarById(carId), price, quantity);
		em.persist(line);
		return 0;
	}

	/**
	 * Creates an order
	 * @param eorder 
	 */
	public void createEorder(EOrder eorder)
	{
		em.persist(eorder);
	}

	/**
	 * Finds an order by id
	 * @param id
	 * @return 
	 */
	public EOrder findOrderById(Long id)
	{
		return em.find(EOrder.class, id);
	}

	/**
	 * Gets order lines belonging to parent order ID
	 * @param id
	 * @return 
	 */
	public List<Order_Line> getOrderLinesById(Long id)
	{
		String jpqlQuery = "SELECT c FROM Order_Line c WHERE c.eorder.id = :EORDER_ID";
		TypedQuery query = em.createQuery(jpqlQuery, Order_Line.class);
		query.setParameter("EORDER_ID", id);
		List<Order_Line> results = query.getResultList();
		return results;
	}

	/**
	 * Gets all order lines
	 * @return 
	 */
	public List<Order_Line> getOrderLines()
	{
		List<Order_Line> results;
		TypedQuery<Order_Line> query = em.createQuery("SELECT c FROM Order_Line c", Order_Line.class);
		results = query.getResultList();
		return results;
	}

	/**
	 * Adds an order line to an order
	 * @param eorderID
	 * @param carID
	 * @param price
	 * @param quantity
	 * @return 
	 */
	public int createOrderLine(Long eorderID, Long carID, Double price, Integer quantity)
	{
		//If EORDER ID is invalid
		if (findOrderById(eorderID) == null)
		{
			return 1;
		}
		//If car ID is invalid
		if (carEJB.findCarById(carID) == null)
		{
			return 2;
		}
		em.persist(new Order_Line(findOrderById(eorderID), carEJB.findCarById(carID), price, quantity));
		return 0;
	}

	/**
	 * Closes the EntityManager connection to the database
	 */
	public void close()
	{
		em.close();
	}

	/**
	 * Deletes an order with all order lines
	 * @param id 
	 */
	public void deleteOrder(Long id)
	{
		String jpqlQuery = "SELECT c FROM Order_Line c WHERE c.eorder.id = :EORDER_ID";
		TypedQuery query = em.createQuery(jpqlQuery, Order_Line.class);
		query.setParameter("EORDER_ID", id);
		List<Order_Line> results = query.getResultList();
		for (Order_Line line : results)
		{
			em.remove(line);
		}
		em.remove(em.find(EOrder.class, id));
	}
	//Could not figure out why this did not work: it should of. maybe it was the JSF it was contained in
	/*public void deleteOrderLine(Long id)
	{		
		Order_Line line = em.find(Order_Line.class, id);
		Long parentOrderId = line.getEorder().getId();
		String jpqlQuery = "SELECT c FROM Order_Line c WHERE c.eorder.id = :EORDER_ID";
		TypedQuery query = em.createQuery(jpqlQuery, Order_Line.class);
		query.setParameter("EORDER_ID", parentOrderId);
		List<Order_Line> results = query.getResultList();
		if (results.size() <= 1)
		{
			em.remove(em.find(EOrder.class, parentOrderId));
		}
		em.remove(line);
	}*/
}
