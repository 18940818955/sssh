package cn.wb.util;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.wb.domain.Product;
import cn.wb.domain.Role;
import cn.wb.domain.User;

@Component
public class InitialDatabase {
	@Resource
	private SessionFactory sessionFactory;

	@SuppressWarnings("null")
	@Transactional
	public void initDatabase() {
		Session session = sessionFactory.getCurrentSession();
		Role role1 = new Role("ROLE_USER");
		Role role2 = new Role("ROLE_ADMIN");
		Role role3 = new Role("ROLE_CUSTOMER");
		session.save(role1);
		session.save(role2);
		session.save(role3);
		Set<Role> roles1 = new HashSet<Role>();
		roles1.add(role1);
		roles1.add(role2);
		Set<Role> roles2 = new HashSet<Role>();
		roles2.add(role1);
		roles2.add(role3);

		User user1 = new User("admin", "111", "253498229@qq.com", roles1);
		User user2 = new User("user", "111", "253498229@qq.com", roles2);
		session.save(user1);
		session.save(user2);
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"spring-common.xml");
		InitialDatabase initt = (InitialDatabase) ac.getBean("initialDatabase");
		initt.initDatabase();
	}
}
