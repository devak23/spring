package com.ak.learning.blogsapp.repositories;

import com.ak.learning.blogsapp.models.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAuthorRepository extends CrudRepository<Author, Long> {

  List<Author> findByLastnameOrFirstname(String firstname, String lastname);

  List<Author> findByLastnameAndFirstname(String firstname, String lastname);

  @Query("SELECT a from Author a WHERE a.emailAddress = ?1")
  Author findByEmailAddress(String emailId);
}