package com.app.pojos;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "show_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Show extends BaseEntity{
	
	
	private int theatreId;
	@NotNull(message = "Please Enter Start Time")
	private Time startTime;
	@NotNull(message = "Please Enter End Time")
	private Time endTime;
	@ManyToOne
	@JoinColumn(name = "movie_id",nullable = false)
	private Movie movieId;
	
	@Override
	public String toString() {
		return "ShowDetails [theatreId=" + theatreId + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", movieId=" + movieId + "]";
	}
	

}
