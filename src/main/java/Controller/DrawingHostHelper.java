/**
 * @author AnthonT - atorgerson
 * CIS175 - Fall 2021
 * Oct 7, 2021
 */
package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.DrawingHost;

/**
 * @author AnthonT
 *
 */
//package and import statements
public class DrawingHostHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("NameRaffle");

	public void insertDrawingHost(DrawingHost s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}

	public List<DrawingHost> showAllDrawingHosts() {
		EntityManager em = emfactory.createEntityManager();
		List<DrawingHost> allDrawingHosts = em.createQuery("SELECT s FROM DrawingHost s").getResultList();
		return allDrawingHosts;
	}

	public DrawingHost findHost(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<DrawingHost> typedQuery = em.createQuery("select sh from DrawingHost sh where sh.hostName = :selectedName", DrawingHost.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		DrawingHost foundHost;
		try {
		foundHost = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
		foundHost= new DrawingHost(nameToLookUp);
		}
		em.close();
		return foundHost;
}
}