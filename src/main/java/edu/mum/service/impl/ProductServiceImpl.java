package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.mum.aspect.annotation.Logging;
import edu.mum.domain.Product;
import edu.mum.rest.service.ProductRestService;
import edu.mum.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
 	@Autowired
 	@Qualifier("MVC")
	private ProductRestService productRestService;

	public List<Product> findAll() {
		return productRestService.findAll();
	}

 
	@Logging
 	public void addProduct(Product product) {
 		productRestService.save(product);
	}
	
	public Product findOne(long productID) {
		return productRestService.findOne(productID);
	}

 

}
