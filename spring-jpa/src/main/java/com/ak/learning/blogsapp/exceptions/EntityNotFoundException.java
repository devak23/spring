package com.ak.learning.blogsapp.exceptions;

public class EntityNotFoundException extends RuntimeException {

  public EntityNotFoundException() {
    super();
  }

  public EntityNotFoundException(String message) {
    super(message);
  }

  public EntityNotFoundException(final Throwable throwable) {
    super(throwable);
  }

  public EntityNotFoundException(String message, final Throwable throwable) {
    super(message, throwable);
  }
}
