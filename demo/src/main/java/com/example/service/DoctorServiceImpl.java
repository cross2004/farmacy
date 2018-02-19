package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.model.Doctor;
import com.example.repository.DoctorRepository;

public class DoctorServiceImpl implements DoctorService {
	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public void addDoctor(Doctor doctor) {
		doctor.setFirstName(doctor.getFirstName());
		doctor.setLastName(doctor.getLastName());
		doctor.setDescription(doctor.getDescription());
		doctor.setDegree(doctor.getDegree());
		doctor.setActive(doctor.getActive());
		doctorRepository.save(doctor);

	}

	@Override
	public void inactivateDoctor(Doctor doctor) {
		doctor.setActive(0);
		doctorRepository.save(doctor);
	}

	public void editDoctor(Doctor doctor) {
		doctor.setFirstName(doctor.getFirstName());
		doctor.setDescription(doctor.getDescription());
		doctor.setDegree(doctor.getDegree());
		doctor.setActive(doctor.getActive());

		doctorRepository.save(doctor);
	}

	@Override
	public void findById(int id) {
		// TODO Auto-generated method stub

	}

}
