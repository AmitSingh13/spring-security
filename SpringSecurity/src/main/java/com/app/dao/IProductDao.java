package com.app.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.app.model.Product;
@Component
public interface IProductDao {
	public Integer saveProduct(Product product);
	public void deleteProduct(Integer id);
	public List<Product> getAllProduct();

}
