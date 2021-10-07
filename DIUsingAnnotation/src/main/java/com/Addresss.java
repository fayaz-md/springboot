package com;

import org.springframework.stereotype.Component;

@Component
public class Addresss {
	private String city,state;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Addresss [city=" + city + ", state=" + state + "]";
	}
}
