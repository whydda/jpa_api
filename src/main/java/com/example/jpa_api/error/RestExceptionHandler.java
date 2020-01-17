package com.example.jpa_api.error;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler {

	protected ResponseEntity<Object> handleHttpMessageNotReadable(
		HttpMessageNotReadableException ex,
		HttpHeaders headers,
		HttpStatus status,
		WebRequest request) {

		String error = "Malformed JSON request";
		return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
	}

	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

	@ExceptionHandler({ResourceExistsException.class, IllegalArgumentException.class})
	protected ResponseEntity<Object> handleUnprocessableEntity(
		RuntimeException ex) {
		ApiError apiError = new ApiError(HttpStatus.UNPROCESSABLE_ENTITY);
		apiError.setMessage(ex.getMessage());
		return buildResponseEntity(apiError);
	}

}
