package com.tp.daos;

import java.util.List;

public interface GenericDAO<T> {
	
	public T alta(T entity);
	public T modificacion(T entity);
	public T baja(Long id);
	public T recuperacion(Long id);
	public List<T> recuperacionGenerica(String str, String columna);
	public T getById(Long id);
	public List<T> getActives(String columnOrder);
	public List<T> getAll(String columnOrder);
	public List<T> getInactives(String columnOrder);
	public boolean exists(Long id);

}
