package com.tp.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tp.datasource.EMF;

@Repository
public class GenericDAOHibernateJPA<T> implements GenericDAO<T> {
	
	

	protected Class<T> persistentClass;
	
	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager){
	this.entityManager = entityManager;
	}
	public EntityManager getEntityManager() {
	return entityManager;
	}
	
	
	
	public GenericDAOHibernateJPA() {
		
	}
    



	public GenericDAOHibernateJPA(Class<T> clase) {
		this.persistentClass = clase;
	}
	
	@Transactional
	public T alta(T entity) {
	 
		this.getEntityManager().persist(entity);
		return entity;
	
	}
//	public T alta(T entity) {
//
//		EntityManager em = EMF.getEMF().createEntityManager();
//		EntityTransaction tx = null;
//		try {
//			tx = em.getTransaction();
//			tx.begin();
//			em.persist(entity);
//			tx.commit();
//		} catch (RuntimeException e) {
//			if (tx != null && tx.isActive())
//				tx.rollback();
//			throw e; // escribir en un log o mostrar un mensaje
//		} finally {
//			em.close();
//		}
//
//		return entity;
//
//	}
	
	@Transactional
	public T modificacion(T entity) {
		
		T nueva = this.getEntityManager().merge(entity);
		return nueva;
		
	}

//	public T modificacion(T entity) {
//		EntityManager em = EMF.getEMF().createEntityManager();
//		EntityTransaction etx = em.getTransaction();
//		etx.begin();
//		T nueva = em.merge(entity);// XXX
//		etx.commit();
//		em.close();
//		return nueva;
//	}

	public T baja(Long id) {
		EntityManager em = EMF.getEMF().createEntityManager();
		EntityTransaction etx = em.getTransaction();
		etx.begin();

		Query consulta = em.createQuery("update "
				+ this.persistentClass.getSimpleName()
				+ " e set e.baja = true where ( id = :id)");
		consulta.setParameter("id", id);
		consulta.executeUpdate();

		em.flush();
		etx.commit();
		T entity = em.find(persistentClass, id);
		em.close();

		return entity;

	}

	public T recuperacion(Long id) {

		EntityManager em = EMF.getEMF().createEntityManager();
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		Query consulta = em.createQuery("update "
				+ this.persistentClass.getSimpleName()
				+ " e set e.baja = false where ( id = :id)");
		consulta.setParameter("id", id);
		consulta.executeUpdate();

		em.flush();
		etx.commit();
		T entity = em.find(persistentClass, id);
		em.close();

		return entity;
	}

	public List<T> recuperacionGenerica(String str, String columna) {

		List<T> resultado = null;
		EntityManager em = EMF.getEMF().createEntityManager();
		Query consulta = em.createQuery("select e from "
				+ this.persistentClass.getSimpleName()
				+ " e where ( :columna = :str)");
		consulta.setParameter("str", str);
		consulta.setParameter("columna", columna);
		resultado = (List<T>) consulta.getResultList();
		em.close();

		return resultado;
	}

	public T getById(Long id) {
		EntityManager em = EMF.getEMF().createEntityManager();
		return em.find(persistentClass, id);
	}

	public List<T> getActives(String columnOrder) {
		List<T> resultado = null;

		EntityManager em = EMF.getEMF().createEntityManager();
		Query consulta = em.createQuery("select e from "
				+ this.persistentClass.getSimpleName()
				+ " e where (baja = false) order by e. " + columnOrder);
		resultado = (List<T>) consulta.getResultList();
		em.close();

		return resultado;
	}

	public List<T> getAll(String columnOrder) {
		List<T> resultado = null;

		EntityManager em = EMF.getEMF().createEntityManager();
		Query consulta = em.createQuery("select e from "
				+ this.persistentClass.getSimpleName() + " e order by e. "
				+ columnOrder);
		resultado = (List<T>) consulta.getResultList();
		em.close();

		return resultado;
	}

	public List<T> getInactives(String columnOrder) {
		List<T> resultado = null;

		EntityManager em = EMF.getEMF().createEntityManager();
		Query consulta = em.createQuery("select e from "
				+ this.persistentClass.getSimpleName()
				+ " e where (baja = true) order by e. " + columnOrder);
		resultado = (List<T>) consulta.getResultList();
		em.close();

		return resultado;
	}

	public boolean exists(Long id) {

		return getById(id) != null;

	}

}
