package cn.wb.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import cn.wb.service.OrderService;
import cn.wb.service.ProductService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
	// =============== ModelDriven的支持 ==================

	protected T model;

	public BaseAction() {
		try {
			// 通过反射获取model的真实类型
			ParameterizedType pt = (ParameterizedType) this.getClass()
					.getGenericSuperclass();
			Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
			// 通过反射创建model的实例
			model = clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public T getModel() {
		return model;
	}

	// -------------------常用传值-------------------
	protected List<Integer> ids;
	protected Object resultBean;
	protected List resultList;

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public Object getResultBean() {
		return resultBean;
	}

	public void setResultBean(Object resultBean) {
		this.resultBean = resultBean;
	}

	public List getResultList() {
		return resultList;
	}

	public void setResultList(List resultList) {
		this.resultList = resultList;
	}

	// ----------------常用常量-------------------
	protected static final String list = "list";
	protected static final String editUI = "editUI";
	protected static final String tolist = "tolist";

	// =================service引入====================
	@Resource
	protected OrderService orderService;
	@Resource
	protected ProductService productService;

}
