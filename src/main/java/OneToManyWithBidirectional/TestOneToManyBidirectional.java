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
		product1.setName("��Ʈ��1");
		product1.setPrice(1000);
		product1.setDescription("Awesome Notebook");
		product1.setCategory(category1);
		category1.getProducts().add(product1);

		BiProduct product2 = new BiProduct();
		product2.setName("��Ʈ��2");
		product2.setPrice(2000);
		product2.setDescription("LG Notebook");
		product2.setCategory(category1);
		category1.getProducts().add(product2);

		BiProduct product3 = new BiProduct();
		product3.setName("�ҳ�Ÿ");
		product3.setPrice(10000);
		product3.setDescription("�������� �ڵ���");
		product3.setCategory(category2);
		category2.getProducts().add(product3);

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		// Category���� CASCADE�� �����߱� ������ �θ�(Category)�� �����ص� �ڽ�(Product)�� �ڵ�����
		session.save(category1);
		session.save(category2);

		tx.commit();
		session.close();
	}

}
