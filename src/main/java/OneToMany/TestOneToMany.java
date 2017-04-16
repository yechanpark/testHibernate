package OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestOneToMany {

	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		// 세션을 만드는 변수
		sessionFactory = new Configuration().configure().buildSessionFactory();

		Category category1 = new Category();
		category1.setName("Computer");
		Category category2 = new Category();
		category2.setName("Car");

		Product product1 = new Product();
		product1.setName("노트북1");
		product1.setPrice(1000);
		product1.setDescription("Awesome Notebook");
		product1.setCategory(category1);
		category1.getProducts().add(product1);

		Product product2 = new Product();
		product2.setName("노트북2");
		product2.setPrice(2000);
		product2.setDescription("LG Notebook");
		product2.setCategory(category1);
		category1.getProducts().add(product2);

		Product product3 = new Product();
		product3.setName("소나타");
		product3.setPrice(10000);
		product3.setDescription("대중적인 자동차");
		product3.setCategory(category2);
		category2.getProducts().add(product3);

		// 세션을 만듦.
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		// Category에서 CASCADE를 지정했기 때문에 부모(Category)만 저장해도 자식(Product)도 자동저장
		session.save(category1);
		session.save(category2);

		tx.commit();
		session.close();
	}

}
