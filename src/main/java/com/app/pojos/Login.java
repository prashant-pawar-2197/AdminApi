package com.app.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="login_details")
public class Login extends BaseEntity{
	@Column(unique=true)
	@NotBlank(message = "Email cannot be null")
	private String email;
	@NotBlank(message = "Password cannot be null")
	private String password;
	
	public Login(){
		
	}
	
	public Login(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Login [email=" + email + ", password=" + password + "]";
	}
	
	
}
