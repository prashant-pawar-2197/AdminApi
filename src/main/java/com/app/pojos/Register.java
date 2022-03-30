package com.app.pojo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name="register_details")
public class Register extends BaseEntity{
	@Column(name="first_name")
	@NotBlank(message = "first name is mandatory")
	private String firstName;
	@Column(name="last_name")
	@NotBlank(message = "last name is mandatory")
	private String lastName;
	@Column(name="date_of_birth")
	private LocalDate dob;
	@Column(name="gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Column(name="email", unique=true)
	@NotBlank(message = "email is mandatory")
	private String email;
	@Column(name="ph_no", unique=true)
	@NotBlank(message="phone number is mandatory")
	private String phone;
	@Column(name="password")
	@NotBlank(message="password cannot be blank")
	private String password;
	
	


	public Register() {
		
	}
	
	public Register(String email, String password) {
		this.email=email;
		this.password=password;
	}


	public Register(String firstName, String lastName, LocalDate dob, Gender gender, String email, String phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastname) {
		this.lastName = lastname;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "Register [firstName=" + firstName + ", lastname=" + lastName + ", dob=" + dob + ", gender=" + gender
				+ ", email=" + email + ", phone=" + phone + "]";
	}
	
	
}
