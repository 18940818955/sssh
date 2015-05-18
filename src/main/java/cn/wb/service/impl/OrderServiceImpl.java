package cn.wb.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.wb.base.BaseDaoImpl;
import cn.wb.domain.Order;
import cn.wb.domain.OrderProduct;
import cn.wb.domain.Product;
import cn.wb.service.OrderProductService;
import cn.wb.service.OrderService;
import cn.wb.service.ProductService;

@Repository
@Transactional
public class OrderServiceImpl extends BaseDaoImpl<Order> implements
		OrderService {
	@Resource
	private ProductService productService;
	@Resource
	private OrderProductService orderProductService;

	public void saveOrder(List<String> params, List<Integer> ids) {
		// TODO Auto-generated method stub
		try {
			Order order = new Order();
			Set<OrderProduct> ops = new HashSet<OrderProduct>();
			for (int i = 0; i < params.size(); i++) {
				OrderProduct op = new OrderProduct();
				if (ids.get(i) != null) {
					Product product = productService
							.getById(Integer.valueOf(ids.get(i)));
					op.setProduct(product);
					op.setAmount(Double.valueOf(String.valueOf(params.get(i))));
					op.setOrder(order);
					orderProductService.save(op);
					ops.add(op);
					
				}
			}
			order.setOrderProducts(ops);
			save(order);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
