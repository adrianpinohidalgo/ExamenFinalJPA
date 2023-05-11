package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Pai;

public class PaisController {
	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("PortatilesYMarcasJPA");

	/**
	 * 
	 * @return
	 */
	public static List<Pai> findAll() {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("select * from pais", Pai.class);
		List<Pai> lista = (List<Pai>) q.getResultList();
		em.close();
		return lista;
	}
}
