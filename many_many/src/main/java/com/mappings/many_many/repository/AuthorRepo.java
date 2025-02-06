package com.mappings.many_many.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mappings.many_many.model.Author;

public interface AuthorRepo extends JpaRepository<Author, Long>{

}
