package org.dbp.arboles.mock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.dbp.arboles.ArbolesPathUtils.EqualsDimension;
import org.dbp.arboles.ArbolesPathUtils.InicializarNodo;
import org.dbp.arboles.presupuestos.bean.IdentificadorPresupuesto;
import org.dbp.arboles.presupuestos.bean.NodoPresupuestosArbolDTO;

/**
 * 
 * En el arbol, de los mock, 
 * 
 * @author david
 *
 */
public class ArbolesMock {
	
	public static  InicializarNodo<NodoPresupuestosArbolDTO,IdentificadorPresupuesto> inicializarNodo=	( NodoPresupuestosArbolDTO valoresIniciales) -> {
		NodoPresupuestosArbolDTO nodo=new NodoPresupuestosArbolDTO();
		nodo.setId(valoresIniciales.getId());
		nodo.setEne(valoresIniciales.getEne());
		return valoresIniciales;
    };
	
	public static  EqualsDimension<IdentificadorPresupuesto> equals=(IdentificadorPresupuesto origen,IdentificadorPresupuesto destino)->{
		if (origen == destino)
			return true;
		if (destino == null)
			return false;
		if (origen.getClass() != destino.getClass())
			return false;
		IdentificadorPresupuesto other = (IdentificadorPresupuesto) destino;

		if (origen.getIdDimension() == null) {
			if (other.getIdDimension() != null)
				return false;
		} else if (!origen.getIdDimension().equals(other.getIdDimension()))
			return false;
		if (origen.getTipoDimension() == null) {
			if (other.getTipoDimension() != null)
				return false;
		} else if (!origen.getTipoDimension().equals(other.getTipoDimension()))
			return false;
		return true;
	
		};
	
	public enum NodoArbol{
		NODO_ZEROS(new Long[]{ 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L}),
		NODO_MES  (new Long[]{ 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L,10L,11L,12L})
		;
		private Long[] mensualidad;
		
		private NodoArbol(Long[] mensualidad) {
			this.mensualidad = mensualidad;
		}
		
	}
	
	public enum IdNodo{
		ID_1_1_01(1L,"1", "1"),
		ID_1_2_02(1L,"2", "2"),
		ID_2_1_03(2L,"1", "3"),
		ID_2_2_04(2L,"2", "4"),
		ID_2_3_05(2L,"3", "5"),
		ID_2_4_06(2L,"4", "6"),
		ID_2_5_07(2L,"5", "7"),
		ID_3_1_08(3L,"1", "8"),
		ID_3_2_09(3L,"2","9"),
		ID_3_3_10(3L,"3","10"),
		ID_3_4_11(3L,"4","11"),
		ID_3_5_12(3L,"5","12"),
		;
		private Long tipoDimension;
		private String idDimension;
		private String id;
		private IdNodo(Long tipoDimension, String idDimension,String id) {
			this.tipoDimension = tipoDimension;
			this.idDimension = idDimension;
			this.id=id;
		}
		
	}
	/**
	 * 
	 * Las posicones de los meses.
	 * 
	 * @author david
	 *
	 */
	public enum PosicionMes{
		ENE(0),FEB(1),MAR(2),ABR(3),MAY(4),JUN(5),
		JUL(6),AGO(7),SEP(8),OCT(9),NOV(10),DIC(11);
		private int posicion;
		private PosicionMes(int posicion) {
			this.posicion = posicion;
		}
	}
	
	public enum Arbol{
		ARBOL_BASICO(       new int[]{-1,0,0}
					 ,   new IdNodo[]{IdNodo.ID_1_1_01  ,IdNodo.ID_2_1_03  ,IdNodo.ID_2_2_04}
					 ,new NodoArbol[]{NodoArbol.NODO_MES,NodoArbol.NODO_MES,NodoArbol.NODO_MES })
		;
		private int[] ascendiente;
		private IdNodo[]id;
		private NodoArbol[]datos;
		private Arbol(int[] ascendiente, IdNodo[] id, NodoArbol[] datos) {
			this.ascendiente = ascendiente;
			this.id = id;
			this.datos = datos;
		}
		
	}
	
	/**
	 * Nos crear el id de una dimension.
	 * 
	 * @param escenario
	 * @return
	 */
	public IdentificadorPresupuesto crearIdentificador(IdNodo escenario){
		IdentificadorPresupuesto valdev=new IdentificadorPresupuesto();
		valdev.setId(escenario.id);
		valdev.setIdDimension(escenario.idDimension);
		valdev.setTipoDimension(escenario.tipoDimension);
		return valdev;
	}
	
	/**
	 * Se encarga de crear un nodo, segun el escenario que le pasemos
	 * 
	 * @param nodo	El escenario que tienen el nodo.
	 * @param id	El id del nodo.
	 * @param padre El nodo que hace de padre.
	 * @return
	 */
	public NodoPresupuestosArbolDTO crearNodo(IdentificadorPresupuesto id,NodoPresupuestosArbolDTO padre,NodoArbol nodo){
		NodoPresupuestosArbolDTO valdev=new NodoPresupuestosArbolDTO();
		valdev.setId(id);
		valdev.setPadre(padre);
		valdev.setEne(BigDecimal.valueOf(nodo.mensualidad[PosicionMes.ENE.posicion]));
		valdev.setFeb(BigDecimal.valueOf(nodo.mensualidad[PosicionMes.FEB.posicion]));
		valdev.setMar(BigDecimal.valueOf(nodo.mensualidad[PosicionMes.MAR.posicion]));
		valdev.setAbr(BigDecimal.valueOf(nodo.mensualidad[PosicionMes.ABR.posicion]));
		valdev.setMay(BigDecimal.valueOf(nodo.mensualidad[PosicionMes.MAY.posicion]));
		valdev.setJun(BigDecimal.valueOf(nodo.mensualidad[PosicionMes.JUN.posicion]));
		valdev.setJul(BigDecimal.valueOf(nodo.mensualidad[PosicionMes.JUL.posicion]));
		valdev.setAgo(BigDecimal.valueOf(nodo.mensualidad[PosicionMes.AGO.posicion]));
		valdev.setSep(BigDecimal.valueOf(nodo.mensualidad[PosicionMes.SEP.posicion]));
		valdev.setOct(BigDecimal.valueOf(nodo.mensualidad[PosicionMes.OCT.posicion]));
		valdev.setNov(BigDecimal.valueOf(nodo.mensualidad[PosicionMes.NOV.posicion]));
		valdev.setDic(BigDecimal.valueOf(nodo.mensualidad[PosicionMes.DIC.posicion]));
		return valdev;
	}
	
	public NodoPresupuestosArbolDTO crearArbol(Arbol arbol){
		List<NodoPresupuestosArbolDTO> listaNodos=new ArrayList<NodoPresupuestosArbolDTO>();
		for(int i=0;i<arbol.id.length;i++){
			listaNodos.add(crearNodo(crearIdentificador(arbol.id[i]),null,arbol.datos[i]));
		}
		// Establece los padres.
		// Establecer los hijos.
		return null;
	}
	
}
