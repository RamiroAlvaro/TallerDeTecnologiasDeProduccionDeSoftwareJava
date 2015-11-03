package com.tp.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tp.clases.Propuesta;
import com.tp.clases.Recorrido;
import com.tp.clases.Usuario;
import com.tp.daos.PropuestaDAO;
import com.tp.daos.RecorridoDAO;


@Controller
@Scope("prototype")
public class PropuestaAction extends ActionSupport implements
ModelDriven<Propuesta>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3046409516687534521L;
	private Propuesta propuesta = new Propuesta();
	private List<Propuesta> listadoPropuestas = new ArrayList<Propuesta>();
	
	@Autowired
	private PropuestaDAO propuestaDAO;
	
	@Autowired
	private RecorridoDAO recorridoDAO;

	@Override
	public Propuesta getModel() {
		// TODO Auto-generated method stub
		return propuesta;
	}
	
	
	@Action(value = "participar",results={ @Result(name = "success", location = "/inicio.jsp"),
			@Result(name = "input", location = "/propuesta.jsp")})
     public String participar() throws Exception {
		
		if (((Boolean)(ActionContext.getContext().getSession().get("tipo"))) == false){
		
			propuesta.setViajero((Usuario)(ActionContext.getContext().getSession().get("usrLogin")));
			HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
			Recorrido recorrido = recorridoDAO.getById(Long.valueOf(request.getParameter("recorrido_id")));
			propuesta.setRecorrido(recorrido);
            propuestaDAO.alta(propuesta);
			return SUCCESS;
		} else {
			return "input";
		}

	}
	
	@Action(value = "aceptarPropuesta",results={ @Result(name = "success", location = "/inicio.jsp"),
			@Result(name = "input", location = "/propuesta.jsp")})
     public String aceptarPropuesta() throws Exception {
		
		if (((Boolean)(ActionContext.getContext().getSession().get("tipo"))) == false){
			HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		    propuesta = propuestaDAO.getById(Long.valueOf(request.getParameter("propuesta_id")));
		    propuesta.setVisto(true);
		    propuesta.setAprobada(true);
		    propuesta.setMensaje("Su propuesta al recorrido fue aceptada");
		    propuesta.getRecorrido().getParticipantes().add(propuesta.getViajero());
	        propuesta.getRecorrido().setAsientos((propuesta.getRecorrido().getAsientos())-1);
	        recorridoDAO.modificacion(propuesta.getRecorrido());
	        propuestaDAO.modificacion(propuesta);
			return SUCCESS;
		} else {
			return "input";
		}

	}
	
	@Action(value = "rechazarPropuesta",results={ @Result(name = "success", location = "/inicio.jsp"),
			@Result(name = "input", location = "/propuesta.jsp")})
     public String rechazarPropuesta() throws Exception {
		
		if (((Boolean)(ActionContext.getContext().getSession().get("tipo"))) == false){
			HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		    propuesta = propuestaDAO.getById(Long.valueOf(request.getParameter("propuesta_id")));
		    propuesta.setVisto(true);
		    propuesta.setAprobada(false);
		    propuesta.setMensaje("Su propuesta al recorrido fue rechazada");
		    propuestaDAO.modificacion(propuesta);
	
			return SUCCESS;
		} else {
			return "input";
		}

	}
	
	@Action(value = "listarPropuestas", results = {
			@Result(name = "success", location = "/propuestas.jsp"),
			@Result(name = "input", location = "/propuestas.jsp") })
	public String listarPropuestas() {
		try {
			setListadoPropuestas((ArrayList<Propuesta>) propuestaDAO.getActives("id"));
			List<Propuesta> blacklist = new ArrayList <Propuesta>();
        for (Propuesta p: listadoPropuestas){
				
			    if(((p.getVisto()) == true) || !(p.getRecorrido().getOwner().getEmail().equals((ActionContext.getContext().getSession().get("usuario"))))){
					blacklist.add(p);
				}
				
			}
			listadoPropuestas.removeAll(blacklist);
			
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
		return SUCCESS;
	}
	
	
	@Action(value = "listarRespuestas", results = {
			@Result(name = "success", location = "/respuestaPropuestas.jsp"),
			@Result(name = "input", location = "/respuestaPropuestas.jsp") })
	public String listarRespuestas() {
		try {
			setListadoPropuestas((ArrayList<Propuesta>) propuestaDAO.getActives("id"));
			List<Propuesta> blacklist = new ArrayList <Propuesta>();
        for (Propuesta p: listadoPropuestas){
				
			    if(((p.getVisto()) == false) || !(p.getViajero().getEmail().equals((ActionContext.getContext().getSession().get("usuario"))))){
					blacklist.add(p);
				}
				
			}
			listadoPropuestas.removeAll(blacklist);
			
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
		return SUCCESS;
	}
	
	
	
	public void validate(){
		Usuario usuario = (Usuario)(ActionContext.getContext().getSession().get("usrLogin"));
		if ((usuario == null) || (usuario.isAdministrador())){
			addFieldError("permisos","No posee permisos para realizar la operación");
		}
		
	}
	
	

	public Propuesta getPropuesta() {
		return propuesta;
	}

	public void setPropuesta(Propuesta propuesta) {
		this.propuesta = propuesta;
	}

	public PropuestaDAO getPropuestaDAO() {
		return propuestaDAO;
	}

	public void setPropuestaDAO(PropuestaDAO propuestaDAO) {
		this.propuestaDAO = propuestaDAO;
	}


	public List<Propuesta> getListadoPropuestas() {
		return listadoPropuestas;
	}


	public void setListadoPropuestas(List<Propuesta> listadoPropuestas) {
		this.listadoPropuestas = listadoPropuestas;
	}


	public RecorridoDAO getRecorridoDAO() {
		return recorridoDAO;
	}


	public void setRecorridoDAO(RecorridoDAO recorridoDAO) {
		this.recorridoDAO = recorridoDAO;
	}
	
	

}
