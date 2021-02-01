package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.*;

import helper.HibernateUtil;
import model.Producto;

public class TestCrudProducto {
	
	private static SessionFactory sessionFactory;
	private Session session;
	
	@BeforeAll
	public static void setUp() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	@AfterAll
	public static void tearDown() {
		if (sessionFactory != null ) sessionFactory.close();
		System.out.println("Session Factory Destroyed");
	}
	
	@BeforeEach
	public void openSession() {
		session = sessionFactory.openSession();
		System.out.println("Session created");		
	}
	
	@AfterEach
	public void closeSession() {
		if (session != null) session.close();
		System.out.println("Session closed\n");
	}

	@Disabled
	@Test
	public void testCreate() {
		 System.out.println("Probando creación de objetos...");     
		 session.beginTransaction();
		     
		 Producto product = new Producto("iPhone 10", 699,"Electrónica");
		 Integer id = (Integer) session.save(product);
		     
		 session.getTransaction().commit();
		    
		 assertTrue(id > 0);
	}
	
	@Disabled
	@Test
	public void testUpdate() {
		System.out.println("Probando la actualización del producto...");
	     
	    Integer id = 1;
	    Producto product = new Producto(id, "iPhone 11", 999,"Electrónica");
	     
	    session.beginTransaction();
	    session.update(product);
	    session.getTransaction().commit();
	     
	    Producto productoActualizado = session.find(Producto.class, id);
	     
	    assertEquals("iPhone 11", productoActualizado.getNombre());
	}
	
	@Disabled
	@Test
	public void testList() {
		 System.out.println("Running testList...");
	     
		 Query<Producto> query = session.createQuery("from Producto", Producto.class);
		 List<Producto> resultList = query.getResultList();
		     
		 assertFalse(resultList.isEmpty());
	}
	
	@Disabled
	@Test
	public void testDelete() {
		System.out.println("Probando el borrado de productos...");
	     
	    Integer id = 1;
	    Producto product = session.find(Producto.class, id);
	     
	    session.beginTransaction();
	    session.delete(product);
	    session.getTransaction().commit();
	     
	    Producto deletedProduct = session.find(Producto.class, id);
	     
	    Assertions.assertNull(deletedProduct);
		
	}
}
