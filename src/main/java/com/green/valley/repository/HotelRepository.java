package com.green.valley.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.green.valley.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
	
	@Query(value="select * from hotel where room_category = 'AC'",nativeQuery=true)
	List<Hotel> getAllACRoomData();
	
	@Query(value="select * from hotel where room_category = 'NONAC'",nativeQuery=true)
	List<Hotel> getAllNonACRoomData();

}
