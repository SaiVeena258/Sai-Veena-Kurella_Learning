package com.mappings.many_many.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mappings.many_many.model.Author;
import com.mappings.many_many.model.Book;
import com.mappings.many_many.repository.AuthorRepo;
import com.mappings.many_many.repository.BookRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class BookService {
    
    @Autowired
    private BookRepo bookRepo;
    
    @Autowired
    private AuthorRepo authorRepo;
    
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepo.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Book not found with ID: " + id));
    }

    public Book saveBook(Book book) {
        List<Author> existingAuthors = new ArrayList<>();

        if (book.getAuthors() != null) {
            for (Author author : book.getAuthors()) {
                Author existingAuthor = authorRepo.findById(author.getAuthorid()).orElse(null);
                if (existingAuthor != null) {
                    existingAuthors.add(existingAuthor);
                } else {
                    existingAuthors.add(author);
                }
            }
        }
        book.setAuthors(existingAuthors);  
        return bookRepo.save(book);
    }

    public Book updateBook(Long id, Book updatedBook) {
        return bookRepo.findById(id).map(existingBook -> {
            existingBook.setBooktitle(updatedBook.getBooktitle());
            if (updatedBook.getAuthors() != null) {
                List<Author> existingAuthors = new ArrayList<>(existingBook.getAuthors()); 
                for (Author author : updatedBook.getAuthors()) {
                    authorRepo.findById(author.getAuthorid()).ifPresentOrElse(
                        existingAuthors::add, 
                        () -> existingAuthors.add(author)
                    );
                }
                existingBook.setAuthors(existingAuthors);
            }
            return bookRepo.save(existingBook);
        }).orElseThrow(() -> new EntityNotFoundException("Book not found with ID: " + id));
    }

    public void deleteBook(Long id) {
        if (!bookRepo.existsById(id)) {
            throw new EntityNotFoundException("Book not found with ID: " + id);
        }
        bookRepo.deleteById(id);
    }
}