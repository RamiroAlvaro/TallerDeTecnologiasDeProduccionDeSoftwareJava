package com.tp.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tp.aspect.MailMail;
import com.tp.clases.Denuncia;
import com.tp.clases.Usuario;
import com.tp.daos.DenunciaDAO;

@Controller
@Scope("prototype")
public class DenunciaAction extends ActionSupport implements
ModelDriven<Denuncia>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2980251382733717751L;
	private Denuncia denuncia = new Denuncia();
	
	
	
	@Autowired
	private DenunciaDAO denunciaDAO;
	

	@Override
	public Denuncia getModel() {
		// TODO Auto-generated method stub
		return denuncia;
	}
	
	@Action(value = "denunciar",results={ @Result(name = "success", location = "/inicio.jsp"),
			@Result(name = "input", location = "/denuncia.jsp")})
     public String execute() throws Exception {
		if (((Boolean)(ActionContext.getContext().getSession().get("tipo"))) == false){

			denuncia.setDenunciante((Usuario)(ActionContext.getContext().getSession().get("usrLogin")));
			
			
			    ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
		 
		    	MailMail mm = (MailMail) context.getBean("mailMail");
		        mm.sendMail("infopool.ttps@gmail.com",
		    		   "rmflorencia@gmail.com",
		    		   "Denuncia de " + (String)(ActionContext.getContext().getSession().get("usuario")), 
		    		    denuncia.getTexto());
            
		        denunciaDAO.alta(denuncia);
			return SUCCESS;
		} else {
			return "input";
		}

	}
	
	public void validate(){
		Usuario usuario = (Usuario)(ActionContext.getContext().getSession().get("usrLogin"));
		if ((usuario == null) || (usuario.isAdministrador())){
			addFieldError("permisos","No posee permisos para realizar la operación");
		}
		
		if (denuncia.getTexto().isEmpty()) {
			addFieldError("texto",
					"Por favor ingrese un texto de denuncia");
		}
		
	}


	public Denuncia getDenuncia() {
		return denuncia;
	}


	public void setDenuncia(Denuncia denuncia) {
		this.denuncia = denuncia;
	}


	public DenunciaDAO getDenunciaDAO() {
		return denunciaDAO;
	}


	public void setDenunciaDAO(DenunciaDAO denunciaDAO) {
		this.denunciaDAO = denunciaDAO;
	}
	
	

}
