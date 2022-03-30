package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.TheatreDetails;

public interface TheatreDao extends JpaRepository<TheatreDetails, Integer> {

}
