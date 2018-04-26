package controller;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import model.User;


public class UserController {
	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(builder.build());
		return sessionFactory;
	}
	
	public static int login(String username, String password, boolean admin) {
		Session session = getSessionFactory().openSession();
		Query query = session.createQuery("FROM User u where u.name= :username ");
		query.setParameter("username",username);
		@SuppressWarnings("unchecked")
		List<User> u = query.list();
		for(User x: u) {
			if(x.getPassword().equals(password) && x.getAdmin() == admin) {
				return x.getId();
			}
		}
		session.close();
		return -1; 
	}
	public static Integer create(User u) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.save(u);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully created " + u.toString());
		return u.getId();
	}
	public static List<Object> read() {
		Session session = getSessionFactory().openSession();
		Query query = session.createQuery("FROM User u where u.admin= :admin");
		query.setParameter("admin",false);
		@SuppressWarnings("unchecked")
		List<Object> u =query.list();
		session.close();
		System.out.println("Found " + u.size() + " Users");
		return u;

	}
	public static void update(int id, String name, String address, boolean admin) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		if(id<=0) {
			JOptionPane.showMessageDialog(null,"Id invalid");
		}
		User em = (User) session.load(User.class, id);
		em.setName(name);
		em.setAddress(address);
		em.setAdmin(admin);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully updated " + em.toString());

	}
	public static User findByID(Integer id) {
		Session session = getSessionFactory().openSession();
		User u = (User) session.load(User.class, id);
		session.close();
		return u;
	}
	public static void delete(Integer id) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		if(id<=0) {
			JOptionPane.showMessageDialog(null,"Id invalid");
		}
		User u = findByID(id);
		session.delete(u);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully deleted " + u.toString());

	}
	
}
