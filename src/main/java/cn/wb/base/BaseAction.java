package cn.wb.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

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

	// =================service引入====================
	protected Object resultBean;
	protected Object param;
	protected Integer parentid;
	protected List resultList;

	protected static final String list = "list";
	protected static final String editUI = "editUI";
	protected static final String tolist = "tolist";

	public Object getParam() {
		return param;
	}

	public void setParam(Object param) {
		this.param = param;
	}

	public Object getResultBean() {
		return resultBean;
	}

	public void setResultBean(Object resultBean) {
		this.resultBean = resultBean;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public List getResultList() {
		return resultList;
	}

	public void setResultList(List resultList) {
		this.resultList = resultList;
	}

}
