package com.example.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.model.Pacient;
import com.example.model.User;
import com.example.repository.PacientRepository;

@Service("pacientService")
public class PacientServiceImpl implements PacientService {
	@Autowired
	private PacientRepository pacientRepository;

	protected EntityManager em;

	public PacientServiceImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public void savePacient(Pacient pacient) {
		pacient.setFirstName(pacient.getFirstName());
		pacient.setLastName(pacient.getLastName());
		pacient.setDetails(pacient.getDetails());
		pacient.setCnp(pacient.getCnp());

		pacientRepository.save(pacient);

	}

	@Override
	public void inactivatePacient(Pacient pacient) {
		pacient.setActive(0);
		pacientRepository.save(pacient);
	}

	@Override
	public void editPacient(Pacient pacient) {
		pacient.setFirstName(pacient.getFirstName());
		pacient.setLastName(pacient.getLastName());
		pacient.setCnp(pacient.getCnp());

		pacient.setDetails(pacient.getDetails());
		pacient.setLastDate(pacient.getLastDate());
		pacient.setNextDate(pacient.getNextDate());
		pacient.setActive(pacient.getActive());
		pacientRepository.save(pacient);
	}

	@Override
	public Pacient findById(int id) {
		// TODO Auto-generated method stub
		return pacientRepository.findById(id);

	}

	@Override
	public Pacient findPacientByCnp(String cnp) {
		return pacientRepository.findByCnp(cnp);
	}

	@Override
	public List<Pacient> findAll() {
	      return (List<Pacient>) em.createNamedQuery("findAll", Pacient.class).getResultList();
	  
	}

	
	@Override
	public Pacient viewVisitResults(int id) {
		return pacientRepository.viewVisitResults(id);

	}
	@Override
	public Pacient editPacient(int id) {
		return pacientRepository.editPacient(id);

	}
	

}
