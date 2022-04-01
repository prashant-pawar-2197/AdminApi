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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="screen_details")
@NoArgsConstructor
@Getter
@Setter
public class Screen extends BaseEntity{
	@NotNull(message = "screen number cannot be null")
	private int screenNumber;
	@ManyToOne
	@JoinColumn(name = "theatre_id", nullable = false)
	private Theatre theatre;
	@ManyToOne
	@JoinColumn(name="show_id")
	private Show show;
	@OneToMany(mappedBy = "screen", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Seat> seats = new ArrayList<>();
	
	
	@Override
	public String toString() {
		return "Screen [screenNumber=" + screenNumber + ", theatre=" + theatre + ", show=" + show + "]";
	}
	


	
	
	
}
