package com.tp.actions;



import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tp.clases.EventoAcademico;
import com.tp.daos.EventoAcademicoDAO;

@Controller
@Scope("prototype")
public class EventoAcademicoAction extends ActionSupport implements
		ModelDriven<EventoAcademico> {

	@Override
	public EventoAcademico getModel() {
		return evento;
	}

	private static final long serialVersionUID = 5176791573900969658L;
	private EventoAcademico evento = new EventoAcademico();
	private List<EventoAcademico> listadoEventos = new ArrayList<EventoAcademico>();
	
	@Autowired
	private EventoAcademicoDAO eventoDAO;


	@Action(value = "altaEvento", results = {
			@Result(name = "success", type = "redirect",location = "listarEventos"),
			@Result(name = "input", location = "/nuevoEvento.jsp") })
	public String altaEvento() throws Exception {
		
	    
		if (eventoDAO.recuperacionGenerica(evento.getNombre(), "nombre").size() == 0) {
			eventoDAO.alta(evento);
			return SUCCESS;
		} else {
			return INPUT;
		}
	}
	
	@Action(value = "listarEventos", results = {
			@Result(name = "success", location = "/eventosAcademicos.jsp"),
			@Result(name = "input", location = "/nuevoEvento.jsp") })
	public String listarEventos() {
		try {
			setListadoEventos((ArrayList<EventoAcademico>) eventoDAO.getActives("id"));
			ServletActionContext.getRequest().setAttribute("listadoEventos", getListadoEventos());
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
		return SUCCESS;
	}



	public List<EventoAcademico> getListadoEventos() {
		return listadoEventos;
	}

	public void setListadoEventos(List<EventoAcademico> listadoEventos) {
		this.listadoEventos = listadoEventos;
	}

	public void validateAltaEvento() {
		if (evento.getNombre().isEmpty()) {
			addFieldError("nombre",
					"Por favor ingrese un nombre para el evento");
		}

		if (evento.getLocalidad().isEmpty()) {
			addFieldError("localidad",
					"Por favor ingrese una localidad para el evento");
		}

		if (evento.getDireccion().isEmpty()) {
			addFieldError("direccion",
					"Por favor ingrese una direccion para el evento");
		}

		if (evento.getFecha() == null) {
			addFieldError("fecha", "Por favor ingrese una fecha para el evento");
		}

		if (evento.getDescripcion().isEmpty()) {
			addFieldError("descripcion",
					"Por favor ingrese una descripcion para el evento");
		}

	}

	public EventoAcademico getEvento() {
		return evento;
	}

	public void setEvento(EventoAcademico evento) {
		this.evento = evento;
	}

	public EventoAcademicoDAO getEventoDAO() {
		return eventoDAO;
	}

	public void setEventoDAO(EventoAcademicoDAO eventoDAO) {
		this.eventoDAO = eventoDAO;
	}



}
