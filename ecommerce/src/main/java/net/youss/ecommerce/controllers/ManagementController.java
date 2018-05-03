package net.youss.ecommerce.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import net.youss.ecommerce.utils.FileUploadUtility;
import net.youss.ecommerce.validators.ProductValidator;
import net.youss.ecommercebackend.dao.ICategoryDAO;
import net.youss.ecommercebackend.dao.ProductDAO;
import net.youss.ecommercebackend.dto.Category;
import net.youss.ecommercebackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	public static  Logger logger = LogManager.getLogger(ManagementController.class);
	
	@Autowired
	private ICategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation", required=false) String operation) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage products");
		Product nProduct = new Product();
		
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		mv.addObject("product", nProduct);
		
		if(operation!=null) {
			if(operation.equals("product")) {
				mv.addObject("message", "Product submitted successfully!");
			}
		}
		return mv;
	}
	
	
	@RequestMapping(value="{id}/product",method=RequestMethod.GET)
	public ModelAndView showEditProduct(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage products");
		Product editProduct = productDAO.get(id);
		
		mv.addObject("product", editProduct);
		
		return mv;
	}
	
	
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product")Product mProduct, BindingResult br, Model model, 
			HttpServletRequest request) {
		if(mProduct.getId()==0) {
		  new ProductValidator().validate(mProduct, br);
		}else {
			if(!mProduct.getFile().getOriginalFilename().equals("")) {
				 new ProductValidator().validate(mProduct, br);
			}
		}
		//if any errors
		if(br.hasErrors()) {
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage products");
			model.addAttribute("message", "Validation failed for product submission!!");
			return "page";
		}
		
		logger.info(mProduct.toString());
		if(mProduct.getId()==0) { //if new product
		    productDAO.add(mProduct);
		}else {                   //if edit product  
			productDAO.update(mProduct);
		}
		
		if(!(mProduct.getFile().getOriginalFilename().equals(""))) {
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}
		
		return "redirect:/manage/products?operation=product";
	}
	
	
	@RequestMapping(value="/product/{id}/activation", method=RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id){
		Product product = productDAO.get(id);
		boolean isActive = product.isActive();
		product.setActive(!isActive);
		productDAO.update(product);
		return (isActive)? "you have successfully deactivated the product with id "+product.getId(): 
			               "you have successfully activated the product with id "+product.getId()  ;
	}
	
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		return categoryDAO.list();
	}
	
}
