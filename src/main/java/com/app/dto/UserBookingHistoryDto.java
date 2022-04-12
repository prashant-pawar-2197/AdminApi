package com.app.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserBookingHistoryDto {
			private String movieName;
			private String poster;
			private LocalDate showDate;
			private LocalTime showStartTime;
			private LocalTime bookingTime;
			private LocalDate bookingDate;
			private Double bookingAmount;
			private int noOfSeats;
			private String paymentMode;
			
}
