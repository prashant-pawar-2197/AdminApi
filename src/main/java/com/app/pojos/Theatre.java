package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
public class Theatre extends BaseEntity{
	@Column(name = "theatre_name", length = 30)
	@NotEmpty(message = "theatre name cannot be empty")
	private String theatreName;
	@Column(name = "theatre_city", length = 30)
	@NotEmpty(message = "theatre city cannot be empty")
	private String theatreCity;
	@Column(name = "theatre_contact_number",  length = 30)
	@NotEmpty(message = "theatre contact number cannot be empty")
	@Pattern(regexp="^[0-9]{10}$", message = "mobile number not valid")
	private String theatreContactNumber;
	@Column(name = "number_of_screens", length = 30)
	@NotNull(message = "number of screens cannot be empty")
	private int numberOfScreens;
	@Column(name = "theatre_state", length = 30)
	@NotEmpty(message = "theatre state cannot be empty")
	private String theatreState;
	@Column(name = "theatre_pincode", length = 30)
	@Pattern(regexp = "^[1-9][0-9]{5}$", message = "pincode not valid")
	private String theatrePincode;
	@Override
	public String toString() {
		return "Theatre [theatreName=" + theatreName + ", theatreCity=" + theatreCity + ", theatreContactNumber="
				+ theatreContactNumber + ", numberOfScreens=" + numberOfScreens + ", theatreState=" + theatreState
				+ ", theatrePincode=" + theatrePincode + "]";
	}
	
	
}
