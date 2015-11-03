package com.tp.clases;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5708191066118118532L;
	@Id @GeneratedValue
	private Long id;
	private String email;
	private String clave;
	private boolean baja;
	private String nombre;
	private String apellido;
	private String telefono;
	private String foto;
	private boolean administrador;
	
	public boolean isAdministrador() {
		return administrador;
	}
	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}
	@OneToMany
	private List<Calificacion> calificacionesOtorgadas;
	
	@OneToMany
	private List<Calificacion> calificacionesRecibidas;
	
	@OneToMany
	private List<Recorrido> recorridosPublicados;
	
	@OneToMany
	private List<Recorrido> recorridosAsociados;	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public List<Calificacion> getCalificacionesOtorgadas() {
		return calificacionesOtorgadas;
	}
	public void setCalificacionesOtorgadas(
			List<Calificacion> calificacionesOtorgadas) {
		this.calificacionesOtorgadas = calificacionesOtorgadas;
	}
	public List<Calificacion> getCalificacionesRecibidas() {
		return calificacionesRecibidas;
	}
	public void setCalificacionesRecibidas(
			List<Calificacion> calificacionesRecibidas) {
		this.calificacionesRecibidas = calificacionesRecibidas;
	}
	public List<Recorrido> getRecorridosPublicados() {
		return recorridosPublicados;
	}
	public void setRecorridosPublicados(List<Recorrido> recorridosPublicados) {
		this.recorridosPublicados = recorridosPublicados;
	}
	public List<Recorrido> getRecorridosAsociados() {
		return recorridosAsociados;
	}
	public void setRecorridosAsociados(List<Recorrido> recorridosAsociados) {
		this.recorridosAsociados = recorridosAsociados;
	}
	@OneToMany
	private List<Mensaje> mensajesEnviados;
	
	@OneToMany
	private List<Mensaje> mensajesRecibidos;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public List<Mensaje> getMensajesEnviados() {
		return mensajesEnviados;
	}
	public void setMensajesEnviados(List<Mensaje> mensajesEnviados) {
		this.mensajesEnviados = mensajesEnviados;
	}
	public List<Mensaje> getMensajesRecibidos() {
		return mensajesRecibidos;
	}
	public void setMensajesRecibidos(List<Mensaje> mensajesRecibidos) {
		this.mensajesRecibidos = mensajesRecibidos;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean getBaja() {
		return baja;
	}
	public void setBaja(boolean baja) {
		this.baja = baja;
	}
	 

	
	
	
}
