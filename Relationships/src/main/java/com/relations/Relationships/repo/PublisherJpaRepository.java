package com.relations.Relationships.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.relations.Relationships.entities.Publisher;

import java.util.Optional;

@Repository
public interface PublisherJpaRepository extends JpaRepository<Publisher,Integer>{
    
	Optional<Publisher> findByPublisherName(String publisherName); // Custom method
}