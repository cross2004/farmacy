package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Material;
import com.example.model.Pacient;



@Repository("materialsRepository")
public interface MaterialsRepository  extends JpaRepository<Material, Integer>{
	Material findById(int id);
}
