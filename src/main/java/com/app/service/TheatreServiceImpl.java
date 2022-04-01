package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ScreenRepository;
import com.app.dao.ShowRepository;
import com.app.dao.TheatreRepository;
import com.app.dto.TheatreDto;
import com.app.exception.AdminSqlExcep;
import com.app.pojos.Screen;
import com.app.pojos.Show;
import com.app.pojos.Theatre;

@Service
@Transactional
public class TheatreServiceImpl implements ITheatreService {
	@Autowired
	private TheatreRepository theatreRepo;
	@Autowired
	private ScreenRepository screenRepo;
	@Autowired
	private ShowRepository showRepo;
	
	
	@Override
	public Theatre addTheatre(Theatre theatre) {
		return theatreRepo.save(theatre);
	}

	@Override
	public void deleteTheatre(int id)  {
		if(theatreRepo.existsById(id))
			theatreRepo.deleteById(id);
		else
			throw new AdminSqlExcep("Theatre deletion failed, no theatre present with ID: " + id);
	}

	@Override
	public Screen addScreen(Screen screen, int theatreId) {
		if(theatreRepo.existsById(theatreId)) {
			screen.setTheatre(theatreRepo.findById(theatreId).orElseThrow(() -> new AdminSqlExcep("theatre not found")));  
			return screenRepo.save(screen);
		}
		throw new AdminSqlExcep("adding screens has failed");
	}



	@Override
	public Show addShow(Show show, int theatreId) {
		if(theatreRepo.existsById(theatreId)) {
			show.setTheatre(theatreRepo.findById(theatreId).orElseThrow(() -> new AdminSqlExcep("theatre not found")));  
			return showRepo.save(show);
		}
		throw new AdminSqlExcep("adding show has failed");
	}
	
	@Override
	public List<TheatreDto> getAllTheatres(){
		return theatreRepo.findAllTheatres();
	}
	
	

}
