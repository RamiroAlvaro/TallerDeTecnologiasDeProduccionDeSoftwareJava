package com.tp.actions;



import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tp.clases.Usuario;

import com.tp.daos.UsuarioDAO;

@Controller
@Scope("prototype")
public class LoginAction extends ActionSupport implements
ModelDriven<Usuario>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6705155962751988489L;
	
	private Usuario usuario = new Usuario();
	
	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	public Usuario getModel() {
		// TODO Auto-generated method stub
		return usuario;
	}
	
	@Action(value = "login",results={ @Result(name = "success",location = "/inicio.jsp"),
			@Result(name = "input", location = "/login.jsp"), @Result(name = "conectado", location = "/inicio.jsp")})
	public String execute() throws Exception{
		Map<String, Object> session = ActionContext.getContext().getSession();
		String user = (String)session.get("usuario");
		if (user == null){
			Usuario u = usuarioDAO.obtenerLogin(usuario.getEmail(),  usuario.getClave());
			if (u != null){
				session.put("usuario", u.getEmail());
				session.put("nombre", u.getNombre());
				session.put("apellido", u.getApellido());
				session.put("usrLogin", u);
				session.put("tipo", u.isAdministrador());

				
				return SUCCESS;
			} else {
				addFieldError("usuario", "Datos Incorrectos");
				return INPUT;
			}
		} else {
		return "conectado";
		}
	}
	
	public void validateExecute(){
		if (usuario.getEmail().isEmpty())
			addFieldError("email", "Se requiere una identificación de usuario");
		if (usuario.getClave().isEmpty())
			addFieldError("clave","Se requiere una contraseña");
	}
	
	@Action(value = "logout",results={ @Result(name = "success",location = "/index.jsp"),
			@Result(name = "input", location = "/login.jsp")})
	public String logout() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		String user = (String)session.get("usuario");
		if (user != null){
			
			session.remove("usuario");
	        session.remove("usrLogin");
	        session.remove("nombre");
	        session.remove("apellido");
	        session.remove("tipo");
			return SUCCESS;
		}
		 return INPUT;
	} 
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}


}
