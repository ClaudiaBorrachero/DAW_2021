package pruebas;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dao.ProductoDAOImpl;
import helper.HibernateUtil;
import model.Producto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.LinkedList;	
import java.util.List;

public class TestMockitoDAO {
	
	@Test
	public void testProductoDaoGetList() {
		
		ProductoDAOImpl productoDao = mock(ProductoDAOImpl.class);
	
		List<Producto> productos = creaProductos();
		
		
		when(productoDao.getAllProductsByCategory("Electrócnica")).thenReturn(productos);		
		assertEquals(productoDao.getAllProductsByCategory("Electrócnica"),productos);
		verify(productoDao).getAllProductsByCategory("Electrócnica");
		
	}
	
	
	public List<Producto> creaProductos() {
		List<Producto> resultado = new LinkedList<Producto>();
		
		Producto p1 = new Producto(1,"Leche",2.50,"Alimentación");
		Producto p2 = new Producto(2,"Zumo",3.2,"Alimentación");
		Producto p3 = new Producto(2,"Zumo",3.2,"Alimentación");
		
		resultado.add(p1);
		resultado.add(p2);
		resultado.add(p3);
		
		return resultado;
		
		
	}

}
