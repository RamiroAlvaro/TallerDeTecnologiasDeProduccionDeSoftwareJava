package com.tp.daos;

import com.tp.clases.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario> {

	public Usuario obtenerLogin(String usuario, String password);
} 
