package com.tp.clases;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class ViajePuntual extends Viaje implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6332677226161679493L;
	
	private Date fecha;

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	
}
