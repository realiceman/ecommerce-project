package net.youss.ecommercebackend.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.youss.ecommercebackend.dao.ICategoryDAO;
import net.youss.ecommercebackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static ICategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.youss.ecommercebackend");
		context.refresh();
		
		categoryDAO = (ICategoryDAO) context.getBean("categoryDAO");
	}
	
//	@Test
//	public void testAddCategory() {
//		category = new Category();
//		category.setName("smartwatch");
//		category.setDescription("description for smartwatch");
//		category.setImageURL("cat_10.png");
//		category.setActive(true);
//		
//		assertThat(categoryDAO.add(category), is(true));
//	}
	
//	@Test
//	public void testGetCategory() {
//		category = categoryDAO.get(3);
//		assertThat(category.getName(), is("Mobile"));
//	}
	
//	@Test
//	public void testUpdateCategory() {
//		category = categoryDAO.get(3);
//		category.setDescription("new description for mobile");
//		
//		assertThat(categoryDAO.update(category), is(true));
//	}
	
//	@Test
//	public void testDeleteCategory() {
//		category = categoryDAO.get(3);
//		
//		
//		assertThat(categoryDAO.delete(category), is(true));
//	}
	
//	@Test
//	public void testListCategory() {
//		assertThat(categoryDAO.list().size(), is(3));
//	}
	
	@Test
	public void testCrudCat() {
		category = new Category();
		category.setName("Consoles");
		category.setDescription("description for consoles");
		category.setImageURL("cat_11.png");
		category.setActive(true);
		
		assertThat(categoryDAO.add(category), is(true));
		
		category = new Category();
		category.setName("SmartTV");
		category.setDescription("description for SmartTV");
		category.setImageURL("cat_11.png");
		category.setActive(true);
		
		assertThat(categoryDAO.add(category), is(true));
		
		category = categoryDAO.get(3);
		category.setDescription("new description for MOBILES");
		
		assertThat(categoryDAO.update(category), is(true));
		
		assertThat(categoryDAO.delete(category), is(true));
		assertThat(categoryDAO.list().size(), is(5));
	}

}
