package com.fatih;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<HotelBooking, Long>{
	
	List<HotelBooking> findByPricePerNightLessThan(Double price);

}
