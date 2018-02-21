package com.example.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "doctor_id")
	private int id;
	@Column(name = "last_name")
	private String lastname;
	@Column(name = "first_name")
	private String firstname;
	@Column(name = "CNP")
	private String cnp;
	@Column(name = "phone")
	private String phone;
	@Column(name = "email")
	private String email;
	@Column(name = "degree")
	private String degree;
	@Column(name = "description")
	private String description;
	@Column(name = "active")
	private int activeDoc;
	@Column(name = "parafa")
	private int parafa;
	
	@OneToMany(mappedBy="doctorRes")
	private List<Results> resultss;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getParafa() {
		return parafa;
	}

	public void setParafa(int parafa) {
		this.parafa = parafa;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstname) {
		this.firstname = firstname;
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
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}
	public List<Results> getResults() {
		return  resultss;
	}

	public void setResults(List<Results> resultss) {
		this.resultss = resultss;
	}
}
