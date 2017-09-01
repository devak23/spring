package com.ak.learning.springjpa.exceptions;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResponseHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler({EntityNotFoundException.class})
  protected ResponseEntity<Object> handleEntityNotFoundException(final EntityNotFoundException ex, final WebRequest request) {
    return handleExceptionInternal(ex, message(HttpStatus.NOT_FOUND, ex), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
  }

  private ApiError message(final HttpStatus status, final Exception ex) {
    String message = ex.getMessage() == null ? ex.getClass().getSimpleName() : ex.getMessage();
    String devMessage = ExceptionUtils.getMessage(ex);
    return new ApiError(message, devMessage, status.value());
  }

  private final class ApiError {
    private String message;
    private String devMessage;
    private int status;

    public ApiError(String message, String devMessage, int status) {
      this.message = message;
      this.devMessage = devMessage;
      this.status = status;
    }

    public String getMessage() {
      return message;
    }

    public ApiError setMessage(String message) {
      this.message = message;
      return this;
    }

    public String getDevMessage() {
      return devMessage;
    }

    public ApiError setDevMessage(String devMessage) {
      this.devMessage = devMessage;
      return this;
    }

    public int getStatus() {
      return status;
    }

    public ApiError setStatus(int status) {
      this.status = status;
      return this;
    }
  }
}
