package com.example.service;

import java.util.List;

import com.example.model.Material;

public interface MaterialsService {

	public void saveMaterial(Material material);
	public List<Material> findAll();
	public void editMaterial (Material material);
	public Material findById(int id);
}
