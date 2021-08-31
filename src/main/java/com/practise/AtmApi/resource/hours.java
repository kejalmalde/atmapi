package com.practise.AtmApi.resource;

public class hours {

	private String hourFrom;
	private String hourTo;
	public String getHourFrom() {
		return hourFrom;
	}
	public void setHourFrom(String hourFrom) {
		this.hourFrom = hourFrom;
	}
	public String getHourTo() {
		return hourTo;
	}
	public void setHourTo(String hourTo) {
		this.hourTo = hourTo;
	}
	public hours(String hourFrom, String hourTo) {
		super();
		this.hourFrom = hourFrom;
		this.hourTo = hourTo;
	}
	public hours() {}
	
}
