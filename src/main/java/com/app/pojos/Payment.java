package com.app.pojos;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "payment_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	@ManyToOne
	@JoinColumn(name = "booking_id", nullable = false)
	private Booking booking;
	@Column(length = 30)
	private String paymentMode;
	private double amount;
	private LocalDateTime dateAndTime;
	@Enumerated(EnumType.STRING)
	private TransactionStatus transactionStatus;
	
	
	@Override
	public String toString() {
		return "Payment [transactionId=" + transactionId + ", booking=" + booking + ", paymentMode=" + paymentMode
				+ ", amount=" + amount + ", dateAndTime=" + dateAndTime + ", transactionStatus=" + transactionStatus
				+ "]";
	}
	
}
