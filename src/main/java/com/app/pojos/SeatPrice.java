package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="seat_price")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeatPrice extends BaseEntity {
	
	@OneToOne
	@JoinColumn(name="seat_id")
	@NotNull(message = "please enter the seat id")
	private Seat seat;
	@NotNull(message = "please enter the price")
	private int price;
	
	
	@Override
	public String toString() {
		return "SeatPrice [seat=" + seat + ", price=" + price + "]";
	}

	
	
}
