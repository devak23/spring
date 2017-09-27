package com.ak.learning.blogsapp.helpers;

import com.ak.learning.blogsapp.exceptions.DuplicateEntityException;
import com.ak.learning.blogsapp.exceptions.EntityNotFoundException;
import com.ak.learning.blogsapp.exceptions.UnequalEntityException;

import java.util.List;

public final class AppValidator {
  private AppValidator() { throw new AssertionError();}

  public static <T> void checkEntityExists(T entity) throws RuntimeException {
    checkEntityExists(entity, "The entity you're looking for does not exist in the database");
  }

  public static boolean checkEntityExists(Long sourceId, Long targetId) {
    if (!sourceId.equals(targetId)) {
      throw new UnequalEntityException("The primary key of the two entities dont match");
    }
    return true;
  }

  public static  <T> void checkEntityExists(List<T> entities, T type) {
    if (entities != null && !entities.isEmpty()) {
      for(T e : entities) {
        if (e.equals(type)) {
          throw new DuplicateEntityException("Another entity with the same configuration exists in the database");
        }
      }
    }
  }

  public static <T> void checkEntityExists(T entity, String message) {
    if (entity == null) {
      throw new EntityNotFoundException(message);
    }
  }

  public static <T> void checkCollectionExists(Iterable<T> entities, String message) {
    if (entities == null || !entities.iterator().hasNext()) {
      throw new EntityNotFoundException(message);
    }
  }

  public static <T> void checkCollectionExists(Iterable<T> entities) {
    checkCollectionExists(entities, "Entities were not found in the database");
  }
}
