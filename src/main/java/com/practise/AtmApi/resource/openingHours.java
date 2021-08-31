package com.practise.AtmApi.resource;

import java.util.List;

public class openingHours {

	private int dayOfWeek;	
	private List<hours> hours;
	public int getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	
	public List<hours> getHours() {
		return hours;
	}
	public void setHours(List<hours> hours) {
		this.hours = hours;
	}
	public openingHours() {}
}

