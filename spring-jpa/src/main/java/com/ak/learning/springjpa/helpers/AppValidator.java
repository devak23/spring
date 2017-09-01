package com.ak.learning.springjpa.helpers;

import com.ak.learning.springjpa.exceptions.EntityNotFoundException;

public final class AppValidator {
  private AppValidator() { throw new AssertionError();}

  public static <T> void validateEntityExists(T entity) throws RuntimeException {
    if (entity == null) {
      throw new EntityNotFoundException("The entity you're looking for does not exist in the database");
    }
  }
}
