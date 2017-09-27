package com.ak.learning.blogsapp.exceptions;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ResponseHandler extends ResponseEntityExceptionHandler {

  // 400
  @Override
  protected ResponseEntity<Object> handleHttpMessageNotReadable(
      final HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
    return handleExceptionInternal(ex, message(HttpStatus.BAD_REQUEST, ex), headers, HttpStatus.BAD_REQUEST, request);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
    return handleExceptionInternal(ex, message(HttpStatus.BAD_REQUEST, ex), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
  }

  @ExceptionHandler(DataIntegrityViolationException.class)
  protected ResponseEntity<Object> handleBadRequest (
      final DataIntegrityViolationException ex, final WebRequest request) {
    return handleExceptionInternal(ex, message(HttpStatus.BAD_REQUEST, ex), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  protected ResponseEntity<Object> constraintViolation (
      final ConstraintViolationException  ex, final WebRequest request) {
    return handleExceptionInternal(ex, message(HttpStatus.BAD_REQUEST, ex), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
  }


  // 404
  @ExceptionHandler({EntityNotFoundException.class})
  protected ResponseEntity<Object> handleEntityNotFoundException(
      final EntityNotFoundException ex, final WebRequest request) {
    return handleExceptionInternal(ex, message(HttpStatus.NOT_FOUND, ex), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
  }


  @ExceptionHandler({ NullPointerException.class, IllegalArgumentException.class, IllegalStateException.class })
  public ResponseEntity<Object> handleInternal(final RuntimeException ex, final WebRequest request) {
    return handleExceptionInternal(ex, message(HttpStatus.INTERNAL_SERVER_ERROR, ex), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
  }


  private ApiError message(final HttpStatus status, final Exception ex) {
    String message = ex.getMessage() == null ? ex.getClass().getSimpleName() : ex.getMessage();
    String devMessage = ExceptionUtils.getRootCauseMessage(ex);
    return new ApiError(message, status.value(), devMessage);
  }

  private final class ApiError {
    private int status;
    private String message;
    private String details;

    public ApiError(String message, int status, String detailedMessage) {
      this.message = message;
      this.status = status;
      this.details = detailedMessage;
    }

    public String getMessage() {
      return message;
    }

    public ApiError setMessage(String message) {
      this.message = message;
      return this;
    }

    public String getDetails() {
      return details;
    }

    public ApiError setDetails(String details) {
      this.details = details;
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
