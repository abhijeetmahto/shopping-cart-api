package org.jsp.api.Controller;

import java.util.List;

import org.jsp.api.Dto.Product;
import org.jsp.api.Dto.ResponseStructure;
import org.jsp.api.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ProductController {
	@Autowired
	private ProductService service;

	@PostMapping("/products/{id}")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product, @PathVariable int id) {
		return service.saveProduct(product, id);
	}

	@PutMapping("/products/{id}")
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product,
			@PathVariable int id) {
		return service.updateProduct(product, id);
	}

	@GetMapping("/products/{merchant_id}")
	public ResponseEntity<ResponseStructure<List<Product>>> findById(@PathVariable int merchant_id) {
		return service.findProductsByMerchantId(merchant_id);
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}

	@GetMapping("/products/byBrand/{brand}")
	public ResponseEntity<ResponseStructure<List<Product>>> findProductsByBrand(@PathVariable String brand) {
		return service.findProductsByBrand(brand);
	}

	@GetMapping("/products/byCategory/{category}")
	public ResponseEntity<ResponseStructure<List<Product>>> findProductsByCategory(@PathVariable String category) {
		return service.findProductsByBrand(category);
	}
}
