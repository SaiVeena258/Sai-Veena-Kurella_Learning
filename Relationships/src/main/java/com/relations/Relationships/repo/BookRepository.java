package com.relations.Relationships.repo;

import java.util.ArrayList;
import java.util.List;

import com.relations.Relationships.entities.Author;
import com.relations.Relationships.entities.Book;
import com.relations.Relationships.entities.Publisher;




public interface BookRepository {
	   
    ArrayList<Book> getBooks();
    Book getBookById(int bookId);
    Book addBook(Book book);
    Book updateBook(int bookId,Book book);
    void deleteBook(int bookId);
    Publisher getBookPublisher(int bookId);
    List<Author> getBookAuthors(int id);
}