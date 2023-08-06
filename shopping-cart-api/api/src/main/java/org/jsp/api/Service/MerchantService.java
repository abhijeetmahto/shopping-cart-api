package org.jsp.api.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Optional;

import org.jsp.api.Dao.MerchantDao;
import org.jsp.api.Dto.EmailConfiguration;
import org.jsp.api.Dto.Merchant;
import org.jsp.api.Dto.ResponseStructure;
import org.jsp.api.Exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class MerchantService {
	@Autowired
	private MerchantDao dao;
	@Autowired
	private EmailConfiguration configuration;
	@Autowired
	private ShoppingCartMailService mailService;
	@Autowired
	private GenerateLinkService service;
	public ResponseEntity<ResponseStructure<Merchant>> saveMerchant(Merchant merchant,HttpServletRequest request){
		ResponseStructure<Merchant> structure = new ResponseStructure<Merchant>();
		structure.setMessage("Merchant Registered Successfully");
		structure.setBody(dao.saveMerchant(merchant));
		structure.setCode(HttpStatus.CREATED.value());
		
		configuration.setSubject("Registration Successful");
		dao.saveMerchant(merchant);
		HashMap<String, String> map = new LinkedHashMap<>();
		map.put("email",merchant.getEmail());
		map.put("name", merchant.getName());
		configuration.setText("Hello Mr."+merchant.getName()+" You have successfully initiated the registration for Merchant. Click here to verify "+service.getVerificationLink(request,merchant));
		configuration.setUser(map);
		mailService.sendMail(configuration);
		return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<String>> verifyMerchant(String token){
		ResponseStructure<String> structure = new ResponseStructure<>();
		Merchant merchant = dao.verifyMerchant(token);
		if(merchant!=null) {
			merchant.setToken(null);
			merchant.setStatus("Active");
			dao.updateMerchant(merchant);
			structure.setBody("Your Account is Activated");
			structure.setMessage("Merchant is Verified");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.OK);
		}
		structure.setBody("Account is not Activated");
		structure.setMessage("Invalid Token");
		structure.setCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<ResponseStructure<String>> sendResetPasswordLink(String email, HttpServletRequest request) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		Merchant merchant = dao.findMerchantByEmail(email);
		if (merchant != null) {
			HashMap<String, String> map = new LinkedHashMap<>();
			map.put("email", merchant.getEmail());
			map.put("name", merchant.getName());
			configuration.setSubject("Reset Password");
			configuration.setUser(map);
			configuration.setText("Hello Mr." + merchant.getName()
					+ "You have requested for Password change please click on the following link to reset your password"
					+ "please click on the link " + service.getResetPasswordLink(request, merchant));
			mailService.sendMail(configuration);
			structure.setBody("Reset Password Link sent to email");
			structure.setCode(HttpStatus.ACCEPTED.value());
			structure.setMessage("Mail sent to merchant");
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.ACCEPTED);
		}
		structure.setBody("Please register to continue");
		structure.setCode(HttpStatus.NOT_ACCEPTABLE.value());
		structure.setMessage("No Merchant found with the email id");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_ACCEPTABLE);
	}

	public ResponseEntity<ResponseStructure<Merchant>> verifyMerchant(String email, String password) {
		Optional<Merchant> recUser = dao.verifyMerchant(email, password);
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		if (recUser.isPresent()) {
			structure.setBody(recUser.get());
			structure.setMessage("User Found");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Merchant>> updateMerchant(Merchant merchant) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		structure.setBody(dao.updateMerchant(merchant));
		structure.setCode(HttpStatus.ACCEPTED.value());
		structure.setMessage("Merchant Updated");
		return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.ACCEPTED);
	}
}
