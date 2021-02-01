package dao;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.persistence.Query;
import org.hibernate.Session;

import helper.HibernateUtil;
import model.Producto;

public class ProductoDAOImpl {


	public List<Producto> getAllProductsByCategory(String category) {

		Session session = null;
		List<Producto> result = new LinkedList<Producto>();

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			result.addAll(session.createQuery("FROM products u WHERE u.categoria='"+category+"'", Producto.class).list());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}