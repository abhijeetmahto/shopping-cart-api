package org.jsp.api.Service;

import java.util.List;
import java.util.Optional;

import org.jsp.api.Dao.MerchantDao;
import org.jsp.api.Dao.ProductDao;
import org.jsp.api.Dto.Merchant;
import org.jsp.api.Dto.Product;
import org.jsp.api.Dto.ResponseStructure;
import org.jsp.api.Exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ProductService {
	@Autowired
	private ProductDao dao;
	@Autowired
	private MerchantDao merchantDao;
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product, int mid) {
		ResponseStructure<Product> structure = new ResponseStructure<>();
		Optional<Merchant> recMerchant = merchantDao.findById(mid);
		if (recMerchant.isPresent()) {
			recMerchant.get().getProducts().add(product);
			product.setMerchant(recMerchant.get());
			dao.saveProduct(product);
			merchantDao.updateMerchant(recMerchant.get());
			structure.setBody(product);
			structure.setCode(HttpStatus.CREATED.value());
			structure.setMessage("Product added");
			return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product, int mid) {
		ResponseStructure<Product> structure = new ResponseStructure<>();
		Optional<Merchant> recMerchant = merchantDao.findById(mid);
		if (recMerchant.isPresent()) {
			recMerchant.get().getProducts().add(product);
			product.setMerchant(recMerchant.get());
			structure.setBody(dao.updateProduct(product));
			merchantDao.updateMerchant(recMerchant.get());
			structure.setCode(HttpStatus.ACCEPTED.value());
			structure.setMessage("Product Updated");
			return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Product>> findById(int id) {
		Optional<Product> recProduct = dao.findById(id);
		ResponseStructure<Product> structure = new ResponseStructure<>();
		if (recProduct.isPresent()) {
			structure.setBody(recProduct.get());
			structure.setMessage("Product Found");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<String>> deleteProduct(int id) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		Optional<Product> recProduct = dao.findById(id);
		if (recProduct.isPresent()) {
			dao.deleteProduct(id);
			structure.setMessage("Product deleted");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<List<Product>>> findProductsByMerchantId(int merchant_id) {
		ResponseStructure<List<Product>> structure = new ResponseStructure<>();
		structure.setBody(dao.findProductsByMerchantId(merchant_id));
		structure.setCode(HttpStatus.OK.value());
		structure.setMessage("Products loaded");
		return new ResponseEntity<ResponseStructure<List<Product>>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Product>>> findProductsByBrand(String brand) {
		ResponseStructure<List<Product>> structure = new ResponseStructure<>();
		structure.setBody(dao.findProductsByBrand(brand));
		structure.setMessage("The product Brand found");
		structure.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Product>>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Product>>> findProductsByCategory(String category) {
		ResponseStructure<List<Product>> structure = new ResponseStructure<>();
		structure.setBody(dao.findProductsByCategory(category));
		structure.setMessage("The product Brand found");
		structure.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Product>>>(structure, HttpStatus.OK);
	}
	
}
