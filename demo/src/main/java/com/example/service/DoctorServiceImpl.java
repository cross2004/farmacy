package com.example.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Doctor;
import com.example.model.Pacient;
import com.example.model.Results;
import com.example.model.User;
import com.example.repository.DoctorRepository;

@Service("doctorService")
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public void addDoctor(Doctor doctor, User user) {
		/*doctor.setFirstName(doctor.getFirstName());
		
		doctor.setLastName(doctor.getLastName());
		doctor.setDescription(doctor.getDescription());
		doctor.setDegree(doctor.getDegree());
		doctor.setActive(doctor.getActive());*/
    
		Set<User> set = doctor.getUsers();
	    set.add(user);
	        
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
		Doctor doctor1 = doctorRepository.findById(doctor.getId());

		Set<User> set = doctor1.getUsers();
	   // set.add(user);
	    
		doctor.setUsers(set);
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
