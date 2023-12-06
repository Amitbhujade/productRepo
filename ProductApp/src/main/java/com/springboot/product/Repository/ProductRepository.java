package com.springboot.product.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.product.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
