package org.jsp.api.Repository;

import java.util.Optional;

import org.jsp.api.Dto.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MerchantRepository extends JpaRepository<Merchant, Integer>{
	@Query("select m from Merchant m where m.token=?1")
	public Merchant findMerchantByToken(String token);
	
	@Query("select m from Merchant m where m.email=?1")
	public Merchant findMerchantByEmail(String email);
	
	@Query("select m from Merchant m where m.email=?1 and m.password=?2")
	public Optional<Merchant> verifyMerchant(String email,String password);
	
	@Query("select m from Merchant m where m.id=?1")
	public Optional<Merchant> findMerchantById(int id);
}
