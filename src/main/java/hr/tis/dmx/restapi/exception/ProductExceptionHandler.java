package hr.tis.dmx.restapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class ProductExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

		log.error("MethodArgumentNotValidException thrown; sent request: {}", request);

		String errorMessage = "Validation failed for arguments";
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, errorMessage, errors);
		return buildResponseEntity(apiError);
	}

	@ExceptionHandler(ProductCreationException.class)
	public ResponseEntity<Object> handleProductCreationException(ProductCreationException ex, WebRequest request) {
		log.error("ProductCreationException thrown; sent request: {}", request);

		String errorMessage = ex.getMessage();
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, errorMessage, "Error during product creation");
		return buildResponseEntity(apiError);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, WebRequest request) {
		log.error("HttpMessageNotReadableException thrown; sent request: {}", request);

		String error = "Malformed JSON request";
		return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex.getLocalizedMessage()));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		log.error("Exception thrown; sent request: {}", request);

		ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), "An unexpected error occurred");
		return buildResponseEntity(apiError);
	}

	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

	@Getter
	@Setter
	@AllArgsConstructor
	static class ApiError {

		private HttpStatus status;
		private String message;
		private Object errors;
	}
}
