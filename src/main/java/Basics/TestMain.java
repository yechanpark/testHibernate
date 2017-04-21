package Basics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestMain {

	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		// Configuration Class에서 configure()를 호출하여 hibernate.cfg.xml을 읽어
		// sessionFactory를 만들어 반환한다.
		sessionFactory = new Configuration().configure().buildSessionFactory();

		Product product = new Product();
		product.setName("노트북");
		product.setPrice(2000);
		product.setDescription("Awesome Notebook");

		// session을 하나 생성하여 리턴
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(product);

		tx.commit();
		session.close();
	}

}