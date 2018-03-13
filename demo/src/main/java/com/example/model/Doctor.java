package com.example.model;

import java.util.HashSet;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "doctor")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "doctor_id")
	private int id;
	@Column(name = "last_name")
	@NotEmpty(message = "*Please provide your last name")
	private String lastName;
	@Column(name = "first_name")
	@NotEmpty(message = "*Please provide your first name")
	private String firstName;
	@Column(name = "CNP")
	@NotEmpty(message = "*Please provide your  cnp")
	private String cnp;
	@Column(name = "phone")
	@NotEmpty(message = "*Please provide your phone")
	private String phone;
	
	@Column(name = "email")
	@Email(message = "*Please provide a valid Email")
	@NotEmpty(message = "*Please provide an email")
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

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_doctor", joinColumns = @JoinColumn(name = "doctor_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<User> users;
	
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
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	public Set<User> getUsers() {
		 if (users == null) {
		        users = new HashSet<User>();
		    }
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
