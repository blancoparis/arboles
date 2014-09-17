package org.dbp.arboles.presupuestos.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.dbp.arboles.bean.NodoArbolGenericBean;
/**
 * 
 *  Este es el nodo que nos sinvolizara una presupuesto en cuestion 
 * 
 * @author david
 *
 */
public class NodoPresupuestosArbolDTO extends NodoArbolGenericBean<IdentificadorPresupuesto> 
implements Serializable {
	
	private BigDecimal ene;
	private BigDecimal feb;
	private BigDecimal mar;
	private BigDecimal abr;
	private BigDecimal may;
	private BigDecimal jun;
	private BigDecimal jul;
	private BigDecimal ago;
	private BigDecimal sep;
	private BigDecimal oct;
	private BigDecimal nov;
	private BigDecimal dic;
	
	private BigDecimal total;

	public BigDecimal getEne() {
		return ene;
	}

	public void setEne(BigDecimal ene) {
		this.ene = ene;
	}

	public BigDecimal getFeb() {
		return feb;
	}

	public void setFeb(BigDecimal feb) {
		this.feb = feb;
	}

	public BigDecimal getMar() {
		return mar;
	}

	public void setMar(BigDecimal mar) {
		this.mar = mar;
	}

	public BigDecimal getAbr() {
		return abr;
	}

	public void setAbr(BigDecimal abr) {
		this.abr = abr;
	}

	public BigDecimal getMay() {
		return may;
	}

	public void setMay(BigDecimal may) {
		this.may = may;
	}

	public BigDecimal getJun() {
		return jun;
	}

	public void setJun(BigDecimal jun) {
		this.jun = jun;
	}

	public BigDecimal getJul() {
		return jul;
	}

	public void setJul(BigDecimal jul) {
		this.jul = jul;
	}

	public BigDecimal getAgo() {
		return ago;
	}

	public void setAgo(BigDecimal ago) {
		this.ago = ago;
	}

	public BigDecimal getSep() {
		return sep;
	}

	public void setSep(BigDecimal sep) {
		this.sep = sep;
	}

	public BigDecimal getOct() {
		return oct;
	}

	public void setOct(BigDecimal oct) {
		this.oct = oct;
	}

	public BigDecimal getNov() {
		return nov;
	}

	public void setNov(BigDecimal nov) {
		this.nov = nov;
	}

	public BigDecimal getDic() {
		return dic;
	}

	public void setDic(BigDecimal dic) {
		this.dic = dic;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}



	
	

	
}
