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
		// TODO Auto-generated method stub
		return pacientRepository.findById(id);

	}
	
	/*@Override
	@Transactional
	public List<Pacient> viewPacients() {
		// .setParameter("custName", name)
		// TypedQuery<Pacient> query = em.createNamedQuery("Pacient.findAll",
		// Pacient.class);
		javax.persistence.Query query;
		em.getTransaction().begin();

		query = em.createQuery("SELECT c.cnp FROM Pacient c ");
		List<Pacient> lista;
		lista = query.getResultList();
		//em.getTransaction().commit();
		return lista;
		}
*/
		/*
		 * List<Object[]> listePublication; Query q; em.getTransaction().begin();
		 * q=em.createQuery("SELECT c.titrePublication, c.datePublication,
		 * c.corps,p.login FROM Publication c JOIN c.employee p "); listePublication =
		 * q.getResultList(); //ArrayList<Publication> results = new
		 * ArrayList<Publication>(); //for (Object[] resultat : listePublication)
		 * //results.add((Publication) resultat[0]);
		 */
		// em.getTransaction().commit();
		// return results;*/
	

}
