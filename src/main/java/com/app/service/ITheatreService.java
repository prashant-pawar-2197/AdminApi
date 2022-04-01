package com.app.service;

import java.util.List;

import com.app.dto.TheatreDto;
import com.app.pojos.Screen;
import com.app.pojos.Seat;
import com.app.pojos.Show;
import com.app.pojos.Theatre;

public interface ITheatreService {
	Theatre addTheatre(Theatre theatre) ;
	void deleteTheatre(int id);
	Screen addScreen(Screen screen, int theatreId);
	Seat addSeat(Seat seat, int screenId);
	Show addShow(Show show, int theatreId);
	List<TheatreDto> getAllTheatres();
}
