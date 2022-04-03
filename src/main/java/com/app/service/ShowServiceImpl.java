package com.app.service;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.MovieRepository;
import com.app.dao.ScreenRepository;
import com.app.dao.ShowRepository;
import com.app.dao.TheatreRepository;
import com.app.dto.OngoingShowDto;
import com.app.dto.UpdateShowDto;
import com.app.pojos.Movie;
import com.app.pojos.Screen;
import com.app.pojos.Show;
import com.app.pojos.Theatre;

@Service
@Transactional
public class ShowServiceImpl implements IShowService {
	@Autowired
	ShowRepository showRepo;
	@Autowired
	ScreenRepository screenRepo;
	@Autowired
	TheatreRepository theatreRepo;
	@Autowired
	MovieRepository movieRepo;
	@Override
	public Show addShow(Show show,int screenId, int theatreId ,String movieId) {
		// validation for adding show
		// 1.on the same screen show timing must not match
		// get all shows whose screen is same as (this) screen
		// find by id
		if (screenRepo.existsById(screenId) && theatreRepo.existsById(theatreId)) {
			Screen screen = screenRepo.findById(screenId).orElseThrow(()->new RuntimeException("screen not found"));
			show.setScreen(screen);
			Theatre theatre = theatreRepo.findById(theatreId).orElseThrow(()->new RuntimeException("Theatre not found"));
			theatre.addScreen(screen);
			Movie movie = movieRepo.findById(movieId).orElseThrow(()->new RuntimeException("Movie not found"));
			show.setMovie(movie);
			// see if the timing are free on that screen
			List<Show> shows = showRepo.findByScreen(screen);
			// show time must not match with any show
			
			//show timings
			Iterator itr = shows.iterator();
			while (itr.hasNext()) {
				Show temp = (Show) itr.next();
				if ((temp.getEndTime().isBefore(show.getStartTime()) || show.getEndTime().isAfter(temp.getStartTime())) 
						  && temp.getShowDate().isEqual(show.getShowDate())) {
					
					throw new RuntimeException("Show already exist at this timing");
				}
				
			}
			return showRepo.save(show);
		}else {
			throw new RuntimeException("Show did not mount");
		}
//		
	}
	@Override
	public List<OngoingShowDto> getAllShows(int theatreId) {
		List <OngoingShowDto> shows = showRepo.getAllShows(theatreId);
		if (shows.isEmpty()) {
			throw new RuntimeException("There are no current ongoing shows to display");
		}
		return shows;
	}
	@Override
	public UpdateShowDto getShowbyId(int showId) {
		return showRepo.getShowById(showId);
	}
	
	public int updateShow(UpdateShowDto show) {
		System.out.println("reached here");
		return showRepo.updateShow(show.getDiamondPrice(), show.getEndTime(), show.getGoldPrice(), show.getShowStatus().toString(), show.getSilverPrice(), show.getStartTime(), show.getShowDate(),show.getScreenId(), show.getId());
	}

}
