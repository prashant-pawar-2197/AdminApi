package com.app.pojos;

import java.sql.Date;
import java.sql.Time;
import java.text.Format;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
@Entity
@Table(name = "show_details")
@NoArgsConstructor
public class Show extends BaseEntity{
	
	@ManyToOne
	@JoinColumn(name = "theatre_id",nullable=false)
	private Theatre theatreId;
	@JsonFormat(pattern = "HH:mm:ss",shape=Shape.STRING)
	private LocalTime startTime;
	@JsonFormat(pattern = "HH:mm:ss",shape=Shape.STRING)
	private LocalTime endTime;
	@ManyToOne
	@JoinColumn(name = "movie_id",nullable = false)
	private Movie movieId;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ShowStatus showStatus;
	@ManyToOne
	@JoinColumn(name="screen_id", nullable=false)
	private Screen screen;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate showDate;
	

	public Show(Theatre theatreId,LocalTime startTime,
			 LocalTime endTime, Movie movieId, ShowStatus showStatus,
			Screen screen, LocalDate showDate) {
		super();
		this.theatreId = theatreId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.movieId = movieId;
		this.showStatus = showStatus;
		this.screen = screen;
		this.showDate = showDate;
		
	}

	public Show(LocalTime startTime, LocalTime endTime, ShowStatus showStatus, LocalDate showDate) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.showStatus = showStatus;
		this.showDate = showDate;
	}
	
	public Theatre getTheatreId() {
		return theatreId;
	}



	public void setTheatreId(Theatre theatreId) {
		this.theatreId = theatreId;
	}



	public LocalTime getStartTime() {
		System.out.println("in getter of show");
		return startTime;
	}



	public void setStartTime(LocalTime startTime) {
		System.out.println("in setter of show");
		this.startTime = startTime;
	}



	public  LocalTime getEndTime() {
		return endTime;
	}



	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}



	public Movie getMovieId() {
		return movieId;
	}



	public void setMovieId(Movie movieId) {
		this.movieId = movieId;
	}


	



	public ShowStatus getShowStatus() {
		return showStatus;
	}



	public void setShowStatus(ShowStatus showStatus) {
		this.showStatus = showStatus;
	}



	public Screen getScreen() {
		return screen;
	}



	public void setScreen(Screen screen) {
		this.screen = screen;
	}


	public  LocalDate getShowDate() {
		return showDate;
	}

	public void setShowDate (LocalDate showDate) {
		this.showDate = showDate;
	}

	@Override
	public String toString() {
		return "Show [theatreId=" + theatreId + ", startTime=" + startTime + ", endTime=" + endTime + ", movieId="
				+ movieId + ", showStatus=" + showStatus + ", showDate=" + showDate + "]";
	}




	


	

	

}
