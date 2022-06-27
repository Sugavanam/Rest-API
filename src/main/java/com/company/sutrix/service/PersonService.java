package com.company.sutrix.service;

import java.util.List;

import com.company.sutrix.model.Person;

public interface PersonService {
	public List<Person> getAllPersonAboveThirtyFive();
	public Person getPersonbyId(Long Id);
	public Person createPerson(Person p);
}
