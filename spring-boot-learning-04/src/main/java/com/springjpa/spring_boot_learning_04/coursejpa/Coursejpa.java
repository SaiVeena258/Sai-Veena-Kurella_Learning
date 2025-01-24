package com.springjpa.spring_boot_learning_04.coursejpa;

import org.springframework.stereotype.Repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class Coursejpa {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void insert(Coursejpafile course) {
		entityManager.merge(course);
	}
	
	public Coursejpafile findById(long id) {
		return entityManager.find(Coursejpafile.class,id);
	}
	
	public void deleteById(long id) {
		Coursejpafile course=entityManager.find(Coursejpafile.class, id);
		entityManager.remove(course);
	}
}
