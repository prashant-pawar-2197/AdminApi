package com.app.service;

import java.util.List;

import com.app.dto.OngoingShowDto;
import com.app.pojos.Show;

public interface IShowService {
	
	public Show addShow(Show show, int screenId, int theatreId, String movieId);
	//get all movies in particular theatre
	public List<OngoingShowDto> getAllShows(int theatreId); 
}
