package Basics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestMain {

	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		// Configuration Class���� configure()�� ȣ���Ͽ� hibernate.cfg.xml�� �о�
		// sessionFactory�� ����� ��ȯ�Ѵ�.
		sessionFactory = new Configuration().configure().buildSessionFactory();

		Product product = new Product();
		product.setName("��Ʈ��");
		product.setPrice(2000);
		product.setDescription("Awesome Notebook");

		// session�� �ϳ� �����Ͽ� ����
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(product);

		tx.commit();
		session.close();
	}

}