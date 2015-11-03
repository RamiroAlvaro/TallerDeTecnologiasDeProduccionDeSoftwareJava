package com.tp.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tp.clases.Usuario;
import com.tp.daos.UsuarioDAO;


@Controller
@Scope("prototype")
public class RegistracionAction extends ActionSupport implements
		ModelDriven<Usuario> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5176791573900969658L;
	
	
	private Usuario viajero = new Usuario();
	
	@Autowired
	private UsuarioDAO viajeroDAO;

	

	@Override
	public Usuario getModel() {
		// TODO Auto-generated method stub
		return viajero;
	}
	
	@Action(value = "registracion",results={ @Result(name = "success", location = "/login.jsp"),
			@Result(name = "input", location = "/registracion.jsp")})
     public String execute() throws Exception {
		if ((viajeroDAO.recuperacionGenerica(viajero.getEmail(), "email")).size() == 0){

			viajeroDAO.alta(viajero);
			return SUCCESS;
		} else {
			return "input";
		}

	}

	public void validate() {
		
		if (viajero.getNombre().isEmpty()) {
			addFieldError("Nombre", "Se requiere un nombre");
		}
		
		if (viajero.getApellido().isEmpty()) {
			addFieldError("Apellido", "Se requiere un apellido");
		}
		
		if (viajero.getTelefono().isEmpty()) {
			addFieldError("Telefono", "Se requiere un telefono");
		}
		
		if (viajero.getEmail().isEmpty()) {
			addFieldError("email", "Se requiere un email");
		}
		if (viajero.getClave().isEmpty()) {
			addFieldError("Clave", "Se requiere una clave");
		}

		
		if (viajero.getFoto() == null) {
			addFieldError("Foto", "Se requiere una foto");
		}
		
		

	}
	
	public Usuario getViajero() {
		return viajero;
	}

	public void setViajero(Usuario viajero) {
		this.viajero = viajero;
	}

	public UsuarioDAO getViajeroDAO() {
		return viajeroDAO;
	}

	public void setViajeroDAO(UsuarioDAO viajeroDAO) {
		this.viajeroDAO = viajeroDAO;
	}
}
