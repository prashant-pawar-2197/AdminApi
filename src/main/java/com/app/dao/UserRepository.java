package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.dto.SeatNumberForHistoryDto;
import com.app.dto.UserBookingHistoryDto;
import com.app.pojos.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByEmailAndPassword(String email, String password);
	
	Optional<User> findByEmail(String email);
	
	@Query(value="select new com.app.dto.UserBookingHistoryDto(mv.title,mv.poster,sh.showDate,sh.startTime,b.bookingTime,b.bookingDate,b.id,b.amount,b.numberOfSeats,p.paymentMode)"
			+ " from Payment p"
			+ " join p.booking b"
			+ " join b.show sh"
			+ " join sh.movie mv"
			+ " where b.user.id= ?1")
	List<UserBookingHistoryDto> getUserBookingHistory(int userId);
	
	@Query(value="select new com.app.dto.SeatNumberForHistoryDto(bs.seatNumber,bs.booking.id) from BookedSeats bs join bs.booking b join b.user u where u.id=?1")
	List<SeatNumberForHistoryDto> getAllSeatsNos(int userId);
}
