package org.jsp.api.Dao;

import java.util.Optional;

import org.jsp.api.Dto.Merchant;
import org.jsp.api.Repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class MerchantDao {
	@Autowired
	private MerchantRepository repository;
	public Merchant saveMerchant(Merchant merchant) {
		return repository.save(merchant);
	}
	public Merchant updateMerchant(Merchant merchant) {
		return repository.save(merchant);
	}
	public Merchant verifyMerchant(String token) {
		return repository.findMerchantByToken(token);
	}
	public Merchant findMerchantByEmail(String email) {
		return repository.findMerchantByEmail(email);
	}
	public Optional<Merchant> verifyMerchant(String email,String password){
		return repository.verifyMerchant(email, password);
	}
	public Optional<Merchant> findById(int id) {
		return repository.findMerchantById(id);
	}
}
