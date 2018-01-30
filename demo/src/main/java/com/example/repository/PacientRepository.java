package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Pacient;

@Repository("pacientRepository")
public interface PacientRepository  extends JpaRepository<Pacient, Long> {
	Pacient findById(int id);
//	Pacient savePacient(Pacient pacient);
//	Pacient editPacient(Pacient pacient);
//	Pacient inactivatePacient(Pacient pacient);

}
