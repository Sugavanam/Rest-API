package com.company.sutrix.dao;

import java.util.List;

import com.company.sutrix.model.Person;

public interface PersonDao  {

	public List<Person> getAllPersonAboveThirtyFive();
	public Person getPersonbyId(Long id);
	public Person createPerson(Person p);
}
