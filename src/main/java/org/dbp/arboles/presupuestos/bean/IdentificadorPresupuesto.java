package org.dbp.arboles.presupuestos.bean;

import java.io.Serializable;
/**
 * 
 * Esta clase el el identificador de una partida presupuestaria.
 * 		
 * 		- En este caso, guardaremos el tipo de dimension, el iddimension (Para saber a que entidadas esta asociada).
 *      - El id unico
 * 
 * @author david
 *
 */
public class IdentificadorPresupuesto implements Serializable {

	private Long tipoDimension;		// El tipo de dimension en cuestión.
	private String idDimension;		// El id de la dimension en cuestión.
	private String id;				// El id unico.
	public Long getTipoDimension() {
		return tipoDimension;
	}
	public void setTipoDimension(Long tipoDimension) {
		this.tipoDimension = tipoDimension;
	}
	public String getIdDimension() {
		return idDimension;
	}
	public void setIdDimension(String idDimension) {
		this.idDimension = idDimension;
	}
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((idDimension == null) ? 0 : idDimension.hashCode());
		result = prime * result
				+ ((tipoDimension == null) ? 0 : tipoDimension.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdentificadorPresupuesto other = (IdentificadorPresupuesto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idDimension == null) {
			if (other.idDimension != null)
				return false;
		} else if (!idDimension.equals(other.idDimension))
			return false;
		if (tipoDimension == null) {
			if (other.tipoDimension != null)
				return false;
		} else if (!tipoDimension.equals(other.tipoDimension))
			return false;
		return true;
	}

	
	public boolean equals2(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdentificadorPresupuesto other = (IdentificadorPresupuesto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idDimension == null) {
			if (other.idDimension != null)
				return false;
		} else if (!idDimension.equals(other.idDimension))
			return false;
		if (tipoDimension == null) {
			if (other.tipoDimension != null)
				return false;
		} else if (!tipoDimension.equals(other.tipoDimension))
			return false;
		return true;
	}
}
