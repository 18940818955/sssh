package cn.wb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "t_user")
public class User implements UserDetails {
	private Integer id;
	private String name;
	private String username;
	private String password;
	private String mobile; // 手机
	private String email;// 邮箱
	private String weixinid;// 微信号 （三者不能同时为空）
	private Role role;
	private Set<Order> orders;

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeixinid() {
		return weixinid;
	}

	public void setWeixinid(String weixinid) {
		this.weixinid = weixinid;
	}

	@ManyToOne
	@JoinColumn(name = "roleid")
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@OneToMany(mappedBy = "createUser")
	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@Transient
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> gas = new ArrayList<GrantedAuthority>();
		GrantedAuthority ga = new SimpleGrantedAuthority(role.getName());
		gas.add(ga);
		return gas;
	}

	@Transient
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Transient
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Transient
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Transient
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
