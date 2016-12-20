package edu.mum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.domain.Product;
import edu.mum.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
 	@RequestMapping({"","/all"})
	public String list(Model model) {
		model.addAttribute("products", productService.findAll());
		return "products";
	}
	
 	@RequestMapping("/{id}")
	public String getProductById(Model model, @PathVariable("id") Long productId) {

		Product product = productService.findOne(productId);
		model.addAttribute("product", product);
		return "product";
	}

	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewProductForm(@ModelAttribute("newProduct") Product newProduct) {
	   return "addProduct";
	}
	   
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") @Valid Product productToBeAdded, BindingResult result) {
		if(result.hasErrors()) {
			return "addProduct";
		}

 //		try {
			productService.addProduct(productToBeAdded);
//		} catch (Exception up) {
//	      System.out.println("Transaction Failed!!!");
 
	//	}
		
	   	return "redirect:/products";
	}
	
   
}
