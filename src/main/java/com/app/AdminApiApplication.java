package com.app;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.app.service.IShowService;

@SpringBootApplication
@EnableScheduling
public class AdminApiApplication {
	
	@Autowired
	private IShowService showService;

	public static void main(String[] args) {
		SpringApplication.run(AdminApiApplication.class, args);
	}
	
	@Scheduled(fixedDelayString = "PT1M")
	public void updateShowStatus() throws InterruptedException {
		showService.updateShowStatus(LocalTime.now(), LocalDate.now());
	}
}
