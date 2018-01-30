package com.example.service;
import com.example.model.Pacient;

public interface PacientService {
public void findById(int id);
public void savePacient(Pacient pacient);
public void inactivatePacient(Pacient pacient);
public void editPacient(Pacient pacient);
}
