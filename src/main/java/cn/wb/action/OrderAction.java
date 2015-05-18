package cn.wb.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.wb.base.BaseAction;
import cn.wb.domain.Order;

@Controller
@Scope("prototype")
public class OrderAction extends BaseAction<Order> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5861536015861245586L;
	private List params;

	public List getParams() {
		return params;
	}

	public void setParams(List params) {
		this.params = params;
	}

	public String list() throws Exception {
		resultList = orderService.findAll();
		return list;
	}

	public String addUI() throws Exception {
		resultList = productService.findAll();
		return "addUI";
	}

	public String add() throws Exception {
		orderService.saveOrder(params, ids);
		return tolist;
	}
}
