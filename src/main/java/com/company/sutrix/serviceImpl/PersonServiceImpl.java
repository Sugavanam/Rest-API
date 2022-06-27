package com.company.sutrix.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.sutrix.daoImpl.PersonDaoImpl;
import com.company.sutrix.model.Person;
import com.company.sutrix.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	private PersonDaoImpl personDaoImpl;

	@Override
	public List<Person> getAllPersonAboveThirtyFive() {
		// TODO Auto-generated method stub
		return (personDaoImpl.getAllPersonAboveThirtyFive()).stream()
				.filter(i -> i.getAge() >= 35)
				.collect(Collectors.toList());
	}

	@Override
	public Person getPersonbyId(Long id) {
		// TODO Auto-generated method stub
		return personDaoImpl.getPersonbyId(id);


	}

	@Override
	public Person createPerson(Person p) {
		// TODO Auto-generated method stub
		return personDaoImpl.createPerson(p);
	}
}


