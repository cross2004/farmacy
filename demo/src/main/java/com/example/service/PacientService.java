package com.example.service;
import java.util.List;

import com.example.model.Pacient;

public interface PacientService {
public void findById(int id);
public Pacient findPacientByCnp(String cnp);
public List<Pacient> viewPacients(); 
public void savePacient(Pacient pacient);
public void inactivatePacient(Pacient pacient);
public void editPacient(Pacient pacient);
}
