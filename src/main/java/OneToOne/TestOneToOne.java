package OneToOne;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestOneToOne {
	private static SessionFactory sessionFactory;

	public static void main(String[] args) {
		sessionFactory = new Configuration().configure().buildSessionFactory();

		Person person1 = new Person();
		person1.setFirstName("Yechan");
		person1.setLastName("Park");

		License license1 = new License();
		license1.setLicenseNumber("123456");
		license1.setIssue_date(new Date());
		license1.setPerson(person1);
		
		person1.setLicense(license1);

		Person person2 = new Person();
		person2.setFirstName("Alice");
		person2.setLastName("Lee");

		License license2 = new License();
		license2.setLicenseNumber("78910");
		license2.setIssue_date(new Date());
		license2.setPerson(person2);

		person2.setLicense(license2);
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		// child인 License객체를 저장하면 parent인 Person까지 저장(CASCADE)
		session.save(license1);
		session.save(license2);

		tx.commit();
		session.close();

	}

}
