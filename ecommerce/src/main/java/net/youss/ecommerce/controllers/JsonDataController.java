package net.youss.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.youss.ecommercebackend.dao.ProductDAO;
import net.youss.ecommercebackend.dto.Product;

@RestController
@RequestMapping("/json/data")
public class JsonDataController {
	
	@Autowired
	private ProductDAO productdao;
	
	@RequestMapping("/all/products")
	public List<Product> getAllProducts(){
		return productdao.listAllActiveProds();
	}
	
	
	@RequestMapping("/category/{id}/products")
	public List<Product> getAllProductsByCat(@PathVariable int id){
		return productdao.listAllActiveProdsByCat(id);
	}

}
