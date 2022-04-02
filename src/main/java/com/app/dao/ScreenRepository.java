package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Screen;

public interface ScreenRepository extends JpaRepository<Screen, Integer>{
			@Query(value="update screen_details set screen_status=?1 where id=?2", nativeQuery=true)
			@Modifying
			int updateScreenStatus(String status,int id);
}
