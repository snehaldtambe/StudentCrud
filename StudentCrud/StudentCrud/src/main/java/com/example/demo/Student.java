package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "studid")
	private Long studId;
	
	@Column(name="studname")
	private String studName;
	
	@Column(name="studage")  
	private int studAge;


	@Column(name="studcity")
	private String studCity;
	
	public Long getStudId() {
		return studId;
	}

	public void setStudId(Long studId) {
		this.studId = studId;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public int getStudAge() {
		return studAge;
	}

	public void setStudAge(int studAge) {
		this.studAge = studAge;
	}

	public String getStudCity() {
		return studCity;
	}

	public void setStudCity(String studCity) {
		this.studCity = studCity;
	}

	public Student(Long studId, String studName, int studAge, String studCity) {
		super();
		this.studId = studId;
		this.studName = studName;
		this.studAge = studAge;
		this.studCity = studCity;
	}

	@Override
	public String toString() {
		return "Student [studId=" + studId + ", studName=" + studName + ", studAge=" + studAge + ", studCity="
				+ studCity + "]";
	}

	public Student() {
	
	}
	
	
		
}
