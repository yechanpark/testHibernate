package OneToOneWIthBidirectional;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestOneToOneBidirectional {
	private static SessionFactory sessionFactory;

	public static void main(String[] args) {
		sessionFactory = new Configuration().configure().buildSessionFactory();

		BiPerson person1 = new BiPerson();
		person1.setFirstName("Yechan");
		person1.setLastName("Park");

		BiLicense license1 = new BiLicense();
		license1.setLicenseNumber("123456");
		license1.setIssue_date(new Date());
		license1.setPerson(person1);
		
		person1.setLicense(license1);

		BiPerson person2 = new BiPerson();
		person2.setFirstName("Alice");
		person2.setLastName("Lee");

		BiLicense license2 = new BiLicense();
		license2.setLicenseNumber("78910");
		license2.setIssue_date(new Date());
		license2.setPerson(person2);

		person2.setLicense(license2);
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		// parent인 BiPerson객체를 저장하면 child인 BiLicense객체까지 저장(CASCADE)
		session.save(person1);
		session.save(person2);

		tx.commit();
		session.close();

	}
}