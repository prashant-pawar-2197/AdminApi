package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Register;

public interface RegisterRepository extends JpaRepository<Register, Integer>{
	Optional<Register> findByEmailAndPassword(String email, String password);
	
	Optional<Register> findByEmail(String email);
}
