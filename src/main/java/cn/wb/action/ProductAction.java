package cn.wb.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.wb.base.BaseAction;
import cn.wb.domain.Product;

@Controller
@Scope("prototype")
public class ProductAction extends BaseAction<Product>{
	public String list(){
		return list;
	}
}
