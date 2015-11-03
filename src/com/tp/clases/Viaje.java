package com.tp.clases;

import java.io.Serializable;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity

public abstract class Viaje implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7184773015202678425L;
	@Id @GeneratedValue
	private Long id;
	private String horaDePartida;
	private String horaDeRegreso;
	private boolean baja;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHoraDePartida() {
		return horaDePartida;
	}
	public void setHoraDePartida(String horaDePartida) {
		this.horaDePartida = horaDePartida;
	}
	public String getHoraDeRegreso() {
		return horaDeRegreso;
	}
	public void setHoraDeRegreso(String horaDeRegreso) {
		this.horaDeRegreso = horaDeRegreso;
	}
	public boolean getBaja() {
		return baja;
	}
	public void setBaja(boolean baja) {
		this.baja = baja;
	}
	
	
	
}
