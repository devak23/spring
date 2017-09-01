package com.ak.learning.springjpa.repositories;

import com.ak.learning.springjpa.models.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorRepository extends CrudRepository<Author, Long> {
}
