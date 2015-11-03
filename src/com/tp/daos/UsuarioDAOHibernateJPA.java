package com.tp.daos;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.tp.clases.Usuario;
import com.tp.datasource.EMF;

@Repository
public class UsuarioDAOHibernateJPA extends GenericDAOHibernateJPA<Usuario> implements UsuarioDAO {

	public UsuarioDAOHibernateJPA() {
		super(Usuario.class);
		
	}
	
	public Usuario obtenerLogin(String email, String clave){
		Usuario  resultado = null;
		EntityManager em = EMF.getEMF().createEntityManager();
		Query consulta =  em.createQuery("select u from Usuario u where u.email = :email and u.clave = :clave");
		 consulta.setParameter("email", email);
		 consulta.setParameter("clave", clave);
		 try{
			 resultado = (Usuario) consulta.getSingleResult();
		 }
		 catch(NoResultException e){
			 return null;
		 }
		return resultado;
	}

}
