package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;
@Entity

@Table(name = "pacient")
public class Pacient {@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
			@Column(name="pacient_id")
			private int id;
			@Column(name="name")
			@NotEmpty(message = "*Please provide a name")

			private String name;
			@Column(name="active")
			private int active;
			
			
			@Column(name="details")
			private String details;
			@Column(name="lastDate")
			private Date lastDate;
			@Column(name="nextDate")
			private Date nextDate;
			@Column(name="suggestedDate")
			private Date suggestedDate;
			
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
				this.details = name;
			}
			
			public String getDetails() {
				return details;
			}
			public void setDetails(String details) {
				this.details = details;
			}
			
			public Date getLastDate() {
				return lastDate;
			}
			public void setLastDate(Date lastDate) {
				this.lastDate = lastDate;
			}
			public Date getNextDate() {
				return nextDate;
			}
			public void setNextDate(Date nextDate) {
				this.nextDate = nextDate;
			}
			public Date getSuggestedDate() {
				return suggestedDate;
			}
			public void setSuggestedDate(Date suggestedDate) {
				this.suggestedDate = suggestedDate;
			}
			
			public int getActive() {
				return active;
			}
			public void setActive(int active) {
				this.active = active;
			}
			
			
		}

