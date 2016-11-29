package com.fatih;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/bookings")
@Api(name="Hotel Booking Api" ,description="This api consist of Hotel Booking App operation" ,stage=ApiStage.RC)
public class BookingController {
	
	private HotelRepository hotelRepository;
	
	@Autowired
	public BookingController(HotelRepository hotelRepository) {
		this.hotelRepository=hotelRepository;
	}
	
	
	@RequestMapping(value="/all" , method=RequestMethod.GET)
	@ApiMethod(description="Get all booking")
	public List<HotelBooking> getAll(){
		return hotelRepository.findAll();
	}
	  
	@RequestMapping(value="/affordable/{price}" , method=RequestMethod.GET)
	@ApiMethod(description="Get all booking where price per night is less then the provided value")
	public List<HotelBooking> getAffordable(@ApiPathParam(name="price") @PathVariable double price){
		
		return hotelRepository.findByPricePerNightLessThan(price);
		
	}
	
	@RequestMapping(value="/create" , method=RequestMethod.POST)
	@ApiMethod(description="Create new hotel booking")
	public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking){
		
		hotelRepository.save(hotelBooking);
		
		return hotelRepository.findAll();
		
		
		
	}
	
	@RequestMapping(value="/delete/{id}" , method=RequestMethod.POST)
	@ApiMethod(description="Delete hotel booking where id is provided value")
	public List<HotelBooking> remove(@ApiPathParam(name="id") @PathVariable long id){
		hotelRepository.delete(id);
		return hotelRepository.findAll();
	}
	
	
	
	
}
