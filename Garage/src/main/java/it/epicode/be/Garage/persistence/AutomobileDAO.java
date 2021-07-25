package it.epicode.be.Garage.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import it.epicode.be.Garage.model.Automobile;
import it.epicode.be.Garage.util.JpaUtil;

public class AutomobileDAO {
	EntityManager em = JpaUtil.getEntityManager();

	public void save(Automobile a) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(a);
			em.getTransaction().commit();
		} finally {

		}
	}

	public Automobile getById(Long id) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			Automobile a = em.find(Automobile.class, id);
			return a;
		} finally {

		}
	}

	public void deleteByID(Long id) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			Automobile a = em.find(Automobile.class, id);
			em.getTransaction().begin();
			em.remove(a);
			em.getTransaction().commit();
		} finally {

		}
	}

	public void delete(Automobile a) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(a);
			em.getTransaction().commit();
		} finally {

		}
	}

	public void refresh(Automobile a) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			em.refresh(a);
		} finally {

		}

	}
	@SuppressWarnings("unchecked")
	public List<Automobile> getAuto(){
		EntityManager em = JpaUtil.getEntityManager();
		Query query = em.createQuery("SELECT a FROM Automobile a");
		List<Automobile> result = query.getResultList();
		return result;
	}
}
