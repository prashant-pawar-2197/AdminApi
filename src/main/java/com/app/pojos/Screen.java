package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@NotNull
	@Column(name="screen_number")
	private int screenNumber;
	@ManyToOne
	@JoinColumn(name = "theatre_id")
	private Theatre theatre;

	@Override
	public String toString() {
		return "Screen [screenNumber=" + screenNumber + ", theatre=" + theatre +  "]";
	}


	
	
}
