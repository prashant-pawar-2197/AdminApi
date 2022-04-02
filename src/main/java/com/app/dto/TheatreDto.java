package com.app.dto;


public class TheatreDto {
	
	private Integer id;
	private String theatreName;
	private String theatreState;
	private String theatreCity;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getTheatreState() {
		return theatreState;
	}
	public void setTheatreState(String theatreState) {
		this.theatreState = theatreState;
	}
	public String getTheatreCity() {
		return theatreCity;
	}
	public void setTheatreCity(String theatreCity) {
		this.theatreCity = theatreCity;
	}
	public TheatreDto(Integer id, String theatreName, String theatreState, String theatreCity) {
		super();
		this.id = id;
		this.theatreName = theatreName;
		this.theatreState = theatreState;
		this.theatreCity = theatreCity;
	}
	public TheatreDto(Integer id, String theatreName) {
		super();
		this.id = id;
		this.theatreName = theatreName;
	}
	
	
	
}
