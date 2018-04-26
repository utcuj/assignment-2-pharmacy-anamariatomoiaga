package controller;

import java.util.List;
import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


import model.Medication;

public class MedicationController {
	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public static Integer create(Medication m) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		if(m.getQuantity()<=0) {
			JOptionPane.showMessageDialog(null,"Cantitate invalida");
		}
		session.save(m);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully created " + m.toString());
		return m.getId();
	}
	public static List<Object> read() {
		Session session = getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Object> m = session.createQuery("FROM Medication").list();
		session.close();
		System.out.println("Found " + m.size() + " Medication");
		return m;

	}
	public static List<Object> searchName(String name) {
		Session session = getSessionFactory().openSession();
		Query query = session.createQuery("FROM Medication m where (m.name LIKE :medName) OR (m.ingredients LIKE :medName) OR (m.manufacturer LIKE :medName) ");
		query.setParameter("medName","%" +name +"%");
		@SuppressWarnings("unchecked")
		List<Object> m = query.list();
		session.close();
		System.out.println("Found " + m.size() + " Medication");
		return m;

	}
	public static Medication findByID(Integer id) {
		Session session = getSessionFactory().openSession();
		Medication m = (Medication) session.load(Medication.class, id);
		session.close();
		return m;
	}
	public static void delete(Integer id) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		if(id<=0) {
			JOptionPane.showMessageDialog(null,"Id invalid");
		}
		Medication m = findByID(id);
		session.delete(m);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully deleted " + m.toString());

	}
	public static void update(Medication m) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		if(m.getId()<=0) {
			JOptionPane.showMessageDialog(null,"Id invalid");
		}
		if(m.getQuantity()<=0) {
			JOptionPane.showMessageDialog(null,"Cantitate invalida");
		}
		Medication em = (Medication) session.load(Medication.class, m.getId());
		em.setName(m.getName());
		em.setManufacturer(m.getManufacturer());
		em.setIngredients(m.getIngredients());
		em.setQuantity(m.getQuantity());
		em.setPrice(m.getPrice());
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully updated " + m.toString());

	}
	public static void updateQuantity(int id, int quantity) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		if(id<=0) {
			JOptionPane.showMessageDialog(null,"Id invalid");
		}
		if(quantity<=0) {
			JOptionPane.showMessageDialog(null,"Cantitate invalida");
		}
		Medication em = (Medication) session.load(Medication.class, id);
		if(quantity < em.getQuantity()) {
			em.setQuantity(em.getQuantity()-quantity);
			System.out.println("Successfully updated " );
		}
		else
			JOptionPane.showMessageDialog(null,"Cantitate indisponibila");
		
		session.getTransaction().commit();
		session.close();
		

	}
	public static List<Object> searchM() {
		Session session = getSessionFactory().openSession();
		Query query = session.createQuery("FROM Medication m where (m.quantity= :q)  ");
		query.setParameter("q",0);
		@SuppressWarnings("unchecked")
		List<Object> m = query.list();
		session.close();
		System.out.println("Found " + m.size() + " Medication");
		return m;

	}
	
}
