package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import model.Marca;
import model.Portatil;

public class MarcaController {
	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("PortatilesYMarcasJPA");

	/**
	 * 
	 * @return
	 */
	public static List<Marca> findAll() {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("select * from marca", Marca.class);
		List<Marca> lista = (List<Marca>) q.getResultList();
		em.close();
		return lista;
	}

	/**
	 * 
	 * @return
	 */
	public static Marca findById(int id) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("select * from marca where id = ?", Marca.class);
		q.setParameter(1, id);
		Marca o = (Marca) q.getSingleResult();
		em.close();
		return o;
	}
	
	/**
	 * 
	 * @param o
	 */
	public static void update(Marca o) {
		EntityManager em = entityManagerFactory.createEntityManager();

		em.getTransaction().begin();
		em.merge(o);
		JOptionPane.showMessageDialog(null, "Has realizado la modificación.");
		em.getTransaction().commit();
		em.close();
	}

}
