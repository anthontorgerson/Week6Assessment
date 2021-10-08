/**
 * @author AnthonT - atorgerson
 * CIS175 - Fall 2021
 * Oct 7, 2021
 */
package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.RaffleDetails;

/**
 * @author AnthonT
 *
 */
public class RaffleDetailHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("NameRaffle");

	public void insertNewRaffleDetails(RaffleDetails s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}

	public List<RaffleDetails> getListName() {
			EntityManager em = emfactory.createEntityManager();
			List<RaffleDetails> allDetails = em.createQuery("SELECT d FROM ListDetails d").getResultList();
			return allDetails;
			}
	
	public void deleteList(RaffleDetails toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<RaffleDetails> typedQuery = em.createQuery("select detail from ListDetails detail where detail.id = :selectedId", RaffleDetails.class);
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setMaxResults(1);
		RaffleDetails result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		}
		public RaffleDetails searchForListDetailsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		RaffleDetails found = em.find(RaffleDetails.class, tempId);
		em.close();
		return found;
		}
		public void updateList(RaffleDetails toEdit) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.merge(toEdit);
			em.getTransaction().commit();
			em.close();
			}
}