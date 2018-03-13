package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "results")
public class Results {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "result_id")
	private int id;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "dateVisit")
	private Date dateVisit;
	
	
	@Column(name = "descr")
    private String descr;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="doctor_id")
	private Doctor doctorRes;
	
	public int getId() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}
	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}
	public Date getDateVisit() {
		return dateVisit;
	}

	public void setDateVisit(Date dateVisit) {
		this.dateVisit = dateVisit;
	}
	
	public Doctor getDoctorRes() {
		return doctorRes;
	}

	public void setDoctorRes(Doctor doctorRes) {
		this.doctorRes = doctorRes;
	}
	
}

	