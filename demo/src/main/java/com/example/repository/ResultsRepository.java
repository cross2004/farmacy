package com.example.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.model.Pacient;
import com.example.model.Results;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface ResultsRepository  extends JpaRepository<Pacient, Long> {
	Results findById(int id);

	void save(Results result);
	@Query("SELECT r FROM Results r where r.id= :id")
	Results getResults(@Param("id") int id);
	//@Query("insert into pacient_results(pacient_id,results_id) select :id1,:id2 from dual")
	//void insert(int id1, int id2);
}
