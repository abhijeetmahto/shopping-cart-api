package org.jsp.api.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Optional;

import org.jsp.api.Dao.UserDao;
import org.jsp.api.Dto.EmailConfiguration;
import org.jsp.api.Dto.ResponseStructure;
import org.jsp.api.Dto.User;
import org.jsp.api.Exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class UserService {
	@Autowired
	private UserDao dao;
	@Autowired
	private EmailConfiguration configuration;
	@Autowired
	private ShoppingCartMailService mailService;
	@Autowired
	private GenerateLinkService service;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user, HttpServletRequest request) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setBody(dao.saveUser(user));
		structure.setMessage("User Registration Succesfull");
		structure.setCode(HttpStatus.CREATED.value());
		configuration.setSubject("Registration succesful");
		HashMap<String, String> map = new LinkedHashMap<>();
		map.put("email", user.getEmail());
		map.put("name", user.getName());
		configuration.setText("Hello Mr." + user.getName()
				+ " You have succesfully initiated the registration for Our E commerce application"
				+ "please click on the link " + service.getVerificationLink(request, user));
		configuration.setUser(map);
		mailService.sendMail(configuration);
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<User>> updateUser(User user) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setBody(dao.updateUser(user));
		structure.setCode(HttpStatus.ACCEPTED.value());
		structure.setMessage("Merchant Updated");
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<String>> verifyUser(String token) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		User user = dao.verifyUser(token);
		if (user != null) {
			user.setToken(null);
			user.setStatus("Active");
			dao.updateUser(user);
			structure.setBody("Your Account is Activated");
			structure.setCode(HttpStatus.OK.value());
			structure.setMessage("User is verified");
			return new ResponseEntity<>(structure, HttpStatus.OK);
		}
		structure.setBody("Account is not activated");
		structure.setCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Invalid Token");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponseStructure<String>> sendResetPasswordLink(String email, HttpServletRequest request) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		User user = dao.findUserByEmail(email);
		if (user != null) {
			HashMap<String, String> map = new LinkedHashMap<>();
			map.put("email", user.getEmail());
			map.put("name", user.getName());
			configuration.setSubject("Reset Password");
			configuration.setUser(map);
			configuration.setText("Hello Mr." + user.getName()
					+ "You have requested for Password change please click on the following link to reset your password"
					+ "please click on the link " + service.getResetPasswordLink(request, user));
			mailService.sendMail(configuration);
			structure.setBody("Reset Password Link sent to email");
			structure.setCode(HttpStatus.ACCEPTED.value());
			structure.setMessage("Mail sent to user");
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.ACCEPTED);
		}
		structure.setBody("Please register to continue");
		structure.setCode(HttpStatus.NOT_ACCEPTABLE.value());
		structure.setMessage("No User found with the email id");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_ACCEPTABLE);
	}

	public ResponseEntity<ResponseStructure<User>> verifyUser(String email, String password) {
		Optional<User> recUser = dao.verifyUser(email, password);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (recUser.isPresent()) {
			structure.setBody(recUser.get());
			structure.setMessage("User Found");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
}
