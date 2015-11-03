package com.tp.clases;

import java.io.Serializable;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;

@Entity
public class ViajeDiario extends Viaje implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 882275170440428905L;
	
	
	@ElementCollection
	private List<String> dias;

	public List<String> getDias() {
		return dias;
	}

	public void setDias(List<String> dias) {
		this.dias = dias;
	}
	
	
	
}
