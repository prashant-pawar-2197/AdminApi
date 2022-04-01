package com.app.pojos;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "show_details")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Show extends BaseEntity{
	
	@ManyToOne
	@JoinColumn(name = "theatre_id",nullable=false)
	private Theatre theatre;
	@NotNull(message = "Please Enter Start Time")
	@JsonFormat(pattern ="HH:mm:ss")
	private LocalTime startTime;
	@NotNull(message = "Please Enter End Time")
	@JsonFormat(pattern ="HH:mm:ss")
	private LocalTime endTime;
	@ManyToOne
	@JoinColumn(name = "movie_id",nullable = false)
	private Movie movie;
	@ManyToOne
	@JoinColumn(name = "screen_id", nullable = false)
	private Screen screen;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ShowStatus showStatus;
	@NotNull(message = "gold price cannot be empty")
	private int goldPrice;
	@NotNull(message = "gold price cannot be empty")
	private int diamondPrice;
	@NotNull(message = "gold price cannot be empty")
	private int silverPrice;
	
	
	@Override
	public String toString() {
		return "Show [theatre=" + theatre + ", startTime=" + startTime + ", endTime=" + endTime + ", movie=" + movie
				+ ", screen=" + screen + ", showStatus=" + showStatus + ", goldPrice=" + goldPrice + ", diamondPrice="
				+ diamondPrice + ", silverPrice=" + silverPrice + "]";
	}
	

}
