package com.tp.daos;



public class DAOFactory {
	
	public static UsuarioDAO getUsuario(){
		return new UsuarioDAOHibernateJPA();
	}
	
	public static ViajeDAO getViaje(){
		return new ViajeDAOHibernateJPA();
	}
	
	
	
	public static CalificacionDAO getCalificacion(){
		return new CalificacionDAOHibernateJPA();
	}
	
	public static DenunciaDAO getDenuncia(){
		return new DenunciaDAOHibernateJPA();
	}
	
	public static EventoAcademicoDAO getEventoAcademico(){
		return new EventoAcademicoDAOHibernateJPA();
	}
	
	public static MensajeDAO getMensaje(){
		return new MensajeDAOHibernateJPA();
	}
	
	public static PropuestaDAO getPropuesta(){
		return new PropuestaDAOHibernateJPA();
	}
	
	public static RecorridoDAO getRecorrido(){
		return new RecorridoDAOHibernateJPA();
	}
	
	public static ViajeDiarioDAO getViajeDiario(){
		return new ViajeDiarioDAOHibernateJPA();
	}
	
	public static ViajePeriodicoDAO getViajePeriodico(){
		return new ViajePeriodicoDAOHibernateJPA();
	}
	
	public static ViajePuntualDAO getViajePuntual(){
		return new ViajePuntualDAOHibernateJPA();
	}
	
	
	
	
	

}
