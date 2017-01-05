package com.callioni.entjbeans;

import com.callioni.entites.Customer;
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
public class CustomerEJB
{

	@PersistenceContext(unitName = "assignment2PU")
	private EntityManager em;

	/**
	 * Returns all Customer entities in database
	 *
	 * @return
	 */
	public List<Customer> getCustomers()
	{
		List<Customer> results;
		TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c", Customer.class);
		results = query.getResultList();
		return results;
	}

	/**
	 * Closes the EntityManager connection to the database
	 */
	public void close()
	{
		em.close();
	}

	/**
	 * Creates a customer
	 *
	 * @param customer
	 */
	public void createCustomer(Customer customer)
	{
		em.persist(customer);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Customer " + customer.getFirstName() + " " + customer.getLastName() + " successfully created"));
	}

	/**
	 * Finds a Customer by ID
	 * @param id
	 * @return 
	 */
	public Customer findCustomerById(Long id)
	{
		return em.find(Customer.class, id);
	}

	/**
	 * Finds a customer with first, last names and phone no.
	 * @param firstName
	 * @param lastName
	 * @param phone
	 * @return 
	 */
	public Customer findCustomer(String firstName, String lastName, Integer phone)
	{
		String jpqlQuery = "SELECT c FROM Customer c WHERE c.firstName = :fname AND c.lastName =:lname AND c.phone = :phone";
		TypedQuery query = em.createQuery(jpqlQuery, Customer.class);
		query.setParameter("fname", firstName);
		query.setParameter("lname", lastName);
		query.setParameter("phone", phone);
		return (Customer) query.getSingleResult();
	}

	/**
	 * Delete a customer by ID
	 * @param id 
	 */
	public void deleteCustomer(Long id)
	{
		em.remove(em.find(Customer.class, id));
	}
}
