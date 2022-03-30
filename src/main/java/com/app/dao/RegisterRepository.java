package com.app.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Register;

public interface RegisterRepository extends JpaRepository<Register, Integer>{
	Optional<Register> findByEmailAndPassword(String email, String password);
	
	Optional<Register> findByEmail(String email);
}
