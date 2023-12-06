package com.springboot.product.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.product.Model.Product;
import com.springboot.product.Repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	List<Product> product = new ArrayList<>();
	
	public List<Product> getAllProduct()
	{
		return productRepository.findAll();
	}
	
	public List<Product> addProduct(Product product)
	{
		productRepository.save(product);
		return getAllProduct();
	}
	
	public List<Product> updateProduct(int id,Product updatedProduct)
	{
		//if(!productRepository.existsById(id)) throw new CustomerNotFoundException();
		 Product existingProduct = productRepository.findById(id).orElse(null);
		 
		    if (existingProduct!=null) {
		    	existingProduct.setProductId(updatedProduct.getProductId());
		    	existingProduct.setProductName(updatedProduct.getProductName());
		    	existingProduct.setProductQuantity(updatedProduct.getProductQuantity());
		    	productRepository.save(existingProduct);
		    }
		    return product;
		    }
	
	public List<Product> deleteProduct(int id)
	{
		Optional<Product> productToDelete = productRepository.findById(id);
		
		if(productToDelete.isPresent())
		{
			product.remove(productToDelete.get());
			productRepository.deleteById(id);
		}
		return product;
		
	}
}
