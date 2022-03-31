package com.app.pojos;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="booking_details")
public class Booking extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User userId;
	@NotNull(message = "booking date cannot be null")
	private Date bookingDate;
	@NotNull(message = "booking time cannot be null")
	private Time bookingTime;
	@NotNull(message = "amount cannot be null")
	private double amount;
	@ManyToOne
	@JoinColumn(name = "show_id", nullable = false)
	private Show showId;
	@NotNull(message = "number of seats cannot be null")
	private int numberOfSeats;

	public Booking(User userId, @NotNull(message = "booking date cannot be null") Date bookingDate,
			@NotNull(message = "booking time cannot be null") Time bookingTime,
			@NotNull(message = "amount cannot be null") double amount, Show showId,
			@NotNull(message = "number of seats cannot be null") int numberOfSeats) {
		super();
		this.userId = userId;
		this.bookingDate = bookingDate;
		this.bookingTime = bookingTime;
		this.amount = amount;
		this.showId = showId;
		this.numberOfSeats = numberOfSeats;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Time getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(Time bookingTime) {
		this.bookingTime = bookingTime;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Show getShowId() {
		return showId;
	}

	public void setShowId(Show showId) {
		this.showId = showId;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public Booking() {
		super();
	}

}
