package com.example.service;

import java.util.List;

import com.example.model.Doctor;
import com.example.model.Pacient;

public interface DoctorService {
	public Doctor findById(int id);
	public Doctor findByCnp(String cnp);
	public List<Doctor> findAllDoctors();
	public void addDoctor(Doctor doctor);
	public void inactivateDoctor(Doctor doctor);
	public void editDoctor(Doctor doctor);
	

}
