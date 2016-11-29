package com.fatih;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HotelBooking {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	
	private String hotelName;
	
	
	private double pricePerNight;
	
	
	private int numberOfNight;
	
	
	
	public HotelBooking(String hotelName, double pricePerNight, int numberOfNight) {
		super();
		this.hotelName = hotelName;
		this.pricePerNight = pricePerNight;
		this.numberOfNight = numberOfNight;
	}
	
	public HotelBooking() {
		// TODO Auto-generated constructor stub
	}
	
	public String getHotelName() {
		return hotelName;
	}
	
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
	public double getPricePerNight() {
		return pricePerNight;
	}
	
	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
	
	public int getNumberOfNight() {
		return numberOfNight;
	}
	
	public void setNumberOfNight(int numberOfNight) {
		this.numberOfNight = numberOfNight;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	
	
	
	 public double getTotalPrice(){
	        return pricePerNight * numberOfNight;
	    }
	
	

}
