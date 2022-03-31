package com.app.service;

import java.util.List;

import com.app.dto.TheatreDto;
import com.app.pojos.Screen;
import com.app.pojos.Seat;
import com.app.pojos.Show;
import com.app.pojos.Theatre;

public interface ITheatreService {
	public Theatre addTheatre(Theatre theatre) ;
	public void deleteTheatre(int id);
	public Screen addScreen(Screen screen, int theatreId);
	public Seat addSeat(Seat seat, int screenId);
	public Show addShow(Show show, int theatreId);
	public List<TheatreDto> getAllTheatres();
}
