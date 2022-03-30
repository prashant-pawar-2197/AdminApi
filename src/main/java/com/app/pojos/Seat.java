package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.NoArgsConstructor;

@Entity
@Table(name="seats")

@NoArgsConstructor
public class Seat extends BaseEntity{
	
	@NotNull(message = "seat rows cannot be null")
	@Range(min = 1, max=8)
	private int seatRow;
	@NotNull(message = "seat columns cannot be null")
	@Range(min = 1, max=9)
	private int seatColumn;
	@ManyToOne
	@JoinColumn(name = "screen_id", nullable=false)
	private Screen screenId;
	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private SeatType seatType;
	
	
	
	@Override
	public String toString() {
		return "Seats [seatRow=" + seatRow + ", seatColumn=" + seatColumn + ", screenId=" + screenId + ", seatType="
				+ seatType + "]";
	}



	public int getSeatRow() {
		return seatRow;
	}



	public void setSeatRow(int seatRow) {
		this.seatRow = seatRow;
	}



	public int getSeatColumn() {
		return seatColumn;
	}



	public void setSeatColumn(int seatColumn) {
		this.seatColumn = seatColumn;
	}



	public Screen getScreenId() {
		return screenId;
	}



	public void setScreenId(Screen screenId) {
		this.screenId = screenId;
	}



	public SeatType getSeatType() {
		return seatType;
	}



	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}



	public Seat(@NotNull(message = "seat rows cannot be null") int seatRow,
			@NotNull(message = "seat columns cannot be null") int seatColumn, Screen screenId, SeatType seatType) {
		super();
		this.seatRow = seatRow;
		this.seatColumn = seatColumn;
		this.screenId = screenId;
		this.seatType = seatType;
	}
	
	
	
}
