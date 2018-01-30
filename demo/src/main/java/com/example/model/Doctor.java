package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "doctor_id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "degree")
	private String degree;
	@Column(name = "description")
	private String description;

	@Column(name = "active")
	private int activeDoc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getActive() {
		return activeDoc;
	}

	public void setActive(int activeDoc) {
		this.activeDoc = activeDoc;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
