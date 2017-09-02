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
    return authorRepository.findAll();
  }

  @Override
  public void createAuthor(Author author) {
    List<Author> authors = authorRepository.findByLastnameAndFirstname(author.getFirstName(), author.getLastName());
    AppValidator.checkEntityExists(authors, author);
    authorRepository.save(author);
  }

  @Override
  public void deleteAuthor(Long authorId) {
    authorRepository.delete(authorId);
  }

  @Override
  public void updateAuthor(Long authorId, Author author) {
    Author existing = authorRepository.findOne(authorId);

    AppValidator.checkEntityExists(existing);

    existing.setFirstName(author.getFirstName());
    existing.setLastName(author.getLastName());
    authorRepository.save(existing);
  }

  @Override
  public Author getAuthorById(Long authorId) {
    Author author = authorRepository.findOne(authorId);
    AppValidator.checkEntityExists(author);

    return author;
  }

  @Override
  public void saveAll(List<Author> authors) {
    authorRepository.save(authors);
  }
}
