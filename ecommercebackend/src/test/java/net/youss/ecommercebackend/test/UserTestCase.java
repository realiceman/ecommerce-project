/**
 * 
 */
package net.youss.ecommercebackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.youss.ecommercebackend.dao.UserDAO;
import net.youss.ecommercebackend.dto.Address;
import net.youss.ecommercebackend.dto.Cart;
import net.youss.ecommercebackend.dto.User;



public class UserTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userdao;
	private User user = null;
	private Cart cart = null;
	private Address address = null;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.youss.ecommercebackend");
		context.refresh();
		
		userdao = (UserDAO) context.getBean("userDAO");
	}
	/*
	@Test
	public void testAdd() {
		user = new User();
		user.setFirstName("francois");
		user.setLastName("henzlick");
		user.setEmail("fh@gmx.com");
		user.setContactNumber("0665457898");
		user.setRole("USER");
		user.setPassword("123456");
		
		assertEquals("failed to add user!", true, userdao.addUser(user));
		
		address = new Address();
		address.setAddressLineOne("30 rue de lens");
		address.setAddressLineTwo("appartment 222");
		address.setCity("lens");
		address.setState("hauts de france");
		address.setCountry("France");
		address.setPostalCode("62000");
		address.setBilling(true);
		//link the user with the address using the user id
		address.setUserId(user.getId());
		assertEquals("failed to add user address!", true, userdao.addAddress(address));
		
		if(user.getRole().equals("USER")){
			//create a cart for this user
			cart = new Cart();
			cart.setUser(user);
			
			//add the cart
			assertEquals("failed to add cart!", true, userdao.addCart(cart));
			
			
			//add a shipping address for this user
			address = new Address();
			address.setAddressLineOne("30 rue de lens");
			address.setAddressLineTwo("appartment 222");
			address.setCity("lens");
			address.setState("hauts de france");
			address.setCountry("France");
			address.setPostalCode("62000");
			address.setShipping(true);
			//link it with user
			address.setUserId(user.getId());
			
			//add the shipping address
			assertEquals("failed to add shipping address!", true, userdao.addAddress(address));
			
			
		}
		
	}
	
	*/
	
/*	@Test
	public void testAdd() {
		user = new User();
		user.setFirstName("roxane");
		user.setLastName("hqrkati");
		user.setEmail("rh@gmx.com");
		user.setContactNumber("418254555");
		user.setRole("USER");
		user.setPassword("123456");
		
		
		if(user.getRole().equals("USER")){
			//create a cart for this user
			cart = new Cart();
			cart.setUser(user);
		    //attach cart
	        user.setCart(cart);
			
		}
		assertEquals("failed to add user!", true, userdao.addUser(user));
	}*/
	
	
/*	@Test
	public void testUpdateCart() {
		//fetch user by email
		user = userdao.getByEmail("fh@gmx.com");
		cart = user.getCart();
		cart.setGrandTotal(5555);
		cart.setCartLines(6);
		assertEquals("failed to update user!", true, userdao.updateCart(cart));
	}*/
	
	
//	@Test
//	public void testAddAddress() {
//		//add user
//		user = new User();
//		user.setFirstName("ilies");
//		user.setLastName("ben");
//		user.setEmail("ib@gmx.com");
//		user.setContactNumber("4186478963");
//		user.setRole("USER");
//		user.setPassword("123456");
//		
//		assertEquals("failed to add user!", true, userdao.addUser(user));
//		//add address for billing
//		address = new Address();
//		address.setAddressLineOne("254 rue laval");
//		address.setAddressLineTwo("appartment 272");
//		address.setCity("Quebec");
//		address.setState("Quebec");
//		address.setCountry("Canada");
//		address.setPostalCode("G1K 7E9");
//		address.setBilling(true);
//		//attach user to address
//		address.setUser(user);
//		
//		assertEquals("failed to add billing address!", true, userdao.addAddress(address));
//		//address for shipping
//		address = new Address();
//		address.setAddressLineOne("CGI");
//		address.setAddressLineTwo("418 blvd Charest");
//		address.setCity("Quebec");
//		address.setState("Quebec");
//		address.setCountry("Canada");
//		address.setPostalCode("G1K 4S7");
//		address.setShipping(true);
//		//attach user to address
//		address.setUser(user);
//		
//		assertEquals("failed to add shipping address!", true, userdao.addAddress(address));
//	}
	
//	@Test
//	public void testAddAddress() {
//		user = userdao.getByEmail("ib@gmx.com");
//		address = new Address();
//		address.setAddressLineOne("254 rue la gloire");
//		address.setAddressLineTwo("appartment 272");
//		address.setCity("Montreal");
//		address.setState("Quebec");
//		address.setCountry("Canada");
//		address.setPostalCode("G9K 2E9");
//		address.setBilling(true);
//		//attach user to address
//		address.setUser(user);
//		assertEquals("failed to add shipping address!", true, userdao.addAddress(address));
//	}
	
	@Test
	public void testGetAddresses() {
		user = userdao.getByEmail("ib@gmx.com");
		assertEquals("failed to fetch addresses!", 2, userdao.listShippingAddresses(user).size());
		assertEquals("failed to fetch addresses!", "Quebec", userdao.getBillingAddress(user).getCity());
		
	}
	
}
