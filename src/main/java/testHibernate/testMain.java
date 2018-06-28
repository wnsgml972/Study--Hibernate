package testHibernate;

import java.util.Date;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class testMain {

	private static SessionFactory sessionFactory;
	
	public static void main(String[] args) {
		
		Category category1 = new Category();
		category1.setName("Computre");

		Category category2 = new Category();
		category2.setName("Car");
				
		
		Product product1 = new Product();
		product1.setName("Notebook");
		product1.setPrice(1000);
		product1.setDescription("Powerful Notebook");
		product1.setCategory(category1);
		category1.getProducts().add(product1);
		
		Product product2 = new Product();
		product2.setName("Desktop");
		product2.setPrice(2000);
		product2.setDescription("Powerful Desktop");
		product2.setCategory(category1);
		
		category1.getProducts().add(product2);
		
		Product product3 = new Product();
		product3.setName("Sonata");
		product3.setPrice(1000000);
		product3.setDescription("대중적인 자동차");
		product3.setCategory(category2);
		category2.getProducts().add(product3);
		
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		sessionFactory = conf.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		//cascade를 category(부모)에 나뒀으므로 categofy로 session을 다 control
		session.save(category1); //sql statement
		session.save(category2); //sql statement
		
		tx.commit();
		session.close();
	}
	
	public void test(){
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		sessionFactory = conf.buildSessionFactory();
		
		Person person1 = new Person();
		person1.setFirstName("JunHee");
		person1.setLastName("Kim");
		
		Person person2 = new Person();
		person2.setFirstName("YounSuck");
		person2.setLastName("Choi");

		License license1 = new License();
		license1.setLicenseNumber("12345");
		license1.setIssueDate(new Date());
	
		License license2 = new License();
		license2.setLicenseNumber("54678");
		license2.setIssueDate(new Date());
		
		license1.setPerson(person1);
		license2.setPerson(person2);
		person1.setLicense(license1);
		person2.setLicense(license2);
		
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(person1);
		session.save(person2);
		
		
		
		tx.commit();
		session.close();
	}
	
	public void testproduct(){
		Category category1 = new Category();
		category1.setName("Computre");

		Category category2 = new Category();
		category2.setName("Car");
				
		
		Product product1 = new Product();
		product1.setName("Notebook");
		product1.setPrice(1000);
		product1.setDescription("Powerful Notebook");
		product1.setCategory(category1);
		category1.getProducts().add(product1);
		
		Product product2 = new Product();
		product2.setName("Desktop");
		product2.setPrice(2000);
		product2.setDescription("Powerful Desktop");
		product2.setCategory(category1);
		category1.getProducts().add(product2);
		
		Product product3 = new Product();
		product3.setName("Sonata");
		product3.setPrice(1000000);
		product3.setDescription("대중적인 자동차");
		product3.setCategory(category2);
		category2.getProducts().add(product3);
		
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		sessionFactory = conf.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		//cascade를 category(부모)에 나뒀으므로 categofy로 session을 다 control
		session.save(category1); //sql statement
		session.save(category2); //sql statement
	}
}