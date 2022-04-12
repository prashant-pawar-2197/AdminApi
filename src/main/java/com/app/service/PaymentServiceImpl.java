package com.app.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.PaymentRepository;
import com.app.dto.BookAndPayDto;
import com.app.pojos.Booking;
import com.app.pojos.Payment;
import com.app.pojos.TransactionStatus;
@Service
@Transactional
public class PaymentServiceImpl implements IPaymentService {
	@Autowired
	PaymentRepository paymentRepo;
	@Autowired
	IBookedSeatsService bookedSeatsService;
	@Autowired
	IBookingService bookingService;
	
	@Override
	public Payment makePayment(BookAndPayDto paymentDetails, Booking booking) {
		try {
			if (paymentDetails.getUpi()!=null) {
				return paymentRepo.save(new Payment(booking,"UPI",paymentDetails.getAmount(),LocalDateTime.now(),TransactionStatus.SUCCESS));
			}else {
				return paymentRepo.save(new Payment(booking,"CARD",paymentDetails.getAmount(),LocalDateTime.now(),TransactionStatus.SUCCESS));
			}
		
		}catch(RuntimeException e) {
			//In case of payment failed --> the booked seats and the booking needs to get cancelled
			bookingService.deleteBooking(booking.getId());
			bookedSeatsService.deleteBookedSeats(booking.getId());
			throw new RuntimeException("Payment Failed");
		}
		
	}

}
