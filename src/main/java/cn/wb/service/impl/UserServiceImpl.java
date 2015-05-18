package cn.wb.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.wb.base.BaseDaoImpl;
import cn.wb.domain.User;
import cn.wb.service.UserService;

@Component
@Transactional
public class UserServiceImpl extends BaseDaoImpl<User> implements UserService {
	public UserDetails findByUsername(String username) {
		User user = (User) getSession()
				.createQuery(
						"from User u join fetch u.roles r where u.username=:username ")
				.setParameter("username", username).uniqueResult();
		return (UserDetails) user;
	}
}
