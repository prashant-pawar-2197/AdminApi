package com.app.service;

import com.app.pojos.Screen;
import com.app.pojos.Seat;
import com.app.pojos.Theatre;

public interface IRegisterService {
	public Theatre addTheatre(Theatre theatre) ;
	public void deleteTheatre(int id);
	public Screen addScreen(Screen screen, int theatreId);
	public Seat addSeat(Seat seat, int screenId);

}
