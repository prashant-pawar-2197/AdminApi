package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="screen_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Screen extends BaseEntity{
	@NotNull(message = "screen number cannot be null")
	private int screenNumber;
	@ManyToOne
	@JoinColumn(name = "theatre_id", nullable = false)
	private Theatre theatreId;
	@OneToMany(mappedBy = "screenId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Seat> seats = new ArrayList<>();
	@OneToMany(mappedBy="screen",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Show> shows = new ArrayList<>();
	
	
	@Override
	public String toString() {
		return "Screen [screenNumber=" + screenNumber + ", theatreId=" + theatreId + "]";
	}
	
	
}
