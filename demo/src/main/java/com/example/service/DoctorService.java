package com.example.service;

import com.example.model.Doctor;

public interface DoctorService {
	public void findById(int id);

	public void addDoctor(Doctor doctor);

	public void inactivateDoctor(Doctor doctor);

	public void editDoctor(Doctor doctor);

}
