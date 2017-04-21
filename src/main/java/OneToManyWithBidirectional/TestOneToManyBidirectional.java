package OneToManyWithBidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestOneToManyBidirectional {

	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		sessionFactory = new Configuration().configure().buildSessionFactory();

		BiCategory category1 = new BiCategory();
		category1.setName("Computer");
		BiCategory category2 = new BiCategory();
		category2.setName("Car");

		BiProduct product1 = new BiProduct();
		product1.setName("노트북1");
		product1.setPrice(1000);
		product1.setDescription("Awesome Notebook");
		product1.setCategory(category1);
		category1.getProducts().add(product1);

		BiProduct product2 = new BiProduct();
		product2.setName("노트북2");
		product2.setPrice(2000);
		product2.setDescription("LG Notebook");
		product2.setCategory(category1);
		category1.getProducts().add(product2);

		BiProduct product3 = new BiProduct();
		product3.setName("소나타");
		product3.setPrice(10000);
		product3.setDescription("대중적인 자동차");
		product3.setCategory(category2);
		category2.getProducts().add(product3);

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		// Category에서 CASCADE를 지정했기 때문에 부모(Category)만 저장해도 자식(Product)도 자동저장
		session.save(category1);
		session.save(category2);

		tx.commit();
		session.close();
	}

}
