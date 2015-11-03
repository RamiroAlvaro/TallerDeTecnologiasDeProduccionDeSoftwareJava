package com.tp.daos;

import org.springframework.stereotype.Repository;

import com.tp.clases.Calificacion;

@Repository
public class CalificacionDAOHibernateJPA extends
		GenericDAOHibernateJPA<Calificacion> implements CalificacionDAO {

	public CalificacionDAOHibernateJPA() {
		super(Calificacion.class);

	}

}
