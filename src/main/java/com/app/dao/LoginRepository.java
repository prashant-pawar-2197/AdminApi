package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Login;

public interface LoginRepository extends JpaRepository<Login, Integer>{
	
}
