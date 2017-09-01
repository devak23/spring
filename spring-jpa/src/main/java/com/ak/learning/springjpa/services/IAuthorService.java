package com.ak.learning.springjpa.services;

import com.ak.learning.springjpa.models.Author;

public interface IAuthorService {
  Iterable<Author> getAuthors();

  void createAuthor(Author author);

  void deleteAuthor(Long authorId);

  void updateAuthor(Long authorId, Author author);
}
