package com.example.model;

import java.sql.Time;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity

@Table(name = "schedule")
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	
	@Column(name = "pacient_id")
	
	private int pacientId;
	

	@Column(name = "doctor_id")
	
	private int doctorId;
	
	@Column(name = "details")
	private String details;
	
	@NotEmpty(message = "*Please provide the start time")
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
	@Column(name = "startTime")
	private Date startTime;

	@NotEmpty(message = "*Please provide the end time")
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
	@Column(name = "endTime")
	private Date endTime;

	
	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getPacientId() {
		return pacientId;
	}

	public void setPacientId(int pacientId) {
		this.pacientId = pacientId;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}


	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}
