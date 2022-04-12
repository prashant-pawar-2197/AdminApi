package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByEmailAndPassword(String email, String password);
	
	Optional<User> findByEmail(String email);
	
	//letting the user update his profile
	@Modifying
	@Query("update User u set u.firstName=?1, u.lastName=?2, u.email=?3, u.phone=?4 where u.id=?5")
	void updateUserDetails(String firstName, String lastName, String email, String phone, int userId);
	

}
