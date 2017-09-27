package com.ak.learning.blogsapp.services;

import com.ak.learning.blogsapp.helpers.AppValidator;
import com.ak.learning.blogsapp.models.Author;
import com.ak.learning.blogsapp.repositories.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class AuthorService implements IAuthorService {

  private IAuthorRepository authorRepository;

  @Autowired
  public void setAuthorRepository(IAuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  @Override
  public Iterable<Author> getAuthors() {
    Iterable<Author> authors = authorRepository.findAll();
    AppValidator.checkCollectionExists(authors, "No authors were found in the database");
    return authors;
  }

  @Override
  public void createAuthor(Author author) {
    System.out.println("Lastname, FirstName ==> " + author.getFirstname() + " " + author.getLastname());
    List<Author> authors = authorRepository.findByLastnameOrFirstname(author.getLastname(), author.getFirstname());
    System.out.println("authors ==> " + authors);
    AppValidator.checkEntityExists(authors, author, "Another entry of an author by the name (" + author.getFirstname() + ", " + author.getLastname() + " exists in the database");
    authorRepository.save(author);
  }

  @Override
  public void deleteAuthor(Long authorId) {
    Author author = authorRepository.findOne(authorId);
    AppValidator.checkEntityExists(author, "The author with id = " + authorId + " does not exist!" + "Cannot delete the record");
    authorRepository.delete(authorId);
  }

  @Override
  public void updateAuthor(Long authorId, Author author) {
    Author existing = authorRepository.findOne(authorId);

    AppValidator.checkEntityExists(existing, "The author with id = " + authorId + " does not exist!" + "Cannot perform the update");

    existing.setFirstname(author.getFirstname());
    existing.setLastname(author.getLastname());
    authorRepository.save(existing);
  }

  @Override
  public Author getAuthorById(Long authorId) {
    Author author = authorRepository.findOne(authorId);
    AppValidator.checkEntityExists(author, "The author with id = " + authorId + " does not exist!");

    return author;
  }

  @Override
  public void saveAll(List<Author> authors) {
    AppValidator.checkCollectionExists(authors, "Please pass a valid (non-empty) collection of Authors to be persisted");
    authorRepository.save(authors);
  }

  @Override
  public List<Author> getAuthorByName(String name) {
    List<Author> authors = authorRepository.findByLastnameOrFirstname(name, name);
    AppValidator.checkCollectionExists(authors, "The author with name " + name + " was not found in the database");
    return authors;
  }

  @Override
  public Author getAuthorByEmail(String emailId) {
    Author author = authorRepository.findByEmail(emailId);
    AppValidator.checkEntityExists(author, "Author with the email Id " + emailId + " does not exist in the database");
    return author;
  }
}
