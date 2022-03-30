package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ScreenRepository;
import com.app.dao.SeatRepository;
import com.app.dao.ShowRepository;
import com.app.dao.TheatreRepository;
import com.app.exception.AdminSqlExcep;
import com.app.pojos.Screen;
import com.app.pojos.Seat;
import com.app.pojos.Show;
import com.app.pojos.Theatre;

@Service
@Transactional
public class RegisterServiceImpl implements IRegisterService {
	@Autowired
	private TheatreRepository theatreRepo;
	@Autowired
	private ScreenRepository screenRepo;
	@Autowired
	private SeatRepository seatRepo;
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
		throw new AdminSqlExcep("Theatre deletion failed, no theatre present with ID: " + id);
	}

	@Override
	public Screen addScreen(Screen screen, int theatreId) {
		if(theatreRepo.existsById(theatreId)) {
			screen.setTheatreId(theatreRepo.findById(theatreId).orElseThrow(() -> new AdminSqlExcep("theatre not found")));  
			return screenRepo.save(screen);
		}
		throw new AdminSqlExcep("adding screens has failed");
	}

	@Override
	public Seat addSeat(Seat seat, int screenId) {
		if(screenRepo.existsById(screenId)) {
			seat.setScreenId(screenRepo.findById(screenId).orElseThrow(() -> new AdminSqlExcep("screen not found")));
			return seatRepo.save(seat);
		}
			
		throw new AdminSqlExcep("adding seats has failed");
	}

	@Override
	public Show addShow(Show show, int theatreId) {
		if(theatreRepo.existsById(theatreId)) {
			show.setTheatreId(theatreRepo.findById(theatreId).orElseThrow(() -> new AdminSqlExcep("theatre not found")));  
			return showRepo.save(show);
		}
		throw new AdminSqlExcep("adding show has failed");
	}
	
	

}
