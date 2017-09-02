package com.ak.learning.blogsapp.exceptions;

public class DuplicateEntityException extends RuntimeException {

  public DuplicateEntityException() {
    super();
  }

  public DuplicateEntityException(String message) {
    super(message);
  }

  public DuplicateEntityException(Throwable throwable) {
    super(throwable);
  }

  public DuplicateEntityException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
