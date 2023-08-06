package org.jsp.api.Dao;

import java.util.Optional;

import org.jsp.api.Dto.User;
import org.jsp.api.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	private UserRepository repository;

	public User saveUser(User user) {
		return repository.save(user);
	}

	public User updateUser(User user) {
		return repository.save(user);
	}

	public User verifyUser(String token) {
		return repository.findUserByToken(token);
	}

	public User findUserByEmail(String email) {
		return repository.findUserByEmail(email);
	}

	public Optional<User> verifyUser(String email, String password) {
		return repository.verifyUser(email, password);
	}
}
