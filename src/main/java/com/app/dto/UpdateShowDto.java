package com.app.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.app.pojos.Screen;
import com.app.pojos.ShowStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateShowDto {
	private Integer id;
	private LocalTime startTime;
	private LocalTime endTime;
	private Integer screenId;
	private ShowStatus showStatus;
	private int goldPrice;
	private int diamondPrice;
	private int silverPrice;
	private LocalDate showDate;

}
