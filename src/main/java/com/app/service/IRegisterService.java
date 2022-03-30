package com.app.service;

import org.springframework.http.ResponseEntity;

import com.app.exception.AdminSqlExcep;
import com.app.pojos.TheatreDetails;

public interface IRegisterService {
	public ResponseEntity<Object> addTheatre(TheatreDetails theatre) throws AdminSqlExcep;
	public ResponseEntity<Object> deleteTheatre(int id) throws AdminSqlExcep;
}
