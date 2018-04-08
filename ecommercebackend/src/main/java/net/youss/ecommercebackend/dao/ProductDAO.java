package net.youss.ecommercebackend.dao;

import java.util.List;

import net.youss.ecommercebackend.dto.Product;

public interface ProductDAO {
    //crud
	boolean add(Product product);
	Product get(int productId);
	boolean update(Product product);
	boolean delete(Product product);
    //business
	List<Product> list();
	List<Product> listAllActiveProds();
	List<Product> listAllActiveProdsByCat(int categoryId);
	List<Product> getLatestActiveProds(int count);
}
