package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.dto.TheatreDto;
import com.app.pojos.Theatre;

public interface TheatreRepository extends JpaRepository<Theatre, Integer> {
	@Query( "SELECT new com.app.dto.TheatreDto(t.id, t.theatreName , t.theatreState, theatreCity) from Theatre t")
	List<TheatreDto> findAllTheatres();
	
	
}
