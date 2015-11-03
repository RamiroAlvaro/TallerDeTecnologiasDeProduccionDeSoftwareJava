package com.tp.actions;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tp.clases.EventoAcademico;
import com.tp.clases.Recorrido;
import com.tp.clases.Usuario;
import com.tp.clases.ViajeDiario;
import com.tp.clases.ViajePeriodico;
import com.tp.clases.ViajePuntual;
import com.tp.daos.EventoAcademicoDAO;
import com.tp.daos.RecorridoDAO;

@Controller
@Scope("prototype")
public class NuevoRecorridoAction extends ActionSupport implements
		ModelDriven<Recorrido> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5213784041472196845L;

	private Recorrido recorrido = new Recorrido();
	private String eventoId = "";
	private EventoAcademico evento = new EventoAcademico();
	private ViajeDiario viajeDiario = new ViajeDiario();
	private ViajePeriodico viajePeriodico = new ViajePeriodico();
	private ViajePuntual viajePuntual = new ViajePuntual();
	private List<Recorrido> listadoRecorridos = new ArrayList<Recorrido>();
	private List<EventoAcademico> listadoEventos = new ArrayList<EventoAcademico>();
	@Autowired
	private RecorridoDAO recorridoDAO;

	@Autowired
	private EventoAcademicoDAO eventoDAO;

