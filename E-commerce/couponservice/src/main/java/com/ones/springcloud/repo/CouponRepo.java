package com.ones.springcloud.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import com.ones.springcloud.models.Coupon;

@Component
public  interface CouponRepo extends JpaRepository<Coupon, Long> {

	 Coupon findByCode(String code);

	
}
