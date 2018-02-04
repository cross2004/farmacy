package com.example.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

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
	public void findById(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Pacient findPacientByCnp(String cnp) {
		return pacientRepository.findByCnp(cnp);
	}

	@Override
	public List<Pacient> viewPacients() {
		TypedQuery<Pacient> query = em.createNamedQuery("Pacient.findAll", Pacient.class);
		List<Pacient> results = query.getResultList();
		return results;

	}

}
