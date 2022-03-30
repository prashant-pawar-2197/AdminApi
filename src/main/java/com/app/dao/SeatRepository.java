package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Seat;

public interface SeatRepository extends JpaRepository<Seat, Integer> {

}
