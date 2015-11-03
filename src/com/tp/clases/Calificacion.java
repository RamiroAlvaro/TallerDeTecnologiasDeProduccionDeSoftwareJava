package com.tp.clases;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Calificacion implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3262143319344023003L;
	@Id @GeneratedValue
	private Long id;
	
	@OneToOne
	private Recorrido recorrido;
	
	private boolean calificacion;
	
	@OneToOne
	private Usuario calificado;
	
	@OneToOne
	private Usuario calificante;
	
	private boolean baja;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Recorrido getRecorrido() {
		return recorrido;
	}
	public void setRecorrido(Recorrido recorrido) {
		this.recorrido = recorrido;
	}
	public boolean isCalificacion() {
		return calificacion;
	}
	public void setCalificacion(boolean calificacion) {
		this.calificacion = calificacion;
	}
	public Usuario getCalificado() {
		return calificado;
	}
	public void setCalificado(Usuario calificado) {
		this.calificado = calificado;
	}
	public Usuario getCalificante() {
		return calificante;
	}
	public void setCalificante(Usuario calificante) {
		this.calificante = calificante;
	}
	public boolean getBaja() {
		return baja;
	}
	public void setBaja(boolean baja) {
		this.baja = baja;
	}
	
	
	
}
