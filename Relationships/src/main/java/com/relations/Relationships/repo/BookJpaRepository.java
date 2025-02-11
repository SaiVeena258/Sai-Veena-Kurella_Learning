package com.relations.Relationships.repo;


import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.relations.Relationships.entities.Book;
import com.relations.Relationships.entities.Publisher;



@Repository
public interface BookJpaRepository extends JpaRepository<Book,Integer>{
     ArrayList<Book> findByPublisher(Publisher publisher);
}
