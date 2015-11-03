package com.tp.daos;

import org.springframework.stereotype.Repository;

import com.tp.clases.Viaje;

@Repository
public class ViajeDAOHibernateJPA extends GenericDAOHibernateJPA<Viaje>
		implements ViajeDAO {

	public ViajeDAOHibernateJPA() {
		super(Viaje.class);
		// TODO Auto-generated constructor stub
	}

}
