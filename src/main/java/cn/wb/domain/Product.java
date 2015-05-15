package cn.wb.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_product")
public class Product {

	private Integer id;
	private String name;
	private double price;
	private Set<OrderProduct> productOrders;

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	@OneToMany(mappedBy="product")
	public Set<OrderProduct> getProductOrders() {
		return productOrders;
	}

	public void setProductOrders(Set<OrderProduct> productOrders) {
		this.productOrders = productOrders;
	}

}
