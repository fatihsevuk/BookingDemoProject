package com.fatih;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner{

	private HotelRepository hotelRepository;
	
	@Autowired
	public DatabaseSeeder(HotelRepository hotelRepository) {
		this.hotelRepository=hotelRepository;
	}
	
	
	@Override
	public void run(String... arg0) throws Exception {
		
		List<HotelBooking> bookings=new ArrayList<>();
		
		bookings.add(new HotelBooking("divan", 150, 3));
		bookings.add(new HotelBooking("polat", 170, 2));
		bookings.add(new HotelBooking("akgün", 120, 6));
		bookings.add(new HotelBooking("rönesans", 145, 4));
		
		hotelRepository.save(bookings);
		
		
		
	}

}
