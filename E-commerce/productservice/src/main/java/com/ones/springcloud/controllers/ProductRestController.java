package com.ones.springcloud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ones.springcloud.dto.Coupon;
import com.ones.springcloud.models.Product;
import com.ones.springcloud.repos.ProductRepo;

@RestController
@RequestMapping("productapi")
public class ProductRestController {
	@Autowired
	ProductRepo repo;
	@Autowired
	RestTemplate restTemplate;
	@RequestMapping(value="/product",method=RequestMethod.POST)
	public Product create(@RequestBody Product product) {
		Coupon[] coupon = restTemplate.getForObject("http://127.0.0.1:8080/couponapi/coupon/"+product.getCouponCode(), Coupon[].class);
		product.setPrice(product.getPrice().subtract(coupon[0].getDiscount()));
		return repo.save( product);
	}
	
	
	@RequestMapping(value="/product/{name}",method=RequestMethod.GET)
	public Product getProdut(@PathVariable String name) {
		
		
		return repo.findByName(name);
	}

}
