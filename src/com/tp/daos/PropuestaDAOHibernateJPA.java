package com.tp.daos;

import org.springframework.stereotype.Repository;

import com.tp.clases.Propuesta;

@Repository
public class PropuestaDAOHibernateJPA extends GenericDAOHibernateJPA<Propuesta>
		implements PropuestaDAO {

	public PropuestaDAOHibernateJPA() {
		super(Propuesta.class);
		
	}

}
