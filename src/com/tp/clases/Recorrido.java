package com.tp.clases;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Recorrido implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8127674514761329332L;
	@Id @GeneratedValue
	private Long id;
	private String origen;
	private String destino;
	private Date fechaPublicacion;
	private boolean estado;
	private Integer asientos;
	private boolean baja;
	
	@OneToOne
	private Usuario owner;
	
	@OneToMany(fetch=FetchType.EAGER)
	private List<Usuario> participantes;
	
	@OneToOne
	private EventoAcademico evento;
	
	@OneToOne(cascade = CascadeType.ALL) 
	private Viaje viaje;
		
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getOrigen() {
		return origen;
	}
	
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	
	public String getDestino() {
		return destino;
	}
	
	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	public boolean isEstado() {
		return estado;
	}
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public Integer getAsientos() {
		return asientos;
	}
	
	public void setAsientos(Integer asientos) {
		this.asientos = asientos;
	}
	
	public Usuario getOwner() {
		return owner;
	}
	
	public void setOwner(Usuario owner) {
		this.owner = owner;
	}
	
	public List<Usuario> getParticipantes() {
		return participantes;
	}
	
	public void setParticipantes(List<Usuario> participantes) {
		this.participantes = participantes;
	}
	
	public EventoAcademico getEvento() {
		return evento;
	}
	
	public void setEvento(EventoAcademico evento) {
		this.evento = evento;
	}

	public Viaje getViaje() {
		return viaje;
	}
	
	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public boolean getBaja() {
		return baja;
	}

	public void setBaja(boolean baja) {
		this.baja = baja;
	}
	
	
	
}
