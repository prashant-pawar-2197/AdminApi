package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "theatre_details")
public class TheatreDetails extends BaseEntity{
	@Column(name = "theatre_name")
	private String theatreName;
	@Column(name = "theatre_city")
	private String theatreCity;
	@Column(name = "theatre_contact_number")
	private long theatreContactNumber;
	@Column(name = "number_of_screens")
	private int numberOfScreens;
	@Column(name = "theatre_state")
	private String theatre_state;
	@Column(name = "theatre_pincode")
	private int theatrePincode;
}
