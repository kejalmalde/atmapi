package com.practise.AtmApi.resource;

import java.util.List;

public class Address {
	
	private String street;
	private String housenumber;
	private String postalcode;
	private String city;
	private geoLocation geoLocation;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHousenumber() {
		return housenumber;
	}

	public void setHousenumber(String housenumber) {
		this.housenumber = housenumber;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public geoLocation getGeoLocation() {
		return geoLocation;
	}

	public void setGeoLocation(geoLocation geoLocation) {
		this.geoLocation = geoLocation;
	}

	public Address() {}

	public Address(String street, String housenumber, String postalcode, String city,
			geoLocation geoLocation) {
		super();
		this.street = street;
		this.housenumber = housenumber;
		this.postalcode = postalcode;
		this.city = city;
		this.geoLocation = geoLocation;
	}
}
