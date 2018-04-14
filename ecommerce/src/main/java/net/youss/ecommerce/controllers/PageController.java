package net.youss.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.youss.ecommercebackend.dao.ICategoryDAO;
import net.youss.ecommercebackend.dao.ProductDAO;
import net.youss.ecommercebackend.dto.Category;
import net.youss.ecommercebackend.dto.Product;

@Controller
public class PageController {
	
	@Autowired
	private ICategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Home");
		//pass the category list
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome",true);
		return mv;
	}
	
	
	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout",true);
		return mv;
	}
	
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Contact");
		mv.addObject("userClickContact",true);
		return mv;
	}

	
	//load all the products
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","All products");
		//pass the category list
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClicAllProducts",true);
		return mv;
	}
	
	//load all the products based on cat
		@RequestMapping(value = "/show/category/{id}/products")
		public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
			ModelAndView mv = new ModelAndView("page");
			Category category = null;
			category = categoryDAO.get(id); 
			mv.addObject("title", category.getName());
			//pass the category list
			mv.addObject("categories", categoryDAO.list());
			//pass single category object
			mv.addObject("category", category);
			mv.addObject("userClicCategoryProducts",true);
			return mv;
		}
		
		
		//show one product
		@RequestMapping(value = "/show/{id}/product")
		public ModelAndView showSingleProduct(@PathVariable int id) {
			ModelAndView mv = new ModelAndView("page");
			Product product = productDAO.get(id);
			//update the view count
			product.setViews(product.getViews()+1);
			productDAO.update(product);
			//--------------------------
			mv.addObject("title",product.getName());
			mv.addObject("product", product);
			mv.addObject("userClickShowProduct",true);
			
			return mv;
		}
}
