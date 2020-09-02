package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.model.Product;
@Service
public interface IProductService {
	public Integer saveProduct(Product product);
	public void deleteProduct(Integer id);
	public List<Product> getAllProduct();

}
