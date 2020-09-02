package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Product;
import com.app.service.IProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private IProductService service;
	
	@RequestMapping("/register")
	public String showPage(ModelMap map)
	{
		map.addAttribute("product", new Product());
		return "ProductRegister";
		
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveProduct(@ModelAttribute Product product,ModelMap map)
	{
		Integer id=service.saveProduct(product);
		map.addAttribute("message","product "+id+" is successfully saved");
		map.addAttribute("product", new Product());
		return "ProductRegister.jsp";
	}
	@RequestMapping("/list")
	public String getAll(ModelMap map)
	{
		List<Product> allProduct = service.getAllProduct();
		map.addAttribute("list", allProduct);
		return "ProductData";
		
		
	}
	@RequestMapping("/delete")
	public String deleteProduct(@RequestParam Integer id,ModelMap map)
	{
		service.deleteProduct(id);
		map.addAttribute("message","product "+id+" is successfully deleted");
		List<Product> allProduct = service.getAllProduct();
		map.addAttribute("list", allProduct);
		return "ProductData";
		
	}

}
