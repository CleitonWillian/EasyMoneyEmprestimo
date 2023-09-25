package br.com.easymoney.receive.rest.error;

import static java.lang.System.lineSeparator;

import java.lang.reflect.Field;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.easymoney.core.exception.base.BaseInvalidArgumentsException;
import br.com.easymoney.core.exception.base.BaseNotFoundException;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@AllArgsConstructor
@Slf4j
public class ExceptionControllerAdvice {

	@ExceptionHandler(BaseInvalidArgumentsException.class)
	public ResponseEntity<ErrorResponse> handle(BaseInvalidArgumentsException ex) {
		return new ResponseEntity<>(new ErrorResponse(ex.getTitle(), ex.getMessage()), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BaseNotFoundException.class)
	public ResponseEntity<ErrorResponse> handle(BaseNotFoundException ex) {
		return new ResponseEntity<>(new ErrorResponse(ex.getTitle(), ex.getMessage()), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(FeignException.class)
	public ResponseEntity<ErrorResponse> handle(FeignException ex) {

		try {
			return new ResponseEntity<>(new ObjectMapper().readValue(ex.contentUTF8(), ErrorResponse.class),
					HttpStatus.valueOf(ex.status()));
		} catch (Exception e) {
			log.error("Falha ao serializar feignException para ErrorResponse", e);
			return new ResponseEntity<>(
					new ErrorResponse("Erro desconhecido", "Não foi possível processar a sua solicitação."),
					HttpStatus.valueOf(ex.status()));
		}

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handle(MethodArgumentNotValidException ex) {
		Class<?> clazz = ex.getBindingResult().getTarget().getClass();

		var errorMessages = ex.getBindingResult().getFieldErrors().stream().map(fieldError -> {
			String fieldName = fieldError.getField();
			String defaultMessage = fieldError.getDefaultMessage();

			try {
				Field field = clazz.getDeclaredField(fieldName);
				JsonProperty jsonProperty = AnnotationUtils.getAnnotation(field, JsonProperty.class);
				if (jsonProperty != null) {
					fieldName = jsonProperty.value();
				}
			} catch (NoSuchFieldException e) {
				// Ignorar, usar o nome do campo como está
			}

			return "(" + fieldName + "): " + defaultMessage + ". ";
		}).toList();

		return new ResponseEntity<>(
				new ErrorResponse("Erro de validação", StringUtils.join(errorMessages, lineSeparator())),
				HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handle(Exception ex) {
		log.error("Erro inesperado não tratado", ex);
		return new ResponseEntity<>(new ErrorResponse("Erro inesperado", ex.getMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
