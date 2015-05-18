package cn.wb.service.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.wb.base.BaseDaoImpl;
import cn.wb.domain.Product;
import cn.wb.service.ProductService;

@Repository
@Transactional
public class ProductServiceImpl extends BaseDaoImpl<Product> implements
		ProductService {

}
