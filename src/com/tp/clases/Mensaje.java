package com.tp.clases;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Mensaje implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8993616047773290035L;
	@Id @GeneratedValue
	private Long id;
	private String contenido;
	private Date fecha;
	private Time hora;
	private boolean baja;
	
	@OneToOne
	private Usuario emisor;
	
	@OneToOne
	private Usuario receptor;
	
	@OneToOne
	private Mensaje respuesta;
	private boolean leido;
	
	
	public boolean isLeido() {
		return leido;
	}
	public void setLeido(boolean leido) {
		this.leido = leido;
	}
	public Mensaje getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(Mensaje respuesta) {
		this.respuesta = respuesta;
	}
	public Usuario getEmisor() {
		return emisor;
	}
	public void setEmisor(Usuario emisor) {
		this.emisor = emisor;
	}
	public Usuario getReceptor() {
		return receptor;
	}
	public void setReceptor(Usuario receptor) {
		this.receptor = receptor;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean getBaja() {
		return baja;
	}
	public void setBaja(boolean baja) {
		this.baja = baja;
	}
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
	}
	
	
	
}
