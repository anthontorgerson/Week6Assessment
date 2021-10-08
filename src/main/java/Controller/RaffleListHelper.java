/**
 * @author AnthonT - atorgerson
 * CIS175 - Fall 2021
 * Sep 16, 2021
 */
package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.RaffleList;



/**
 * @author AnthonT
 *
 */
public class RaffleListHelper {
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebNameRaffle");
	
	public void insertEntry(RaffleList e) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		em.close();
	}
	
	// creates a query to show all the entries in our database to our console program
	public List<RaffleList>showAllEntries() {
		EntityManager em = emfactory.createEntityManager();
		List<RaffleList>allEntries = em.createQuery("SELECT e FROM RaffleList e").getResultList();
		return allEntries;
	}
	
	// takes the RaffleList passed into it and searches for it by looking for the listentry by the first name and last name that's passed on
	public void deleteEntry(RaffleList toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<RaffleList>typedQuery = em.createQuery("select e from RaffleList e where e.firstName = :selectedFirstName and e.lastName = :selectedLastName",RaffleList.class);
		
		// substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedFirstName", toDelete.getFirstName());
		typedQuery.setParameter("selectedLastName", toDelete.getLastName());
		
		// we only want one result
		typedQuery.setMaxResults(1);
		
		// get the result and save it into a new list item
		RaffleList result = typedQuery.getSingleResult();
		
		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public RaffleList searchForEntryById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		RaffleList found = em.find(RaffleList.class, idToEdit);
		em.close();
		return found;
	}

	public void updateEntry(RaffleList toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<RaffleList> searchForEntryByFirstName(String FirstName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<RaffleList> typedQuery = em.createQuery("select e from RaffleList e where e.firstName = :selectedFirstName", RaffleList.class);
		typedQuery.setParameter("selectedFirstName", FirstName);
		List<RaffleList> foundEntries = typedQuery.getResultList();
		em.close();
		return foundEntries;
	}

	public List<RaffleList> searchForEntryByLastName(String LastName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<RaffleList> typedQuery = em.createQuery("select e from RaffleList e where e.LastName = :selectedLastName", RaffleList.class);
		typedQuery.setParameter("selectedlastName", LastName);
		List<RaffleList> foundEntries = typedQuery.getResultList();
		em.close();
		return foundEntries;
	}
	
	public void cleanUp(){
		emfactory.close();
		}

}

