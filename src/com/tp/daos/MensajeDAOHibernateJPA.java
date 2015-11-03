package com.tp.daos;

import org.springframework.stereotype.Repository;

import com.tp.clases.Mensaje;

@Repository
public class MensajeDAOHibernateJPA extends GenericDAOHibernateJPA<Mensaje>
		implements MensajeDAO {

	public MensajeDAOHibernateJPA() {
		super(Mensaje.class);
		
	}

}
