package com.example.service;
import java.util.List;

import com.example.model.Pacient;

public interface PacientService {
public Pacient findById(int id);
public Pacient findPacientByCnp(String cnp);
public void savePacient(Pacient pacient);
public void inactivatePacient(Pacient pacient);
public void editPacient(Pacient pacient);
//public List<Pacient> viewPacients();
public List<Pacient> findAll(); 
public Pacient viewVisitResults(int id);
}
