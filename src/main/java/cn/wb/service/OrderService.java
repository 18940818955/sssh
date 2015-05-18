package cn.wb.service;

import java.util.List;

import cn.wb.base.BaseDao;
import cn.wb.domain.Order;

public interface OrderService extends BaseDao<Order>{

	void saveOrder(List<String> params, List<Integer> ids);

}
