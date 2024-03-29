package com.example.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.JodaTimeConverters.LocalDateToDateConverter;
import org.springframework.stereotype.Service;
import com.example.model.Pacient;
import com.example.model.Results;
import com.example.repository.PacientRepository;
import com.example.repository.ResultsRepository;

@Service("pacientService")
public class PacientServiceImpl implements PacientService {
	@Autowired
	private PacientRepository pacientRepository;
	@Autowired
	private ResultsRepository resultsRepository;

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
		pacient.setActive(1);
		pacient.setIdentityCard(pacient.getIdentityCard());
		pacient.setState(pacient.getState());
		pacient.setCity(pacient.getCity());
		pacient.setAddress(pacient.getAddress());
		pacient.setEmail(pacient.getEmail());
		pacient.setPhone(pacient.getPhone());
		pacient.setCas(pacient.getCas());
		pacient.setCity(pacient.getCity());
		pacient.setDetails(pacient.getDetails());
		pacient.setBirthDate(pacient.getBirthDate());
		pacientRepository.save(pacient);
	}

	@Override
	public void inactivatePacient(Pacient pacient) {
		pacient.setActive(0);
		pacientRepository.save(pacient);
	}

	@Override
	public void editPacient(Pacient pacient) {
		pacient.setId(pacient.getId());
		pacient.setFirstName(pacient.getFirstName());
		pacient.setLastName(pacient.getLastName());
		pacient.setDetails(pacient.getDetails());
		pacient.setCnp(pacient.getCnp());
		pacient.setActive(1);
		pacient.setIdentityCard(pacient.getIdentityCard());
		pacient.setState(pacient.getState());
		pacient.setCity(pacient.getCity());
		pacient.setAddress(pacient.getAddress());
		pacient.setEmail(pacient.getEmail());
		pacient.setPhone(pacient.getPhone());
		pacient.setCas(pacient.getCas());
		pacient.setCity(pacient.getCity());
		pacient.setDetails(pacient.getDetails());
		pacient.setBirthDate(pacient.getBirthDate());
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
		return  pacientRepository.findAll();
	}

	@Override
	public Results viewVisitResults(int id) {
		return pacientRepository.viewVisitResults(id);

	}
	@Override
	public Pacient viewVisitResults2(int id) {
		return pacientRepository.viewVisitResults2(id);

	}

	@Override
	public void addResult(Results result) {
		resultsRepository.save(result);

	}

	@Override
	public Pacient editPacient(int id) {
		return pacientRepository.editPacient(id);

	}

	@Override
	public Results addVisitResult(int id) {
		return resultsRepository.getResults(id);
	}

	@Override
	public void saveResult(int id, Results result) {
		resultsRepository.save(result);
		Pacient pacient = pacientRepository.findById(id);
		//pacient.setResults(new HashSet<Results>(Arrays.asList(result)));
		Set<Results> set = pacient.getResults();
	    set.add(result);
		pacientRepository.save(pacient);
	}
	
	@Override
	public List<Pacient> findPacientsSuggestedDate() {
		LocalDate dt = LocalDate.now();//.plusDays(30);
		
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 30);  //
		Date today =c.getTime();
		int id =0;
		return  pacientRepository.findPacientsSuggestedDate(today);
	}
}
