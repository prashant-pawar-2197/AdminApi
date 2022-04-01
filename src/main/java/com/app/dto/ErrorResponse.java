package com.app.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ErrorResponse {
	private String message;
	private LocalDateTime timeStamp;
	
	
	
	public ErrorResponse() {
		super();
	}



	public ErrorResponse(String message, LocalDateTime timeStamp) {
		super();
		this.message = message;
		this.timeStamp = timeStamp;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}



	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}



	@Override
	public String toString() {
		return "ErrorResponse [message=" + message + ", timeStamp=" + timeStamp + "]";
	}
	
}
