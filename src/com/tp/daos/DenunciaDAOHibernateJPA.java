package com.tp.daos;

import org.springframework.stereotype.Repository;

import com.tp.clases.Denuncia;

@Repository
public class DenunciaDAOHibernateJPA extends GenericDAOHibernateJPA<Denuncia>
		implements DenunciaDAO {

	public DenunciaDAOHibernateJPA() {
		super(Denuncia.class);
		
	}

}
