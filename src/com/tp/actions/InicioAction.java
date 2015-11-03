package com.tp.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

@Action(value="inicio")
@Result(name="success", location="/inicio.jsp")
public class InicioAction {
	public String execute() {
		return "success";
	}
}
