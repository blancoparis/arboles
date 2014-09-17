package org.dbp.arboles.bean;

import java.io.Serializable;
import java.util.List;
/**
 * 
 * Representa el nodo de un arbol de manera generica.
 * 
 * @author david
 *
 * @param <ID>	Es el identificador que hemos utilizado.
 * @param <D>	Donde guardamos los datos.
 */
public class NodoArbolGenericBean <ID extends Serializable> implements Serializable {

	private ID id;

	private List<NodoArbolGenericBean<ID>> filas;
	
	private NodoArbolGenericBean<ID> padre;

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public List getFilas() {
		return filas;
	}

	public void setFilas(List filas) {
		this.filas = filas;
	}

	public NodoArbolGenericBean<ID> getPadre() {
		return padre;
	}

	public void setPadre(NodoArbolGenericBean<ID> padre) {
		this.padre = padre;
	}
	
	
	
	
}
