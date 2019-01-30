package firstexample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestPerson {

	public static void main(String[] args) {

		Configuration config = new Configuration();
		config.addAnnotatedClass(Person.class);
		config.configure("hibernate.cfg.xml");

		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		Person person1 = new Person("Berkay", "Demirel", 24);
		Person person2 = new Person("Hibernate", "Test", 11);

		session.save(person1);
		session.save(person2);
		session.getTransaction().commit();

	}

}
