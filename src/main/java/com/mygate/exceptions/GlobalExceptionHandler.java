package com.mygate.exceptions;

import java.time.LocalDateTime;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mygate.models.CustomError;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		headers.add("desc", "Method not supported");
		String message = ex.getMessage();
		CustomError customError = new CustomError(LocalDateTime.now(),message, status);
		return ResponseEntity.ok().headers(headers).body(customError);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		headers.add("desc", "Media Type not supported");
		String message = ex.getMessage();
		CustomError customError = new CustomError(LocalDateTime.now(),message, status);
		return ResponseEntity.ok().headers(headers).body(customError);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		headers.add("desc", "Media Type not acceptable");
		String message = ex.getMessage();
		CustomError customError = new CustomError(LocalDateTime.now(),message, status);
		return ResponseEntity.ok().headers(headers).body(customError);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		headers.add("desc", "Missing Path Variable");
		String message = ex.getMessage();
		CustomError customError = new CustomError(LocalDateTime.now(),message, status);
		return ResponseEntity.ok().headers(headers).body(customError);
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		headers.add("desc", "Internal Server Error is occured");
		String message = ex.getMessage();
		CustomError customError = new CustomError(LocalDateTime.now(),message, status);
		return ResponseEntity.ok().headers(headers).body(customError);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		headers.add("desc", "Type miss match");
		String message = ex.getMessage();
		CustomError customError = new CustomError(LocalDateTime.now(),message, status);
		return ResponseEntity.ok().headers(headers).body(customError);
	}
	
	@ExceptionHandler(GuardNotFoundException.class)
	public final ResponseEntity<Object> handleGuardBorFoundException(GuardNotFoundException ex){
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Guard not found");
		String message = "Guard not found";
		CustomError customError = new CustomError(LocalDateTime.now(),message,HttpStatus.NOT_FOUND);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).body(customError);
	}
	
	@ExceptionHandler(LessorNotFoundException.class)
	public final ResponseEntity<Object> handleLessorNotFoundException(LessorNotFoundException ex){
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Lessor not found");
		String message = "Lessor not found";
		CustomError customError = new CustomError(LocalDateTime.now(),message,HttpStatus.NOT_FOUND);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).body(customError);
	}
	
	@ExceptionHandler(AdminNotFoundException.class)
	public final ResponseEntity<Object> handleLessorNotFoundException(AdminNotFoundException ex){
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Admin not found");
		String message = "Admin not found";
		CustomError customError = new CustomError(LocalDateTime.now(),message,HttpStatus.NOT_FOUND);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).body(customError);
	}
	
	@ExceptionHandler(GatepassNotFoundException.class)
	public final ResponseEntity<Object> gatepassNotFoundException(GatepassNotFoundException ex){
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "gatepass not found");
		String message = "gatepass not found";
		CustomError customError = new CustomError(LocalDateTime.now(),message,HttpStatus.NOT_FOUND);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).body(customError);
	}
	
	@ExceptionHandler(RequestForApprovalNotFound.class)
	public final ResponseEntity<Object> approvalNotFoundException(RequestForApprovalNotFound ex){
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Requested Approval not found");
		String message = "Requested Approval not found";
		CustomError customError = new CustomError(LocalDateTime.now(),message,HttpStatus.NOT_FOUND);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).body(customError);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleException(Exception ex){
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "exception occured ....");
		String message = ex.getMessage();
		CustomError errors = new CustomError(LocalDateTime.now(),message,HttpStatus.EXPECTATION_FAILED);
		
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).headers(header).body(errors);
	}
}
