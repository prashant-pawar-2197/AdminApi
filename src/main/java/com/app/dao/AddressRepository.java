package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{
	
	@Modifying
	@Query("update Address a set a.city=:?1, a.state=:?2, a.pincode=:?3 where a.user.id=?4")
	void updateUserAddress(String city, String state, String pincode, int userId);
	
}
