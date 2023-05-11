package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import model.Portatil;

public class PortatilController {
	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("PortatilesYMarcasJPA");
	
	/**
	 * 
	 * @return
	 */
	public static int minId() {
		try {
			Connection conn = ConnectionManager.getConexion();

			PreparedStatement ps = conn.prepareStatement("select min(id) from portatil");
			ResultSet rs = ps.executeQuery();

			int cont = 0;

			if (rs.next()) {
				cont = rs.getInt(1);
			}

			rs.close();
			ps.close();
			conn.close();

			return cont;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 
	 * @return
	 */
	public static int maxId() {
		try {
			Connection conn = ConnectionManager.getConexion();

			PreparedStatement ps = conn.prepareStatement("select max(id) from portatil");
			ResultSet rs = ps.executeQuery();

			int cont = 0;

			if (rs.next()) {
				cont = rs.getInt(1);
			}

			rs.close();
			ps.close();
			conn.close();

			return cont;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 
	 * @return
	 */
	public static int count() {
		try {
			Connection conn = ConnectionManager.getConexion();

			PreparedStatement ps = conn.prepareStatement("select count(*) from portatil");
			ResultSet rs = ps.executeQuery();

			int cont = 0;

			if (rs.next()) {
				cont = rs.getInt(1);
			}

			rs.close();
			ps.close();
			conn.close();

			return cont;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 
	 * @return
	 */
	public static Portatil findById(int id) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("select * from portatil where id = ?", Portatil.class);
		q.setParameter(1, id);
		Portatil o = (Portatil) q.getSingleResult();
		em.close();
		return o;
	}

	/**
	 * 
	 * @return
	 */
	public static List<Portatil> findAll() {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("select * from portatil", Portatil.class);
		List<Portatil> lista = (List<Portatil>) q.getResultList();
		em.close();
		return lista;
	}

	/**
	 * 
	 * @return
	 */
	public static Portatil findFirst() {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("select * from portatil order by id limit 1", Portatil.class);
		Portatil o = (Portatil) q.getSingleResult();
		em.close();
		return o;
	}

	/**
	 * 
	 * @return
	 */
	public static Portatil findLast() {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("select * from portatil order by id desc limit 1", Portatil.class);
		Portatil o = (Portatil) q.getSingleResult();
		em.close();
		return o;
	}

	/**
	 * 
	 * @param o
	 * @return
	 */
	public static Portatil findPrevious(int id) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("select * from portatil where id < " + id + " order by id desc limit 1",
				Portatil.class);
		try {
			Portatil o1 = (Portatil) q.getSingleResult();
			em.close();
			return o1;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 
	 * @param o
	 * @return
	 */
	public static Portatil findNext(int id) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("select * from portatil where id > " + id + " order by id limit 1",
				Portatil.class);
		try {
			Portatil o1 = (Portatil) q.getSingleResult();
			em.close();
			return o1;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 
	 * @param o
	 */
	public static void update(Portatil o) {
		EntityManager em = entityManagerFactory.createEntityManager();

		em.getTransaction().begin();
		em.merge(o);
		JOptionPane.showMessageDialog(null, "Has realizado la modificación.");
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * 
	 * @param o
	 */
	public static void insert(Portatil o) {
		EntityManager em = entityManagerFactory.createEntityManager();

		em.getTransaction().begin();
		em.persist(o);
		JOptionPane.showMessageDialog(null, "Has realizado la inserción.");
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * 
	 * @param o
	 */
	public static void remove(Portatil o) {
		EntityManager em = entityManagerFactory.createEntityManager();

		em.getTransaction().begin();
		o = em.merge(o);
		em.remove(o);
		JOptionPane.showMessageDialog(null, "Has eliminado un registro.");
		em.getTransaction().commit();
		em.close();
	}
}
