package com.ak.learning.blogsapp.exceptions;

public class UnequalEntityException extends RuntimeException {
  public UnequalEntityException() {
    super();
  }

  public UnequalEntityException(String message) {
    super(message);
  }

  public UnequalEntityException(final Throwable throwable) {
    super(throwable);
  }

  public UnequalEntityException(String message, final Throwable throwable) {
    super(message, throwable);
  }
}
