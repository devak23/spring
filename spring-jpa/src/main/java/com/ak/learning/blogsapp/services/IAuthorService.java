package com.ak.learning.blogsapp.services;

import com.ak.learning.blogsapp.models.Author;

import java.util.List;

public interface IAuthorService {

  Iterable<Author> getAuthors();

  void createAuthor(Author author);

  void deleteAuthor(Long authorId);

  void updateAuthor(Long authorId, Author author);

  Author getAuthorById(Long authorId);

  void saveAll(List<Author> authors);

  List<Author> getAuthorByName(String name);

  Author getAuthorByEmail(String emailId);
}
