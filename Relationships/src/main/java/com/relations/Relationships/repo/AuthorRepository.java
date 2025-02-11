package com.relations.Relationships.repo;


import java.util.*;

import com.relations.Relationships.entities.Author;
import com.relations.Relationships.entities.Book;


public interface AuthorRepository {
   
    ArrayList<Author> getAuthors();
    Author getAuthorById(int authorId);
    Author addAuthor(Author author);
    Author updateAuthor(int authorId,Author author);
    void deleteAuthor(int authorId);
    List<Book> getAuthorBooks(int id);
}
