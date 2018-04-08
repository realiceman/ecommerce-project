package net.youss.ecommercebackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.youss.ecommercebackend.dao.ProductDAO;
import net.youss.ecommercebackend.dto.Product;

public class ProductTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.youss.ecommercebackend");
		context.refresh();
		
		productDAO= (ProductDAO) context.getBean("productDAO");
		
	}

//	@Test
//	public void testCRUDProduct() {
//		product = new Product();
//		product.setName("oneProd2");
//		product.setBrand("youssBrand2");
//		product.setDescription("une description...");
//		product.setUnitPrice(200);
//		product.setActive(true);
//		product.setCategoryId(3);
//		product.setSupplierId(3);
//		
//		assertEquals("pb",true, productDAO.add(product));
//	}
//	@Test
//	public void testprodsByCat(){
//		
//	}
	
//	@Test
//	public void readUpdateCRUDProduct(){
//		product = productDAO.get(3);
//		product.setName("Google Pix");
//		assertEquals("pb",true, productDAO.update(product));
//	}
	
	@Test
	public void testListActiveProducts(){
		assertEquals("nookkk",6,productDAO.listAllActiveProds().size());
	}
	
	@Test
	public void testGetLatestActivePdts(){
		assertEquals("nok",3, productDAO.getLatestActiveProds(3).size());
	}
	
	@Test
	public void testListActivePdtsByCat() {
		assertEquals("nok",2, productDAO.listAllActiveProdsByCat(1).size());
	}
	
	@Test
	public void testLatestActivePdt() {
		assertEquals("nok",2, productDAO.getLatestActiveProds(2).size());
	}

}
