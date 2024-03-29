package com.example.service;

import java.util.List;

import com.example.model.Doctor;
import com.example.model.Pacient;
import com.example.model.User;

public interface DoctorService {
	public Doctor findById(int id);
	public Doctor findByCnp(String cnp);
	public List<Doctor> findAllDoctors();
	public void addDoctor(Doctor doctor, User user);
	public void inactivateDoctor(Doctor doctor);
	public void editDoctor(Doctor doctor);
	public Doctor findDoctorFromUser(User user);
}
