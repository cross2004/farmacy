package com.example.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Doctor;
import com.example.model.Pacient;


@Repository("doctorRepository")
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{
	Doctor findById(int id);
	Doctor findByCnp(String cnp);
	List<Doctor> findAll();
}
