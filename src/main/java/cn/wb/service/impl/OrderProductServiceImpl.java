package cn.wb.service.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.wb.base.BaseDaoImpl;
import cn.wb.domain.OrderProduct;
import cn.wb.service.OrderProductService;
@Transactional
@Repository
public class OrderProductServiceImpl extends BaseDaoImpl<OrderProduct>
		implements OrderProductService {

}
