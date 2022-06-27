package com.company.sutrix.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.sutrix.model.Person;
import com.company.sutrix.serviceImpl.PersonServiceImpl;

@RestController
public class SutrixController {

	@Autowired
	private PersonServiceImpl personServiceImpl;

	@GetMapping(path = "/getAll")
	public List<Person> getAllPersonsAbove35() {
		return personServiceImpl.getAllPersonAboveThirtyFive();
	}

	@GetMapping(path = "/get/{id}")
	public Person getbyId(@PathVariable Long id) {
		return personServiceImpl.getPersonbyId(id);
	}
	
	@PostMapping(path="/create")
	public Person createPerson(@Valid @RequestBody Person person) {
		return personServiceImpl.createPerson(person);
	}
}
