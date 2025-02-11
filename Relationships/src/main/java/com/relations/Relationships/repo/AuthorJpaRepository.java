package com.relations.Relationships.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.relations.Relationships.entities.Author;




@Repository
public interface AuthorJpaRepository extends JpaRepository<Author,Integer>{
    
}
