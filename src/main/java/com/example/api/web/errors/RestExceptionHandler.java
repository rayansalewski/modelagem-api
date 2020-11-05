package com.example.api.web.errors;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class RestExceptionHandler {


	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorDTO handleConstraintViolationException(ConstraintViolationException ex, HttpServletRequest request) {

		// @formatter:off		
		ErrorDTO details = ErrorDTO.builder()
				.timestamp(LocalDateTime.now())
				.path(request.getRequestURI())
				.build();
		// @formatter:on

		ex.getConstraintViolations().forEach(violation -> {
			details.addViolation(violation.getPropertyPath().toString(), violation.getMessage());
		});

		return details;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorDTO handleMethodArgumentNotValidException(MethodArgumentNotValidException ex,
			HttpServletRequest request) {
		// @formatter:off
		ErrorDTO details = ErrorDTO.builder()
				.timestamp(LocalDateTime.now())
				.error("Bad Request")
				.path(request.getRequestURI()).build();
		// @formatter:on

		BindingResult result = ex.getBindingResult();

		List<ObjectError> globalErrors = result.getGlobalErrors();
		globalErrors.forEach(objectError -> {
			details.addViolation(objectError.getObjectName(), objectError.getDefaultMessage());
		});

		List<FieldError> fieldErrors = result.getFieldErrors();
		fieldErrors.forEach(fieldError -> {
			details.addViolation(fieldError.getField(), fieldError.getDefaultMessage());
		});

		return details;
	}


	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	private ErrorDTO handleHttpMessageNotReadableException(HttpMessageNotReadableException e,
			HttpServletRequest request) {

		// @formatter:off
		return ErrorDTO.builder()
				.timestamp(LocalDateTime.now())
				.path(request.getRequestURI())
				.build(); 
		// @formatter:on				
	}
}
