package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ScreenRepository;

@Service
@Transactional
public class ScreenServiceImpl implements IScreenService {
	@Autowired
	private ScreenRepository screenRepo;
	
	@Override
	public int updateScreenStatus(String status, int id) {
		return screenRepo.updateScreenStatus(status, id);
	}

}
