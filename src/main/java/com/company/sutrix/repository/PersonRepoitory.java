package com.company.sutrix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.company.sutrix.model.Person;

@Component
public interface PersonRepoitory extends JpaRepository<Person, Long> {

}
