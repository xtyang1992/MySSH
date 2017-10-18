package com.myssh.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.myssh.entity.User;

public class SSHTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	private ApplicationContext context = null; 
	
	@Test
	public void testSSH() throws SQLException {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//System.out.print(context.toString());
		
		//DataSource dataSource = context.getBean(DataSource.class);
		//System.out.print(dataSource.getConnection());
		
		SessionFactory sessionFactory = context.getBean(SessionFactory.class);
		//System.out.print(sessionFactory.toString());
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		User user = new User("hanmeimei", "123456");
		session.save(user);
		tx.commit();
		
		session.close();
	}
}
