package com.ones.springcloud.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ones.springcloud.models.Coupon;
import com.ones.springcloud.repo.CouponRepo;

@RestController
@RequestMapping("/couponapi")
public class CouponRestController {
	
	@Autowired
	CouponRepo repo;
	@RequestMapping(value="/coupon",method=RequestMethod.POST)
	public Coupon create(@RequestBody Coupon coupon) {
		
		return repo.save(coupon);
		
		
	}
	
	@RequestMapping(value="/coupon/{code}",method=RequestMethod.GET)
	public Coupon getCoupon(@PathVariable String code) {
		return repo.findByCode(code);
		
	}

}