package com.ones.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ones.springcloud.models.Product;

public interface ProductRepo extends JpaRepository<Product,Long> {

	Product findByName(String name);

}
