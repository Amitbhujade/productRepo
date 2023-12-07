package com.springboot.product.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springboot.product.Model.Customer;
import com.springboot.product.Model.Product;
import com.springboot.product.Service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@Autowired
	RestTemplate restTemplate;
		
	@GetMapping(value="/product")
	public ResponseEntity<List<Product>> getProducts(){
		
		return new ResponseEntity<>(productService.getAllProduct(),HttpStatus.OK);
	}
	
	
	@PostMapping(value="/product")
	public ResponseEntity<List<Product>> createProduct(@RequestBody Product product){	
		return new ResponseEntity<>(productService.addProduct(product),HttpStatus.CREATED);
	}
	
	@DeleteMapping(value="/product/{id}")
	public ResponseEntity<List<Product>> deleteProduct(@PathVariable int id){ 
		return new ResponseEntity<>(productService.deleteProduct(id),HttpStatus.OK);
	}
	
	@PutMapping(value="/product/{id}")
	public ResponseEntity<List<Product>> updateProduct(@PathVariable("id") int id, @RequestBody Product product){
		return new ResponseEntity<>(productService.updateProduct(id, product),HttpStatus.OK);
	}
	
	
	  @GetMapping("/template/customer")
	    public String getCustomerList() {
	        HttpHeaders headers = new HttpHeaders();
	        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	        HttpEntity<String> entity = new HttpEntity<>(headers);

	        return restTemplate.exchange("http://localhost:8080/customer", HttpMethod.GET, entity, String.class).getBody();
	    }
	  
	  @RequestMapping(value = "/template/customer", method = RequestMethod.POST)
	   public String createCustomer(@RequestBody Customer customer) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Customer> entity = new HttpEntity<Customer>(customer,headers);
	      
	      return restTemplate.exchange(
	         "http://localhost:8080/customer", HttpMethod.POST, entity, String.class).getBody();
	   }
	  

	   @RequestMapping(value = "/template/customer/{id}", method = RequestMethod.PUT)
	   public String updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Customer> entity = new HttpEntity<Customer>(customer,headers);
	      
	      return restTemplate.exchange(
	         "http://localhost:8080/customer/"+id, HttpMethod.PUT, entity, String.class).getBody();
	   }
	   

	   @RequestMapping(value = "/template/customer/{id}", method = RequestMethod.DELETE)
	   public String deleteCustomer(@PathVariable ("id") int id) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Customer> entity = new HttpEntity<Customer>(headers);
	      
	      return restTemplate.exchange(
	         "http://localhost:8080/customer/"+id, HttpMethod.DELETE, entity, String.class).getBody();
	   }
	   
	
}
