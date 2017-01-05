/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.callioni.controllers;

import com.callioni.entites.EOrder;
import com.callioni.entites.Order_Line;
import com.callioni.entjbeans.EOrderEJB;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Peter
 */
@Named(value = "eorderControllerBean")
@RequestScoped
public class EOrderControllerBean
{

	/**
	 * Creates a new instance of CarControllerBean
	 */
	public EOrderControllerBean()
	{
	}

	@Inject
	private EOrderEJB eorderEJB;

	private EOrder eOrder = new EOrder();
	private Order_Line order_Line = new Order_Line();

	private List<Order_Line> lines;

	/**
	 * Gets order lines associated with the managed bean
	 * @return 
	 */
	public List<Order_Line> getLines()
	{
		return lines;
	}

	/**
	 * Sets list of lines
	 * @param lines 
	 */
	public void setLines(List<Order_Line> lines)
	{
		this.lines = lines;
	}

	/**
	 * Calls eorderEJB to create an order with an order line
	 * @param custId
	 * @param date
	 * @param carId
	 * @param price
	 * @param quantity 
	 */
	public void createOrder(Long custId, Date date, Long carId, Double price, Integer quantity)
	{
		//status ID
		switch (eorderEJB.createEorder(custId, date, carId, price, quantity))
		{
			case 0:
			{
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Order for customer " + custId + " for car " + carId + " successfully created"));
				break;
			}
			case 1:
			{
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "The Customer ID is incorrect", ""));
				break;
			}
			case 2:
			{
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "The Car ID incorrect", ""));
				break;
			}
		}
	}

	/**
	 * Gets all Orders from database
	 * @return 
	 */
	public List<EOrder> findAllOrders()
	{
		return eorderEJB.getOrders();
	}

	/**
	 * Find a order by ID
	 */
	public void findOrderById()
	{
		eOrder = eorderEJB.findOrderById(eOrder.getId());
	}

	/**
	 * Gets all order lines in database
	 * @return 
	 */
	public List<Order_Line> findAllOrder_Lines()
	{
		return eorderEJB.getOrderLines();
	}

	/**
	 * Gets an list of order lines by parent eorder id
	 * @param id
	 * @return 
	 */
	public List<Order_Line> findOrderLineById(Long id)
	{
		return eorderEJB.getOrderLinesById(id);
	}

	/**
	 * get EorderEJB
	 * @return 
	 */
	public EOrderEJB getEOrderEJB()
	{
		return eorderEJB;
	}

	/**
	 * sets the EorderEJB
	 * @param eOrderEJB 
	 */
	public void setEOrderEJB(EOrderEJB eOrderEJB)
	{
		this.eorderEJB = eOrderEJB;
	}

	/**
	 * Adds an order line to an existing order
	 * @param orderID
	 * @param carID
	 * @param price
	 * @param quantity 
	 */
	public void createOrderLine(Long orderID, Long carID, Double price, Integer quantity)
	{

		switch (eorderEJB.createOrderLine(orderID, carID, price, quantity))
		{
			case 0:
				{
					FacesContext context = FacesContext.getCurrentInstance();
					context.addMessage(null, new FacesMessage("Order line for order " + orderID + " for car " + carID + " successfully added"));
					break;
				}
			case 1:
				{
					FacesContext context = FacesContext.getCurrentInstance();
					context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "The he Order ID is incorrect", ""));
					break;
				}
			case 2:
				{
					FacesContext context = FacesContext.getCurrentInstance();
					context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "The Car ID is incorrect", ""));
					break;
				}
		}
	}

	/**
	 * Deletes and order by ID
	 * @param id 
	 */
	public void deleteOrder(Long id)
	{
		eorderEJB.deleteOrder(id);
	}

	/*
	public void deleteOrderLine(Long id)
	{
		eorderEJB.deleteOrderLine(id);
	}
	 */
}
