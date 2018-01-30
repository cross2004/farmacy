package com.example.model;

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

@Entity

@Table(name = "schedule")
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "pacient_idid")
	private int pacient_id;
	
	@Column(name = "doctor_id")
	private int doctor_id;
	
	@Column(name = "details")
	private String details;
	@Column(name = "data")
	private Date data;

	public int getDoctorID() {
		return doctor_id;
	}

	public void setDoctorID(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	public int getPacientID() {
		return pacient_id;
	}

	public void setPacientID(int pacient_id) {
		this.pacient_id = pacient_id;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getLastDate() {
		return data;
	}

	public void setLastDate(Date data) {
		this.data = data;
	}
}
