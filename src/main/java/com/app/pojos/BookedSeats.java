package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="booked_seats")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
	
	
	
}
