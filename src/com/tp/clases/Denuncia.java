package com.tp.clases;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Denuncia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -368369664715355873L;
	@Id @GeneratedValue
	private Long id;
	
	@OneToOne
	private Usuario denunciante;
	
	@OneToOne
	private Usuario denunciado;
	
	@OneToOne
	private Recorrido recorrido;
	private String texto;
	private boolean leida;
	
	private boolean baja;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Usuario getDenunciante() {
		return denunciante;
	}
	
	public void setDenunciante(Usuario denunciante) {
		this.denunciante = denunciante;
	}
	
	public Usuario getDenunciado() {
		return denunciado;
	}
	
	public void setDenunciado(Usuario denunciado) {
		this.denunciado = denunciado;
	}
	
	public Recorrido getRecorrido() {
		return recorrido;
	}
	
	public void setRecorrido(Recorrido recorrido) {
		this.recorrido = recorrido;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public boolean isLeida() {
		return leida;
	}
	
	public void setLeida(boolean leida) {
		this.leida = leida;
	}

	public boolean getBaja() {
		return baja;
	}

	public void setBaja(boolean baja) {
		this.baja = baja;
	}
	
	
	
	
}
