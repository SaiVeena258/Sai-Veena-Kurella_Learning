package com.mappings.many_many.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mappings.many_many.model.Author;
import com.mappings.many_many.service.AuthorService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/authors")
public class AuthorController {
	
    @Autowired
    private AuthorService authorService;
	
    @GetMapping("/displayauthors")
    public ResponseEntity<List<Author>> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }
	
    @GetMapping("/displayauthors/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(authorService.getAuthorById(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
	
    @PostMapping("/addauthor")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        Author savedAuthor = authorService.saveAuthor(author);
        return ResponseEntity.status(201).body(savedAuthor);
    }

    @PutMapping("/updateauthor/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author updatedAuthor) {
        try {
            return ResponseEntity.ok(authorService.updateAuthor(id, updatedAuthor));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteauthor/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        try {
            authorService.deleteAuthor(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

