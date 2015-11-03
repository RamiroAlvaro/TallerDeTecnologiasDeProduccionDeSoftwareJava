package com.tp.daos;

import org.springframework.stereotype.Repository;

import com.tp.clases.EventoAcademico;

@Repository
public class EventoAcademicoDAOHibernateJPA extends
		GenericDAOHibernateJPA<EventoAcademico> implements EventoAcademicoDAO {

	public EventoAcademicoDAOHibernateJPA() {
		super(EventoAcademico.class);
		
	}
	
	

}
