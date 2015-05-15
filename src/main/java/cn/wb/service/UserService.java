package cn.wb.service;

import org.springframework.security.core.userdetails.UserDetails;

import cn.wb.base.BaseDao;
import cn.wb.domain.User;

public interface UserService extends BaseDao<User>{
	public UserDetails findByUsername(String username);
}
