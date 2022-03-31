package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="booked_seats")
public class BookedSeats extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "seat_id")
	private Seat seatId;
	@Column(length = 40)
	@NotEmpty(message = "please enter the price")
	private String seat;
	@Override
	public String toString() {
		return "ReservedSeats [seatId=" + seatId + ", seat=" + seat + "]";
	}
	public Seat getSeatId() {
		return seatId;
	}
	public void setSeatId(Seat seatId) {
		this.seatId = seatId;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public BookedSeats(Seat seatId, @NotEmpty(message = "please enter the price") String seat) {
		super();
		this.seatId = seatId;
		this.seat = seat;
	}
	public BookedSeats() {
		super();
	}
	
	
	
	
	
	
}
