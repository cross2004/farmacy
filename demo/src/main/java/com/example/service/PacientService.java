package com.example.service;
import java.time.LocalDate;
import java.util.List;

import com.example.model.Pacient;
import com.example.model.Results;

public interface PacientService {
public Pacient findById(int id);
public Pacient findPacientByCnp(String cnp);
public void savePacient(Pacient pacient);
public void inactivatePacient(Pacient pacient);
public void editPacient(Pacient pacient);

public Results viewVisitResults(int id); 

public Pacient viewVisitResults2(int id); 
public void addResult(Results result); 
public Pacient editPacient(int id); 
public Results addVisitResult(int id); 
public void saveResult(int id, Results result); 
public List<Pacient> findPacientsSuggestedDate();
public List<Pacient> findAll(); 

}
