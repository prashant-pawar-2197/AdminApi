package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="screen_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Screen extends BaseEntity{
	@NotNull(message = "screen number cannot be null")
	private int screenNumber;
	@ManyToOne
	@JoinColumn(name = "theatre_id", nullable = false)
	private Theatre theatreId;
	@ManyToOne
	@JoinColumn(name="show_id")
	private Show showId;
	@OneToMany(mappedBy = "screenId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Seat> seats = new ArrayList<>();
	
	
	
	
	public Screen() {
		super();
	}




	public Screen(@NotNull(message = "screen number cannot be null") int screenNumber, Theatre theatreId, Show showId,
			List<Seat> seats) {
		super();
		this.screenNumber = screenNumber;
		this.theatreId = theatreId;
		this.showId = showId;
		this.seats = seats;
	}




	public int getScreenNumber() {
		return screenNumber;
	}




	public void setScreenNumber(int screenNumber) {
		this.screenNumber = screenNumber;
	}




	public Theatre getTheatreId() {
		return theatreId;
	}




	public void setTheatreId(Theatre theatreId) {
		this.theatreId = theatreId;
	}




	public Show getShowId() {
		return showId;
	}




	public void setShowId(Show showId) {
		this.showId = showId;
	}




	public List<Seat> getSeats() {
		return seats;
	}




	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}




	@Override
	public String toString() {
		return "Screen [screenNumber=" + screenNumber + ", theatreId=" + theatreId + "]";
	}
	
	
}
