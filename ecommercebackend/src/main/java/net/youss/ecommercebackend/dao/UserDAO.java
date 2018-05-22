/**
 * 
 */
package net.youss.ecommercebackend.dao;


/**
 * @author youss
 *
 */
import java.util.List;

import net.youss.ecommercebackend.dto.Address;
import net.youss.ecommercebackend.dto.Cart;
import net.youss.ecommercebackend.dto.User;



public interface UserDAO {
	
	boolean addUser(User user);
	User getByEmail(String email);
	boolean addAddress(Address address);
	
	//alternatives pour eviter les baisses de perfs web => id plutot qu'objet
	//Address getBillingAddress(int userId);
	//List<Address> listShippingAddresses(int userId);
	
	Address getBillingAddress(User user);
	List<Address> listShippingAddresses(User user);
	boolean updateCart(Cart cart);
	boolean addCart(Cart cart);

}
