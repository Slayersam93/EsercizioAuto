package it.epicode.be.Garage.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import it.epicode.be.Garage.model.Persona;
import it.epicode.be.Garage.util.JpaUtil;

public class PersonaDAO {
	EntityManager em = JpaUtil.getEntityManager();

	public void save(Persona p) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
		} finally {

		}
	}

	public Persona getById(Long id) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			Persona p = em.find(Persona.class, id);
			return p;
		} finally {

		}
	}

	public void deleteByID(Long id) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			Persona p = em.find(Persona.class, id);
			em.getTransaction().begin();
			em.remove(p);
			em.getTransaction().commit();
		} finally {

		}
	}

	public void delete(Persona p) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(p);
			em.getTransaction().commit();
		} finally {

		}
	}

	public void refresh(Persona p) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			em.refresh(p);
		} finally {

		}

	}

	@SuppressWarnings("unchecked")
	public List<Persona> getPersona() {
		EntityManager em = JpaUtil.getEntityManager();
		Query query = em.createQuery("SELECT a FROM Persona a");
		List<Persona> result = query.getResultList();
		return result;
	}
}
