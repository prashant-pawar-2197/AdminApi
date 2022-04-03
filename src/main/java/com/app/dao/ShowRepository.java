package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.dto.OngoingShowDto;
import com.app.pojos.Screen;
import com.app.pojos.Show;

public interface ShowRepository extends JpaRepository<Show, Integer>{
	//Query to find the shows on particular screen
	List<Show> findByScreen(Screen screen);
	
	//To get all movies in a theatre
	//Query to get all the movies in particular theatre
	// NATIVE QUERY ::
	//SELECT show_details.id, show_details.end_time,show_details.start_time,show_details.show_date,movie_details.title,movie_details.poster 
	//FROM show_details JOIN screen_details ON screen_details.id=show_details.screen_id 
	//JOIN movie_details ON movie_details.imdb_id=show_details.movie_id WHERE theatre_id=?1
	@Query(value ="select new com.app.dto.OngoingShowDto(s.id,s.endTime,s.startTime,s.showDate,m.title,m.poster) from Show s "
			+ "join s.movie m "
			+ "join s.screen sc "
			+ "where sc.theatre.id=:theatreId")
	List<OngoingShowDto> getAllShows(@Param(value="theatreId") int theatreId);
	

}
