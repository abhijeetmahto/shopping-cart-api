package org.jsp.api.Controller;

import org.jsp.api.Dto.Merchant;
import org.jsp.api.Dto.ResponseStructure;
import org.jsp.api.Service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin("http://localhost:3000/")
public class MerchantController {
	@Autowired
	private MerchantService service;
	
	@PostMapping("/savemerchant")
	public ResponseEntity<ResponseStructure<Merchant>> saveMerchant(@RequestBody Merchant merchant,HttpServletRequest request){
		return service.saveMerchant(merchant,request);
	}
	
	@GetMapping("/savemerchant/verify-account")
	public ResponseEntity<ResponseStructure<String>> verifyMerchant(@RequestParam String token) {
		return service.verifyMerchant(token);
	}
	
	@GetMapping("/savemerchant/forgot-password")
	public ResponseEntity<ResponseStructure<String>> forgotPassword(@RequestParam String email,HttpServletRequest request) {
		return service.sendResetPasswordLink(email,request);
	}
	
	@PostMapping("/savemerchant/verify")
	public ResponseEntity<ResponseStructure<Merchant>> verifyUser(@RequestParam String email,
			@RequestParam String password) {
		return service.verifyMerchant(email, password);
	}

	@PutMapping("/savemerchant")
	public ResponseEntity<ResponseStructure<Merchant>> updateMerchant(@RequestBody Merchant merchant) {
		return service.updateMerchant(merchant);
	}

}
