package com.app.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.app.dto.OngoingShowDto;
import com.app.dto.ShowTimeDto;
import com.app.dto.UpdateShowDto;
import com.app.pojos.Show;

public interface IShowService {
	
	public Show addShow(Show show, int screenId, int theatreId, String movieId);
	//get all movies in particular theatre
	public List<OngoingShowDto> getAllShows(int theatreId); 
	
	//to update a show details
	
	public UpdateShowDto getShowbyId(int showId);
	public int updateShow(UpdateShowDto show);
	public int deleteShow(int id);
	public List<Show> getShowByCity(String city, String movieId);
	public List<ShowTimeDto> getShowsByDate( LocalDate date, String city,String movieId );
	public List<OngoingShowDto> getAllShowsByTheatre(int theatreId,LocalDate showDate);

}
