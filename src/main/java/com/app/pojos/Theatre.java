package com.app.pojos;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "theatre_details")
public class Theatre extends BaseEntity {
	@Column(name = "theatre_name", length = 30)
	@NotEmpty(message = "theatre name cannot be empty")
	private String theatreName;
	@Column(name = "theatre_city", length = 30)
	@NotEmpty(message = "theatre city cannot be empty")
	private String theatreCity;
	@Column(name = "theatre_contact_number", length = 30)
	@NotEmpty(message = "theatre contact number cannot be empty")
	@Pattern(regexp = "^[0-9]{10}$", message = "mobile number not valid")
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
	@OneToMany(mappedBy = "theatreId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Show> shows = new ArrayList<>();
	@OneToMany(mappedBy = "theatreId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Screen> screens = new ArrayList<>();
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private TheatreStatus status;
	@Column(length = 30)
	private String lastUpdatedBy;
	private Time lastUpdated;


	public Theatre(@NotEmpty(message = "theatre name cannot be empty") String theatreName,
			@NotEmpty(message = "theatre city cannot be empty") String theatreCity,
			@NotEmpty(message = "theatre contact number cannot be empty") @Pattern(regexp = "^[0-9]{10}$", message = "mobile number not valid") String theatreContactNumber,
			@NotNull(message = "number of screens cannot be empty") int numberOfScreens,
			@NotEmpty(message = "theatre state cannot be empty") String theatreState,
			@Pattern(regexp = "^[1-9][0-9]{5}$", message = "pincode not valid") String theatrePincode,
			TheatreStatus status, String lastUpdatedBy, Time lastUpdated) {
		super();
		this.theatreName = theatreName;
		this.theatreCity = theatreCity;
		this.theatreContactNumber = theatreContactNumber;
		this.numberOfScreens = numberOfScreens;
		this.theatreState = theatreState;
		this.theatrePincode = theatrePincode;
		this.status = status;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdated = lastUpdated;
	}

	public Theatre() {
		super();
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getTheatreCity() {
		return theatreCity;
	}

	public void setTheatreCity(String theatreCity) {
		this.theatreCity = theatreCity;
	}

	public String getTheatreContactNumber() {
		return theatreContactNumber;
	}

	public void setTheatreContactNumber(String theatreContactNumber) {
		this.theatreContactNumber = theatreContactNumber;
	}

	public int getNumberOfScreens() {
		return numberOfScreens;
	}

	public void setNumberOfScreens(int numberOfScreens) {
		this.numberOfScreens = numberOfScreens;
	}

	public String getTheatreState() {
		return theatreState;
	}

	public void setTheatreState(String theatreState) {
		this.theatreState = theatreState;
	}

	public String getTheatrePincode() {
		return theatrePincode;
	}

	public void setTheatrePincode(String theatrePincode) {
		this.theatrePincode = theatrePincode;
	}

	public List<Show> getShows() {
		return shows;
	}

	public void setShows(List<Show> shows) {
		this.shows = shows;
	}

	public List<Screen> getScreens() {
		return screens;
	}

	public void setScreens(List<Screen> screens) {
		this.screens = screens;
	}

	public TheatreStatus getStatus() {
		return status;
	}

	public void setStatus(TheatreStatus status) {
		this.status = status;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Time getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Time lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	

	@Override
	public String toString() {
		return "Theatre [theatreName=" + theatreName + ", theatreCity=" + theatreCity + ", theatreContactNumber="
				+ theatreContactNumber + ", numberOfScreens=" + numberOfScreens + ", theatreState=" + theatreState
				+ ", theatrePincode=" + theatrePincode + "]";
	}
	
}
