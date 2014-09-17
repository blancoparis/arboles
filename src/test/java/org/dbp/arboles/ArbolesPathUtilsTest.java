package org.dbp.arboles;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.dbp.arboles.mock.ArbolesMock;
import org.dbp.arboles.presupuestos.bean.IdentificadorPresupuesto;
import org.dbp.arboles.presupuestos.bean.NodoPresupuestosArbolDTO;
import org.junit.Test;

/**
 * 
 * Test unitarios de la libreria de los path
 * 
 * @author david
 *
 */
public class ArbolesPathUtilsTest {
	/**
	 * Test de la creacion de los nodos raiz.
	 */
	@Test
	public void test001CrearRaiz(){
		assertNodoRaiz( crearElNodoRaiz());
		// 
		ArbolesPathUtils<NodoPresupuestosArbolDTO,IdentificadorPresupuesto> arbolesPathUtils=new ArbolesPathUtils<NodoPresupuestosArbolDTO,IdentificadorPresupuesto>();
		NodoPresupuestosArbolDTO raiz = new NodoPresupuestosArbolDTO();
		raiz.setEne(BigDecimal.valueOf(1L));
		raiz.setFeb(BigDecimal.valueOf(2L));
		raiz.setMar(BigDecimal.valueOf(3L));
		raiz.setAbr(BigDecimal.valueOf(4L));
		raiz.setMay(BigDecimal.valueOf(5L));
		raiz.setJun(BigDecimal.valueOf(6L));
		raiz.setJul(BigDecimal.valueOf(7L));
		raiz.setAgo(BigDecimal.valueOf(8L));
		raiz.setSep(BigDecimal.valueOf(9L));
		raiz.setOct(BigDecimal.valueOf(10L));
		raiz.setNov(BigDecimal.valueOf(11L));
		raiz.setDic(BigDecimal.valueOf(12L));
		raiz.setTotal(BigDecimal.valueOf(13L));
		IdentificadorPresupuesto id=new IdentificadorPresupuesto();
		id.setIdDimension("2");
		id.setTipoDimension(1L);
		arbolesPathUtils.crearRaiz(raiz,id);
		
		assertNull("Miramos que no tiene padre",raiz.getPadre());
		assertEquals("No se esperan hijo",0,raiz.getFilas().size());
		assertEquals("Se espera el id tipo",new Long(1L),raiz.getId().getTipoDimension());
		assertEquals("Se espera el id el id","2",raiz.getId().getIdDimension());
		assertEquals("No hay datos en ene",1L,raiz.getEne().longValue());
		assertEquals("No hay datos en feb",2L,raiz.getFeb().longValue());
		assertEquals("No hay datos en mar",3L,raiz.getMar().longValue());
		assertEquals("No hay datos en abr",4L,raiz.getAbr().longValue());
		assertEquals("No hay datos en may",5L,raiz.getMay().longValue());
		assertEquals("No hay datos en jun",6L,raiz.getJun().longValue());
		assertEquals("No hay datos en jul",7L,raiz.getJul().longValue());
		assertEquals("No hay datos en ago",8L,raiz.getAgo().longValue());
		assertEquals("No hay datos en sep",9L,raiz.getSep().longValue());
		assertEquals("No hay datos en oct",10L,raiz.getOct().longValue());
		assertEquals("No hay datos en nov",11L,raiz.getNov().longValue());
		assertEquals("No hay datos en dic",12L,raiz.getDic().longValue());
		assertEquals("No hay datos en total",13L,raiz.getTotal().longValue());
	}





	
	private enum EscenariosIds{
		ELEMENTO_RAIZ(new Long[]{2L},new String[]{"1"})
		;
		private Long[] tipo;
		private String[] idDimension;
		private EscenariosIds(Long[] tipo, String[] idDimension) {
			this.tipo = tipo;
			this.idDimension = idDimension;
		}
		private static List<IdentificadorPresupuesto> obtenerLista(EscenariosIds escenario){
			List<IdentificadorPresupuesto> valdev=new ArrayList<IdentificadorPresupuesto>();
			IdentificadorPresupuesto elemento=null;
			for(int i=0;i<escenario.tipo.length;i++){
				elemento= new IdentificadorPresupuesto();
				elemento.setTipoDimension(escenario.tipo[i]);
				elemento.setIdDimension(escenario.idDimension[i]);
				valdev.add(elemento);
			}
			return valdev;
		}
	}
	
	@Test
	public void testBuscarNodo() throws InstantiationException, IllegalAccessException{
		ArbolesPathUtils<NodoPresupuestosArbolDTO,IdentificadorPresupuesto> arbolesPathUtils=new ArbolesPathUtils<NodoPresupuestosArbolDTO,IdentificadorPresupuesto>();
		NodoPresupuestosArbolDTO raiz=crearElNodoRaiz();
		for(EscenariosIds escenario:EscenariosIds.values()){
			List<IdentificadorPresupuesto> ids=EscenariosIds.obtenerLista(escenario);
			arbolesPathUtils.buscarNodo(raiz, ids,new NodoPresupuestosArbolDTO(),ArbolesMock.inicializarNodo,ArbolesMock.equals);
		}
	}
	
	
	/**
	 * Se encarga de crear un nodo raiz
	 * @return
	 */
	private NodoPresupuestosArbolDTO crearElNodoRaiz() {
		ArbolesPathUtils<NodoPresupuestosArbolDTO,IdentificadorPresupuesto> arbolesPathUtils=new ArbolesPathUtils<NodoPresupuestosArbolDTO,IdentificadorPresupuesto>();
		NodoPresupuestosArbolDTO raiz = new NodoPresupuestosArbolDTO();
		IdentificadorPresupuesto id=new IdentificadorPresupuesto();
		id.setIdDimension("1");
		id.setTipoDimension(1L);
		arbolesPathUtils.crearRaiz(raiz,id);
		return raiz;
	}
	/**
	 * 
	 * Assert del nodo raiz
	 * 
	 * @param raiz
	 */
	private void assertNodoRaiz(NodoPresupuestosArbolDTO raiz) {
		assertNull("Miramos que no tiene padre",raiz.getPadre());
		assertEquals("No se esperan hijo",0,raiz.getFilas().size());
		assertEquals("Se espera el id tipo",new Long(1L),raiz.getId().getTipoDimension());
		assertEquals("Se espera el id el id","1",raiz.getId().getIdDimension());
		assertNull("No hay datos en ene",raiz.getEne());
		assertNull("No hay datos en feb",raiz.getFeb());
		assertNull("No hay datos en mar",raiz.getMar());
		assertNull("No hay datos en abr",raiz.getAbr());
		assertNull("No hay datos en may",raiz.getMay());
		assertNull("No hay datos en jun",raiz.getJun());
		assertNull("No hay datos en jul",raiz.getJul());
		assertNull("No hay datos en ago",raiz.getAgo());
		assertNull("No hay datos en sep",raiz.getSep());
		assertNull("No hay datos en oct",raiz.getOct());
		assertNull("No hay datos en nov",raiz.getNov());
		assertNull("No hay datos en dic",raiz.getDic());
		assertNull("No hay datos en total",raiz.getTotal());
	}

	
}
