package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.model.Pacient;

@Repository("pacientRepository")
public interface PacientRepository  extends JpaRepository<Pacient, Long> {
	Pacient findById(int id);
	Pacient findByCnp(String cnp);
	List<Pacient> findAll();
	@Query("SELECT p FROM Pacient p where p.id= :id")
	Pacient viewVisitResults(@Param("id") int id);
	@Query("SELECT p FROM Pacient p where p.id= :id")
	Pacient editPacient(@Param("id") int id);
	
}
