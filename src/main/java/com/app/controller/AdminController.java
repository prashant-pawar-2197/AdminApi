package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.AdminSqlExcep;
import com.app.pojos.TheatreDetails;
import com.app.service.IRegisterService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
		@Autowired
		private IRegisterService registerServ;
		
		@PostMapping("/addTheatre")
		private ResponseEntity<Object> addTheatre(@RequestBody @Valid TheatreDetails theatre) throws AdminSqlExcep {
			try {
				System.out.println("reached here");
				registerServ.addTheatre(theatre);
			} catch (AdminSqlExcep e) {
				throw new AdminSqlExcep("Error occured while adding"); 
			}
			return new ResponseEntity<Object>(theatre, HttpStatus.OK);
		}
		@DeleteMapping("/removeTheatre/{id}")
		private ResponseEntity<Object> removeTheatre(@PathVariable int id) throws AdminSqlExcep {
			registerServ.deleteTheatre(id);
			return new ResponseEntity<Object>("Delete Successful", HttpStatus.OK);
		}
		
}
