package org.dbp.arboles;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.dbp.arboles.bean.NodoArbolGenericBean;
/**
 * 
 * Se encarga de la gestion de la ulilidades, 
 * 
 * @author david
 *
 * @param <T>
 */
public  class ArbolesPathUtils <E extends NodoArbolGenericBean<ID>,ID extends Serializable>{
	/**
	 * 
	 * Este interfaz la usaremos para crear un nodo nuevo si es necesario, por el sistema de lambadas
	 * 
	 * @author david
	 *
	 * @param <E>
	 * @param <ID>
	 */
	public interface InicializarNodo<E extends NodoArbolGenericBean<ID>,ID extends Serializable> {
		E  crear(E nodo);   
	}
	/**
	 * 
	 * Nos mira si las dimensiones son iguales, es para la buscada por dimensiones en el arbol.
	 * 
	 * @author david
	 *
	 * @param <ID>
	 */
	public interface EqualsDimension<ID extends Serializable> {
		Boolean equals(ID origen,ID destino);
	}
	
	
	/**
	 * 
	 * Se encarga de inicializar los valres de la raiz de un arbol
	 * 
	 * @param arbol	El nodo con los valores de negocio del arbol.
	 * @param id	El id que nos identifica como unicos.
	 * @return
	 */
	public E crearRaiz(E arbol,ID id){
		arbol.setFilas(new ArrayList<E>());
		arbol.setPadre(null);
		arbol.setId(id);
		return arbol;
	}
	
	public E buscarNodo(E padre, List<ID> ids,E valoresIniciales,InicializarNodo<E,ID> inicializar,EqualsDimension<ID> equalsDimension) throws InstantiationException, IllegalAccessException{
		if(padre!=null){
			ID id =ids.remove(0);
			E descendiente=buscarDescendiente(padre,id,equalsDimension);
			if(descendiente==null){
				valoresIniciales.setId(id);
				descendiente=inicializar.crear(valoresIniciales);
				descendiente.setPadre(padre);
				descendiente.setFilas(new ArrayList<E>());
				padre.getFilas().add(descendiente);

			}
			if(ids.isEmpty()){
				return descendiente;
			}else{
				return buscarNodo(descendiente,ids,valoresIniciales,inicializar,equalsDimension);
			}
		}
		return null;
	}
	/**
	 * 
	 * Buscamos entre los descendientes un que tenga la ID que le hemos pasado.
	 * 
	 * @param padre	El padre con el que trabajamos.
	 * @param id	El id que estamos buscando.
	 * @return
	 */
	private E buscarDescendiente(E padre,ID id,EqualsDimension<ID> equalsDimension){
		if(!padre.getFilas().isEmpty()){
			for(E hijo:(List<E>)padre.getFilas()){
				if(equalsDimension.equals(hijo.getId(), id)){
					return hijo;
				}
			}
		}
		return null;
	}
		
	
}
