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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="seats")
@Getter
@Setter
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
	private Screen screen;
	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private SeatType seatType;
	@Override
	public String toString() {
		return "Seat [seatRow=" + seatRow + ", seatColumn=" + seatColumn + ", screen=" + screen + ", seatType="
				+ seatType + "]";
	}
	
	

	
	
	
}
