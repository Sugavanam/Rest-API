package com.company.sutrix.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import com.company.sutrix.Exception.UserNotFoundException;
import com.company.sutrix.dao.PersonDao;
import com.company.sutrix.model.Person;
import com.company.sutrix.repository.PersonRepoitory;

@Repository
public class PersonDaoImpl implements PersonDao {

	@Autowired
	private PersonRepoitory repo;

	@Override
	public List<Person> getAllPersonAboveThirtyFive() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Person getPersonbyId(Long id){
		// TODO Auto-generated method stub
		Optional<Person> pr =repo.findById(id);
		if(pr.isPresent()) {
			return pr.get();
		}else {
			throw new UserNotFoundException("User Not Available");
		}
	}

	@Override
	public Person createPerson(Person p) {
		Optional<Person> pr = Optional.ofNullable(repo.save(p));
		return pr.orElseThrow(() -> new DataIntegrityViolationException("Constraint Violated")); 
	}





}
