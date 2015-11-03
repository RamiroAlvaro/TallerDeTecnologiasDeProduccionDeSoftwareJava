package com.tp.clases;

import java.io.Serializable;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;

@Entity
public class ViajePeriodico extends Viaje implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 676812232090930577L;
	
	@ElementCollection
	private List<String> dias;

	public List<String> getDias() {
		return dias;
	}

	public void setDias(List<String> dias) {
		this.dias = dias;
	}
	
}	
	

