package com.app.pojos;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "show_details")
@NoArgsConstructor
public class Show extends BaseEntity{
	
	@ManyToOne
	@JoinColumn(name = "theatre_id",nullable=false)
	private Theatre theatreId;
	@NotNull(message = "Please Enter Start Time")
	private Time startTime;
	@NotNull(message = "Please Enter End Time")
	private Time endTime;
	@ManyToOne
	@JoinColumn(name = "movie_id",nullable = false)
	private Movie movieId;
	@OneToMany(mappedBy = "showId", cascade=CascadeType.ALL, orphanRemoval = true)
	private List<Screen> screens = new ArrayList<>();
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ShowStatus showStatus;
	


	public Theatre getTheatreId() {
		return theatreId;
	}



	public void setTheatreId(Theatre theatreId) {
		this.theatreId = theatreId;
	}



	public Time getStartTime() {
		return startTime;
	}



	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}



	public Time getEndTime() {
		return endTime;
	}



	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}



	public Movie getMovieId() {
		return movieId;
	}



	public void setMovieId(Movie movieId) {
		this.movieId = movieId;
	}


	@Override
	public String toString() {
		return "Show [theatreId=" + theatreId + ", startTime=" + startTime + ", endTime=" + endTime + ", movieId="
				+ movieId + ", screens=" + screens + ", showStatus=" + showStatus + "]";
	}

	

}
