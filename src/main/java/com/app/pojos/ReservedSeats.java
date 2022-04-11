package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reserved_seats")
@Getter
@Setter
@NoArgsConstructor
public class ReservedSeats extends BaseEntity{
		private String seatNumber;
		@ManyToOne
		@JoinColumn(name = "show_id")
		private Show show;
		@ManyToOne
		@JoinColumn(name = "booking_id")
		private Booking booking;
		@Enumerated(EnumType.STRING)
		private SeatStatus status;
}
