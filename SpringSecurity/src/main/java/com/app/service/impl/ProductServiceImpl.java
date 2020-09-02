package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IProductDao;
import com.app.model.Product;
import com.app.service.IProductService;
@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	private IProductDao dao;
	@Transactional
	@Override
	public Integer saveProduct(Product product) {
		
		return dao.saveProduct(product);
	}
	@Transactional
	@Override
	public void deleteProduct(Integer id) {
		dao.deleteProduct(id);
		
	}
	@Transactional(readOnly=true)
	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return dao.getAllProduct();
	}

}
