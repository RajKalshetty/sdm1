package com.code;

public enum RoomType {
	GENERAL(1000), SPECIAL(5000), SEMI_SPECIAL(3000), ICU(4500);

	private double rate;

	private RoomType(double rate) {
		this.rate = rate;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

}