/**
 * Este m�todo es invocado desde menu.jsp para que cargue los valores de los listados (eventos)
 * */
	@Action(value = "prepareNuevoRecorrido", results = { @Result(name = "success", location = "/nuevoRecorrido.jsp") })
	public String prepareNuevoRecorrido() throws Exception {
		this.listadoEventos = (ArrayList<EventoAcademico>) eventoDAO
				.getActives("id");
		EventoAcademico eventoAux = new EventoAcademico();
		eventoAux.setNombre("Sin evento");
		listadoEventos.add(0,eventoAux);
		return SUCCESS;

	}

	/** s�lo me quedo con el ID del evento seleccionado*/
	public String getEventoId() {
		return eventoId;
	}

	public void setEventoId(String eventoId) {
		this.eventoId = eventoId;
	}

	public List<EventoAcademico> getListadoEventos() {
		return listadoEventos;
	}

	public void setListadoEventos(List<EventoAcademico> listadoEventos) {
		this.listadoEventos = listadoEventos;
	}

	@Override
	public Recorrido getModel() {
		// TODO Auto-generated method stub
		return recorrido;
	}

	@Action(value = "altaRecorrido", results = {
			@Result(name = "success", location = "/inicio.jsp"),
			@Result(name = "input", location = "/nuevoRecorrido.jsp") })
	public String altaRecorrido() throws Exception {

		if (((Boolean) (ActionContext.getContext().getSession().get("tipo"))) == false) {

			String tipo_periodicidad = String.valueOf(ServletActionContext
					.getRequest().getParameter("tipo_recorrido"));
			// Integer asoc_evento =
			// Integer.valueOf(ServletActionContext.getRequest().getParameter("evento"));

			/*cargo el evento segun el ID seleccionado*/
			if (eventoId != null && eventoId.length() > 0) {
				evento = eventoDAO.getById(Long.valueOf(eventoId));
				recorrido.setEvento(evento);
			}

			if (tipo_periodicidad.equals("Viaje_diario")) {

				ArrayList<String> dias = new ArrayList<String>();
				dias.add("Lunes");
				dias.add("Martes");
				dias.add("Miercoles");
				dias.add("Jueves");
				dias.add("Viernes");
				viajeDiario.setDias(dias);
				recorrido.setViaje(viajeDiario);

			}

			if (tipo_periodicidad.equals("Viaje_periodico")) {
				recorrido.setViaje(viajePeriodico);
			}

			if (tipo_periodicidad.equals("Viaje_puntual")) {
				recorrido.setViaje(viajePuntual);
			}

			Date dateRecorrido = new Date(new java.util.Date().getTime());
			recorrido.setFechaPublicacion(dateRecorrido);
			recorrido.setOwner((Usuario) (ActionContext.getContext()
					.getSession().get("usrLogin")));
			recorridoDAO.alta(recorrido);
			return SUCCESS;
		} else {
			return "input";
		}

	}

	@Action(value = "listarRecorridos", results = {
			@Result(name = "success", location = "/recorridosDisponibles.jsp"),
			@Result(name = "input", location = "/recorridosDisponibles.jsp") })
	public String listarRecorridos() {
		try {
			setListadoRecorridos((ArrayList<Recorrido>) recorridoDAO
					.getActives("id"));
			List<Recorrido> blacklist = new ArrayList<Recorrido>();
			for (Recorrido r : listadoRecorridos) {

				if (((r.getAsientos()) == 0)
						|| r.getOwner()
								.getEmail()
								.equals((ActionContext.getContext()
										.getSession().get("usuario")))) {
					blacklist.add(r);
				}

			}
			listadoRecorridos.removeAll(blacklist);

		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
		return SUCCESS;
	}

	public void validateAltaRecorrido() {

		if (recorrido.getOrigen().isEmpty()) {
			addFieldError("origen",
					"Por favor ingrese un origen para el recorrido");
		}

		if (recorrido.getDestino().isEmpty()) {
			addFieldError("destino",
					"Por favor ingrese un destino para el recorrido");
		}

		if (recorrido.getAsientos() == null) {
			addFieldError("asientos",
					"Por favor ingrese la cantidad de asientos disponibles para el recorrido");

		}

		Usuario usuario = (Usuario) (ActionContext.getContext().getSession()
				.get("usrLogin"));
		if ((usuario == null) || (usuario.isAdministrador())) {
			addFieldError("permisos",
					"No posee permisos para realizar la operación");
		}

		try {
			prepareNuevoRecorrido();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// if(recorrido.getViaje() == null){
		// addFieldError("viaje",
		// "Por favor ingrese el tipo de viaje asociado al recorrido");
		// }

	}

	public void validateListarRecorridos() {
		Usuario usuario = (Usuario) (ActionContext.getContext().getSession()
				.get("usrLogin"));
		if ((usuario == null) || (usuario.isAdministrador())) {
			addFieldError("permisos",
					"No posee permisos para realizar la operación");
		}

	}

	public Recorrido getRecorrido() {
		return recorrido;
	}

	public void setRecorrido(Recorrido recorrido) {
		this.recorrido = recorrido;
	}

	public EventoAcademico getEvento() {
		return evento;
	}

	public void setEvento(EventoAcademico evento) {
		this.evento = evento;
	}

	public ViajeDiario getViajeDiario() {
		return viajeDiario;
	}

	public void setViajeDiario(ViajeDiario viajeDiario) {
		this.viajeDiario = viajeDiario;
	}

	public ViajePeriodico getViajePeriodico() {
		return viajePeriodico;
	}

	public void setViajePeriodico(ViajePeriodico viajePeriodico) {
		this.viajePeriodico = viajePeriodico;
	}

	public ViajePuntual getViajePuntual() {
		return viajePuntual;
	}

	public void setViajePuntual(ViajePuntual viajePuntual) {
		this.viajePuntual = viajePuntual;
	}

	public RecorridoDAO getRecorridoDAO() {
		return recorridoDAO;
	}

	public void setRecorridoDAO(RecorridoDAO recorridoDAO) {
		this.recorridoDAO = recorridoDAO;
	}

	public List<Recorrido> getListadoRecorridos() {
		return listadoRecorridos;
	}

	public void setListadoRecorridos(List<Recorrido> listadoRecorridos) {
		this.listadoRecorridos = listadoRecorridos;
	}

	public EventoAcademicoDAO getEventoDAO() {
		return eventoDAO;
	}

	public void setEventoDAO(EventoAcademicoDAO eventoDAO) {
		this.eventoDAO = eventoDAO;
	}

}
