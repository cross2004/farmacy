package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Pacient;
import com.example.repository.PacientRepository;

@Service("pacientService")
public class PacientServiceImpl implements PacientService{
	@Autowired
	private PacientRepository pacientRepository;
		
    @Override
	public void savePacient(Pacient pacient) {
    	pacient.setName(pacient.getName());
    	pacient.setDetails(pacient.getDetails());
    	pacient.setLastDate(pacient.getLastDate());
    	pacient.setNextDate(pacient.getNextDate());
    	pacientRepository.save(pacient);

	}
    @Override
public void inactivatePacient(Pacient pacient) {
    	pacient.setActive(0);
    	pacientRepository.save(pacient);    	
    }
    @Override 
public void editPacient(Pacient pacient)
{
	pacient.setName(pacient.getName());
	pacient.setDetails(pacient.getDetails());
	pacient.setLastDate(pacient.getLastDate());
	pacient.setNextDate(pacient.getNextDate());
	pacient.setActive(pacient.getActive());
	pacientRepository.save(pacient);  
}
@Override
public void findById(int id) {
	// TODO Auto-generated method stub
	
}


}
