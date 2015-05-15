package cn.wb.base;

import java.io.Serializable;
import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UserDetails;

public interface BaseDao<T> {
	

	/**
	 * 保存实体
	 * 
	 * @param entity
	 */
	Serializable save(T entity);

	/**
	 * 删除实体
	 * 
	 * @param id
	 */
	void delete(Integer id);

	/**
	 * 更新实体
	 * 
	 * @param entity
	 */
	void update(T entity);
	/**
	 * 保存或更新实体
	 * 
	 * @param entity
	 */
	void saveOrUpdate(T entity);

	/**
	 * 按id查询
	 * 
	 * @param id
	 * @return
	 */
	T getById(Integer id);

	/**
	 * 按id查询
	 * 
	 * @param ids
	 * @return
	 */
	List<T> getByIds(Integer[] ids);

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	List<T> findAll();
}
