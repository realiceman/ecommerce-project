package net.youss.ecommercebackend.dao;

import java.util.List;

import net.youss.ecommercebackend.dto.Category;

public interface ICategoryDAO {

	List<Category> list();
	Category get(int id);
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
}
