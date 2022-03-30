package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Table(name="user_address")
@Entity
public class Address extends BaseEntity{
	@NotBlank(message="city cannot be blank")
	private String city;
	@NotBlank(message="city cannot be blank")
	private String state;
	@NotBlank(message="pincode cannot be blank")
	private String pincode;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	@MapsId
	private Register register;
	
	public Address() {
		
	}
	
	public Address(String city, String state, String pincode) {
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	

	public Register getRegister() {
		return register;
	}

	public void setRegister(Register register) {
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
