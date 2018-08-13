package com.dkmaia.mongo.doman.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dkmaia.mongo.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourcesExceptinHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e,
			HttpServletRequest request) {

		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não Encontratdo",
				e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
