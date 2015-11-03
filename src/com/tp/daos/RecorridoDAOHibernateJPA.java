package com.tp.daos;







import org.springframework.stereotype.Repository;

import com.tp.clases.Recorrido;


@Repository
public class RecorridoDAOHibernateJPA extends GenericDAOHibernateJPA<Recorrido>
		implements RecorridoDAO {

	public RecorridoDAOHibernateJPA() {
		super(Recorrido.class);

	}
	
	

	
	
	

}
