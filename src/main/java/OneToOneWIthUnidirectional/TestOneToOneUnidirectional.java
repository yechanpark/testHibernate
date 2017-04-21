package OneToOneWIthUnidirectional;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestOneToOneUnidirectional {
	private static SessionFactory sessionFactory;

	public static void main(String[] args) {
		sessionFactory = new Configuration().configure().buildSessionFactory();

		UniPerson person1 = new UniPerson();
		person1.setFirstName("Yechan");
		person1.setLastName("Park");

		UniLicense license1 = new UniLicense();
		license1.setLicenseNumber("123456");
		license1.setIssue_date(new Date());
		license1.setPerson(person1);
		
		UniPerson person2 = new UniPerson();
		person2.setFirstName("Alice");
		person2.setLastName("Lee");

		UniLicense license2 = new UniLicense();
		license2.setLicenseNumber("78910");
		license2.setIssue_date(new Date());
		license2.setPerson(person2);

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(license1);
		session.save(license2);

		tx.commit();
		session.close();

	}
}