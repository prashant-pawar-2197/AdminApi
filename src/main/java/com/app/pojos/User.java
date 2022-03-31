package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
@Table(name="user_details")
public class User extends BaseEntity{
	@Column(name="first_name", length = 20)
	@NotBlank(message = "first name is mandatory")
	private String firstName;
	@Column(name="last_name", length = 20)
	@NotBlank(message = "last name is mandatory")
	private String lastName;
	@NotNull(message = "date of birth is mandatory")
	@Column(name="date_of_birth")
	private LocalDate dob;
	@Column(name="gender", length = 20)
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Column(name="email", unique=true, length = 20)
	@NotBlank(message = "email is mandatory")
	@Pattern(regexp = "^(.+)@(.+)$", message = "the email is invalid")
	private String email;
	@Column(name="ph_no", unique=true)
	@NotBlank(message="phone number is mandatory")
	@Pattern(regexp="^[0-9]{10}$", message = "phone number not valid")
	private String phone;
	@Column(name="password", length= 21)
	@NotBlank(message="password cannot be blank")
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})",message = "Invalid password")
	private String password;
	@OneToMany(mappedBy="userId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Booking> bookings = new ArrayList<>();
	

	public User() {
		
	}
	
	public User(String email, String password) {
		this.email=email;
		this.password=password;
	}


	public User(String firstName, String lastName, LocalDate dob, Gender gender, String email, String phone) {
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
