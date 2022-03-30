package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.dao.TheatreDao;
import com.app.exception.AdminSqlExcep;
import com.app.pojos.TheatreDetails;

@Service
@Transactional
public class RegisterService implements IRegisterService {
	@Autowired
	private TheatreDao theatreDao;
	
	@Override
	public ResponseEntity<Object> addTheatre(TheatreDetails theatre) throws AdminSqlExcep {
		if(theatreDao.save(theatre)==null) {
			throw new AdminSqlExcep("Theatre add failed");
		}
		else
		return new ResponseEntity<Object>(theatre, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> deleteTheatre(int id) throws AdminSqlExcep {
		theatreDao.deleteById(id);
		return new ResponseEntity<Object>("Deleted Successfully", HttpStatus.OK);
	}

}
