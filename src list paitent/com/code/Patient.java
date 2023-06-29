package com.code;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@SuppressWarnings("serial")
public class Patient implements Serializable {
	private int serialNo;
	private String name;
	private LocalDate admitDate;
	private String disease;
	private String gender;
	private Double income;
	private RoomType roomType;

	public Patient(int serialNo, String name, LocalDate admitDate, String disease, String gender, Double income,
			RoomType roomType) {
		super();
		this.serialNo = serialNo;
		this.name = name;
		this.admitDate = admitDate;
		this.disease = disease;
		this.gender = gender;
		this.income = income;
		this.roomType = roomType;
	}

	@Override
	public String toString() {
		return "Patient [serialNo=" + serialNo + ", name=" + name + ", admitDate=" + admitDate + ", disease=" + disease
				+ ", gender=" + gender + ", income=" + income + ", roomType=" + roomType + "]";
	}

	public Patient(int serialNo) {
		super();
		this.serialNo = serialNo;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Patient) {
			return ((Integer)this.serialNo).equals(((Patient)obj).serialNo);
		}
		return false;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getAdmitDate() {
		return admitDate;
	}

	public void setAdmitDate(LocalDate admitDate) {
		this.admitDate = admitDate;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

}
