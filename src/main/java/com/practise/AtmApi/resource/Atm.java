package com.practise.AtmApi.resource;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Atm {
	
	private Address address;
	private int distance;
	private List<openingHours> openingHours;
	private String functionality;
	private String type;

	public String getFunctionality() {
		return functionality;
	}

	public void setFunctionality(String functionality) {
		this.functionality = functionality;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public List<openingHours> getOpeningHours() {
		return openingHours;
	}

	public void setOpeningHours(List<openingHours> openingHours) {
		this.openingHours = openingHours;
	}

	public Atm(Address address) {
		super();
		this.address = address;
	}
	
	public Atm() {
	}
	
	
	

}
