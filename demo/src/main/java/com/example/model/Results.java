package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "results")
public class Results {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "result_id")
	private int id;
	
	@Column(name = "descr")
    private String descr;
	
	@Column(name = "date")
	private Date date;
	
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
}

	