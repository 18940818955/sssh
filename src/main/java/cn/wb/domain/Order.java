package cn.wb.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_order")
public class Order {

	private Integer id;// id
	private String orderno;// 订单号
	private Date delivertime;// 期待到货日期
	private Date createtime;// 创建时间
	private Set<OrderProduct> orderProducts;// 产品列表
	private User createUser;
	private Basedata status;

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public Date getDelivertime() {
		return delivertime;
	}

	public void setDelivertime(Date delivertime) {
		this.delivertime = delivertime;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@OneToMany(mappedBy = "order")
	public Set<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(Set<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}

	@ManyToOne
	@JoinColumn(name = "createUser")
	public User getCreateUser() {
		return createUser;
	}

	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}

	@ManyToOne
	@JoinColumn(name = "status")
	public Basedata getStatus() {
		return status;
	}

	public void setStatus(Basedata status) {
		this.status = status;
	}

}
