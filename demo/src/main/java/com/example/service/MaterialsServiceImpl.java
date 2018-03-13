package com.example.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.model.Material;
import com.example.repository.MaterialsRepository;


@Service("materialsService")
public class MaterialsServiceImpl implements MaterialsService {
	@Autowired
	private MaterialsRepository materialsRepository;
	protected EntityManager em;
	@Override
	public void saveMaterial(Material material) {
		// TODO Auto-generated method stub
		materialsRepository.save(material);
	}
	
	@Override
	public List<Material> findAll() {
		return materialsRepository.findAll();

	}
	public void editMaterial(Material material) {
		material.setDetails(material.getDetails());
		materialsRepository.save(material);
	}
	
	@Override
	public Material findById(int id) {
		// TODO Auto-generated method stub
		return materialsRepository.findById(id);
	}
	
}
