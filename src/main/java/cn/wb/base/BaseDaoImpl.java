package cn.wb.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import cn.wb.domain.User;

import com.opensymphony.xwork2.ActionContext;

@Transactional
@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T> {
	@Resource
	private SessionFactory sessionFactory;

	private Class<T> clazz;

	public BaseDaoImpl() {
		// 使用反射技术得到T的真实类型
		ParameterizedType pt = (ParameterizedType) this.getClass()
				.getGenericSuperclass(); // 获取当前new的对象的 泛型的父类 类型
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0]; // 获取第一个类型参数的真实类型
		// System.out.println("clazz ---> " + clazz);
	}

	/**
	 * 获取当前可用的Session
	 * 
	 * @return
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public Serializable save(T entity) {
		return getSession().save(entity);
	}

	public void update(T entity) {
		getSession().update(entity);
	}

	public void delete(Integer id) {
		Object obj = getById(id);
		if (obj != null) {
			getSession().delete(obj);
		}
	}

	public T getById(Integer id) {
		if (id == null) {
			return null;
		} else {
			return (T) getSession().get(clazz, id);
		}
	}

	public List<T> getByIds(Integer[] ids) {
		if (ids == null || ids.length == 0) {
			return Collections.EMPTY_LIST;
		} else {
			return getSession().createQuery(//
					"FROM " + clazz.getSimpleName() + " WHERE id IN (:ids)")//
					.setParameterList("ids", ids)//
					.list();
		}
	}

	public List<T> findAll() {
		return getSession().createQuery(//
				"FROM " + clazz.getSimpleName())//
				.list();
	}

	

	public void saveOrUpdate(T entity) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(entity);
	}

}
