package OneToManyWithUnidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestOneToManyUnidirectional {

	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		sessionFactory = new Configuration().configure().buildSessionFactory();

		UniCategory category1 = new UniCategory();
		category1.setName("Computer");
		UniCategory category2 = new UniCategory();
		category2.setName("Car");

		UniProduct product1 = new UniProduct();
		product1.setName("노트북1");
		product1.setPrice(1000);
		product1.setDescription("Awesome Notebook");
		product1.setCategory(category1);

		UniProduct product2 = new UniProduct();
		product2.setName("노트북2");
		product2.setPrice(2000);
		product2.setDescription("LG Notebook");
		product2.setCategory(category1);

		UniProduct product3 = new UniProduct();
		product3.setName("소나타");
		product3.setPrice(10000);
		product3.setDescription("대중적인 자동차");
		product3.setCategory(category2);

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		/* Many사이드인 Product에서 CASCADE를 지정했기 때문에
		     자식(Product)만 저장해도 부모(Category)도 자동저장 */
		session.save(product1);
		session.save(product2);
		session.save(product3);

		tx.commit();
		session.close();
	}

}
