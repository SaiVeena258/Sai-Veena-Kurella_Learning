package com.mappings.many_many.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mappings.many_many.model.Book;

public interface BookRepo extends JpaRepository<Book, Long>{

}
