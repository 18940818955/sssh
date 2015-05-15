package cn.wb.secutiry;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;

import cn.wb.service.UserService;
@Controller
public class MyUserDetailService implements UserDetailsService{

	@Resource
	private UserService userService;
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		return userService.findByUsername(username);
	}
}
