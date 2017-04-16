package ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestManyToMany {
	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		sessionFactory = new Configuration().configure().buildSessionFactory();

		Book springBook = new Book();
		springBook.setTitle("스프링 프로그래밍");
		Book hibernateBook = new Book();
		hibernateBook.setTitle("하이버네이트 프로그래밍");
		Book htmlBook = new Book();
		htmlBook.setTitle("HTML/CSS/JavaScript");

		Author author1 = new Author();
		author1.setName("author1");
		Author author2 = new Author();
		author2.setName("author2");
		Author author3 = new Author();
		author3.setName("author3");

		springBook.getAuthors().add(author1);
		springBook.getAuthors().add(author2);
		springBook.getAuthors().add(author3);

		hibernateBook.getAuthors().add(author1);
		hibernateBook.getAuthors().add(author2);

		htmlBook.getAuthors().add(author2);
		htmlBook.getAuthors().add(author3);

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(springBook);
		session.save(hibernateBook);
		session.save(htmlBook);

		tx.commit();
		session.close();
	}
}
