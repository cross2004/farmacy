package com.example.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

@Entity
@NamedQueries({ @NamedQuery(name = "findAll", query = "SELECT p FROM Pacient p") })

@Table(name = "pacient")
public class Pacient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pacient_id")
	private int id;

	@Column(name = "cnp")
	@NotEmpty(message = "*Please provide CNP")
	private String cnp;

	@Column(name = "firstName")
	@NotEmpty(message = "*Please provide a name")
	private String firstName;

	@Column(name = "lastName")
	@NotEmpty(message = "*Please provide a name")
	private String lastName;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "birthDate")
	private Date birthDate;

	@Column(name = "state")
	@NotEmpty(message = "*Please provide a state")
	private String state;

	@Column(name = "city")
	@NotEmpty(message = "*Please provide a city")
	private String city;

	@Column(name = "address")
	@NotEmpty(message = "*Please provide an address")
	private String address;

	@Column(name = "phone")
	@NotEmpty(message = "*Please provide an phone number")
	private String phone;

	@Column(name = "email")
	@NotEmpty(message = "*Please provide an email address")
	private String email;

	@Column(name = "identityCard")
	@NotEmpty(message = "*Please provide an identityCard")
	private String identityCard;

	@Column(name = "cas")
	private String cas;

	@Column(name = "active")
	private int active;

	@Column(name = "details")
	private String details;

	@Column(name = "lastDate")
	private Date lastDate;

	@Column(name = "suggestedDate")
	private Date suggestedDate;

	@Column(name = "suggestedTreatment")
	private String suggestedTreatment;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "pacient_results", joinColumns = @JoinColumn(name = "pacient_id"), inverseJoinColumns = @JoinColumn(name = "results_id"))
	private Set<Results> results;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getCas() {
		return cas;
	}

	public void setCas(String cas) {
		this.cas = cas;
	}

	public void setSuggestedTreatment(String suggestedTreatment) {
		this.suggestedTreatment = suggestedTreatment;
	}

	public String getSuggestedTreatment() {
		return suggestedTreatment;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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

	public Set<Results> getResults() {
		return results;
	}

	public void setResults(Set<Results> results) {
		this.results = results;
	}

}
