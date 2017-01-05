/**
 * This bean is used to determine when to show content and hold variables to do so
 */
package com.callioni.controllers;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Peter
 */
@Named(value = "pageController")
@RequestScoped
public class PageController
{

	private boolean showCust = false;
	private boolean showOrders = false;
	private boolean showCars = false;

	private Long showOrderLines = 0L;

	public void setShowOrderLines(Long showOrderLines)
	{
		this.showOrderLines = showOrderLines;
	}

	public Long getShowOrderLines()
	{
		return showOrderLines;
	}

	public PageController()
	{
	}

	public boolean isShowCust()
	{
		return showCust;
	}

	public void setShowCust(boolean showCust)
	{
		this.showCust = showCust;
	}

	public boolean isShowOrders()
	{
		return showOrders;
	}

	public void setShowOrders(boolean showOrders)
	{
		this.showOrders = showOrders;
	}

	public boolean isShowCars()
	{
		return showCars;
	}

	public void setShowCars(boolean showCars)
	{
		this.showCars = showCars;
	}

}
