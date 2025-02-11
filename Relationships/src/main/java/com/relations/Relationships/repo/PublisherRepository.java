package com.relations.Relationships.repo;



import java.util.ArrayList;

import com.relations.Relationships.entities.Publisher;




public interface PublisherRepository {

    ArrayList<Publisher> getPublishers();
   Publisher getPublisherById(int id);
   Publisher addPublisher(Publisher publisher);
   Publisher updatePublisher(int id,Publisher book);
   void deletePublisher(int id);
} 