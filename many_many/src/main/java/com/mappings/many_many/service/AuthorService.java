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
public class AuthorService {
    
    @Autowired
    private AuthorRepo authorRepo;
    
    @Autowired
    private BookRepo bookRepo;
    
    public List<Author> getAllAuthors() {
        return authorRepo.findAll();
    }

    public Author getAuthorById(Long id) {
        return authorRepo.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Author not found with ID: " + id));
    }

    public Author saveAuthor(Author author) {
        List<Book> existingBooks = new ArrayList<>();

        if (author.getBooks() != null) {
            for (Book book : author.getBooks()) {
                Book existingBook = bookRepo.findById(book.getBookid()).orElse(null);
                if (existingBook != null) {
                    existingBooks.add(existingBook); 
                } else {
                    existingBooks.add(book);
                }
            }
        }
        author.setBooks(existingBooks);  
        return authorRepo.save(author);
    }

    public Author updateAuthor(Long id, Author updatedAuthor) {
        return authorRepo.findById(id).map(existingAuthor -> {
            existingAuthor.setAuthorname(updatedAuthor.getAuthorname());
            if (updatedAuthor.getBooks() != null) {
                List<Book> existingBooks = new ArrayList<>(existingAuthor.getBooks());
                for (Book book : updatedAuthor.getBooks()) {
                    bookRepo.findById(book.getBookid()).ifPresentOrElse(
                        existingBook -> {
                            existingBooks.add(existingBook);
                            existingBook.getAuthors().add(existingAuthor); 
                        },
                        () -> {
                            book.getAuthors().add(existingAuthor); 
                            existingBooks.add(book);
                        }
                    );
                }
                existingAuthor.setBooks(existingBooks);
            }
            return authorRepo.save(existingAuthor);
        }).orElseThrow(() -> new EntityNotFoundException("Author not found with ID: " + id));
    }

    public void deleteAuthor(Long id) {
        Author author = authorRepo.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Author not found with ID: " + id));
        for (Book book : author.getBooks()) {
            book.getAuthors().remove(author);
        }
        bookRepo.saveAll(author.getBooks()); 
        authorRepo.delete(author); 
    }
}