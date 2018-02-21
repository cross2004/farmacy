package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Doctor;
import com.example.repository.DoctorRepository;

@Service("doctorService")
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
		//doctor.setFirstName(doctor.getFirstName());
		//doctor.setDescription(doctor.getDescription());
		//doctor.setDegree(doctor.getDegree());
		//doctor.setActive(doctor.getActive());
		doctorRepository.save(doctor);
	}

	@Override
	public Doctor findById(int id) {
		// TODO Auto-generated method stub
		return doctorRepository.findById(id);
	}
	@Override
	public Doctor findByCnp(String cnp) {
		// TODO Auto-generated method stub
		return doctorRepository.findByCnp(cnp);
	}

	@Override
	public List<Doctor> findAllDoctors() {
		// TODO Auto-generated method stub
		return doctorRepository.findAll();
	}

	
}
