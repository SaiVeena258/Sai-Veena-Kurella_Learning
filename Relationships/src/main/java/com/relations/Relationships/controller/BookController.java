package com.relations.Relationships.controller;

import org.springframework.web.bind.annotation.RestController;

import com.relations.Relationships.entities.Author;
import com.relations.Relationships.entities.Book;
import com.relations.Relationships.entities.Publisher;
import com.relations.Relationships.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class BookController {
    @Autowired
    BookService b;
     @GetMapping("/books")
    public ArrayList<Book>  getBooks(){
      
        return b.getBooks();
    }
    @GetMapping("/books/{bookId}/publisher")
  public Publisher getBookPublisher(@PathVariable("bookId") int bookId) {
      return b.getBookPublisher(bookId);

  }
    @GetMapping("/books/{bookId}")
    public Book getMethodName(@PathVariable("bookId") int id) {
        return b.getBookById(id);
    }
    
    @PostMapping("/books")
    public Book postMethodName(@RequestBody Book book) {
       return b.addBook(book);
    }
    @PutMapping("/books/{bookId}")
    public Book putMethodName(@PathVariable("bookId") int id, @RequestBody Book book) {
        System.out.println("sonegthing");
        return b.updateBook(id,book);
    }
    @DeleteMapping("/books/{bookId}")
    public String deleteBookId(@PathVariable("bookId") int id) {
        b.deleteBook(id);
        return "book deleted successfully";
    }
     @GetMapping("/books/{bookId}/authors")
    public List<Author> getBookAuthors(@PathVariable("bookId") int bookId){
        return b.getBookAuthors(bookId);
    }
}