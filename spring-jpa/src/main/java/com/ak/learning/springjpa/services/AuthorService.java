package com.ak.learning.springjpa.services;

import com.ak.learning.springjpa.helpers.AppValidator;
import com.ak.learning.springjpa.models.Author;
import com.ak.learning.springjpa.repositories.IAuthorRepository;
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
    return authorRepository.findAll();
  }

  @Override
  public void createAuthor(Author author) {
    authorRepository.save(author);
  }

  @Override
  public void deleteAuthor(Long authorId) {
    authorRepository.delete(authorId);
  }

  @Override
  public void updateAuthor(Long authorId, Author author) {
    Author existing = authorRepository.findOne(authorId);

    AppValidator.validateEntityExists(existing);

    existing.setFirstName(author.getFirstName());
    existing.setLastName(author.getLastName());
    authorRepository.save(existing);
  }

  @Override
  public Author getAuthorById(Long authorId) {
    Author author = authorRepository.findOne(authorId);
    AppValidator.validateEntityExists(author);

    return author;
  }

  @Override
  public void saveAll(List<Author> authors) {
    authorRepository.save(authors);
  }
}
