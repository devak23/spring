package com.ak.learning.blogsapp.exceptions;

public class NonEqualEntityException extends RuntimeException {
  public NonEqualEntityException() {
    super();
  }

  public NonEqualEntityException(String message) {
    super(message);
  }

  public NonEqualEntityException(final Throwable throwable) {
    super(throwable);
  }

  public NonEqualEntityException(String message, final Throwable throwable) {
    super(message, throwable);
  }
}
