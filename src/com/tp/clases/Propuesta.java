package com.tp.clases;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Propuesta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8280477146290895428L;
	
	@Id @GeneratedValue
	private Long id;
	private String mensaje;
	private boolean aprobada;
	private boolean baja;
	private boolean visto;
	
	@OneToOne
	private Usuario viajero;
	
	@OneToOne
	private Recorrido recorrido;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public boolean getAprobada() {
		return aprobada;
	}
	public void setAprobada(boolean aprobada) {
		this.aprobada = aprobada;
	}
	public boolean getBaja() {
		return baja;
	}
	public void setBaja(boolean baja) {
		this.baja = baja;
	}
	public boolean getVisto() {
		return visto;
	}
	public void setVisto(boolean visto) {
		this.visto = visto;
	}
	public Usuario getViajero() {
		return viajero;
	}
	public void setViajero(Usuario viajero) {
		this.viajero = viajero;
	}
	public Recorrido getRecorrido() {
		return recorrido;
	}
	public void setRecorrido(Recorrido recorrido) {
		this.recorrido = recorrido;
	}
	
	
	
}
