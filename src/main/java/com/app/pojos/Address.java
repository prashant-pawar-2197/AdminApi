package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Table(name="user_address")
@Entity
public class Address extends BaseEntity{
	@NotBlank(message="city cannot be blank")
	@Column(length = 30)
	private String city;
	@NotBlank(message="city cannot be blank")
	@Column(length = 30)
	private String state;
	@NotBlank(message="pincode cannot be blank")
	@Column(length = 30)
	@Pattern(regexp = "^[1-9][0-9]{5}$", message = "pincode not valid")
	private String pincode;
	@OneToOne
	@JoinColumn(name = "user_id")
	@MapsId
	private User register;
	
	public Address() {
		
	}
	
	public Address(String city, String state, String pincode) {
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	

	public User getRegister() {
		return register;
	}

	public void setRegister(User register) {
		this.register = register;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
	}
	
	
	
	
	
}
