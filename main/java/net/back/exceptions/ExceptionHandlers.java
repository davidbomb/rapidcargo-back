package net.back.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class ExceptionHandlers {
	
	private Logger log = LoggerFactory.getLogger(ExceptionHandlers.class);
    
	/**
	 * The method generate an error response about server error
	 * 
	 * @param ex : the exception
	 * @return an error response
	 */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ErrorResponse handleThrowable(final Throwable ex) {
        log.error("Unexpected Error", ex);
        return new ErrorResponse("INTERNAL_SERVER_ERROR", "An unexpected internal server error occurred");
    }

    /**
     * The method generate an error response about authentication
     * 
     * @param ex : the exception
     * @return an error response
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AuthenticateException.class)
    @ResponseBody
    public ErrorResponse handleAuthenticateThrowable(final AuthenticateException ex) {
        log.error("Unexpected Error", ex);
        return new ErrorResponse("UNAUTH", ex.getMessage());
    }
    
    /**
     * The method generate an error response about an element not found
     * 
     * @param ex : the exception
     * @return an error response
     */
    @ExceptionHandler(InnovathequeNotFoundException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handlerInnovathequeNotFoundException(final InnovathequeNotFoundException ex) {
    	log.error(ex.getMessage(), ex);
    	ErrorResponse err = new ErrorResponse("NOT_FOUND", ex.getMessage());
    	return new ResponseEntity<ErrorResponse>(err, HttpStatus.NOT_FOUND);
    }
    
    /**
     * The method generate an error response about missing information
     * 
     * @param ex : the exception
     * @return a response entity containing an error response
     */
    @ExceptionHandler(InnovathequeMissingInformationException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handlerInnovathequeMissingInformationException(final InnovathequeMissingInformationException ex) {
    	log.error(ex.getMessage(), ex);
    	ErrorResponse err = new ErrorResponse("UNPROCESSABLE_ENTITY", ex.getMessage());
    	return new ResponseEntity<ErrorResponse>(err, HttpStatus.UNPROCESSABLE_ENTITY);
    }
    
    /**
     * The method generate an error response about unauthorized action
     * 
     * @param ex : the exception
     * @return a response entity containing an error response
     */
    @ExceptionHandler(InnovathequeUnAuthorizedException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handlerInnovathequeUnAuthorizedException(final InnovathequeUnAuthorizedException ex) {
    	log.error(ex.getMessage(), ex);
    	ErrorResponse err = new ErrorResponse("UNAUTHORIZED_METHOD", ex.getMessage());
    	return new ResponseEntity<ErrorResponse>(err, HttpStatus.UNAUTHORIZED);
    }
    
    /**
     * The method generate an error response about Innovatheque
     * 
     * @param ex : the exception
     * @return a response entity containing an error response
     */
    @ExceptionHandler(InnovathequeException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handlerInnovathequeException(final InnovathequeException ex) {
    	log.error(ex.getMessage(), ex);
    	ErrorResponse err = new ErrorResponse("UNEXPECTED_SERVER_ERROR", ex.getMessage());
    	return new ResponseEntity<ErrorResponse>(err, HttpStatus.UNPROCESSABLE_ENTITY);
    }
    
    /**
     * The method generate an error response about invalid preToken
     * 
     * @param ex : the exception
     * @return a response entity containing an error response
     */
    @ExceptionHandler(InvalidPreTokenException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handlerInvalidPreTokenException(final InvalidPreTokenException ex) {
    	log.error(ex.getMessage(), ex);
    	ErrorResponse err = new ErrorResponse("INVALID_PRETOKEN_EXCEPTION", ex.getMessage());
    	return new ResponseEntity<ErrorResponse>(err, HttpStatus.BAD_REQUEST);
    }
    
    /**
     * The method generate an error response about invalid mail request
     * 
     * @param ex : the exception
     * @return a response entity containing an error response
     */
    @ExceptionHandler(InvalidMailRequestException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handlerInvalidMailRequestException(final InvalidMailRequestException ex) {
    	log.error(ex.getMessage(), ex);
    	ErrorResponse err = new ErrorResponse("INVALID_MAILREQUEST_EXCEPTION", ex.getMessage());
    	return new ResponseEntity<ErrorResponse>(err, HttpStatus.BAD_REQUEST);
    }
    
    /**
     * The method generate an error response about invalid preToken on mail sender
     * 
     * @param ex : the exception
     * @return a response entity containing an error response
     */
    @ExceptionHandler(InnovathequeMailSenderException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handlerInvalidPreTokenException(final InnovathequeMailSenderException ex) {
    	log.error(ex.getMessage(), ex);
    	ErrorResponse err = new ErrorResponse("MAIL_SENDER_EXCEPTION", ex.getMessage());
    	return new ResponseEntity<ErrorResponse>(err, HttpStatus.NOT_ACCEPTABLE);
    }
    
    /**
	 * The method generate an error response about document generation
	 * 
	 * @param ex : the exception
	 * @return an error response
	 */
    @ExceptionHandler(DocumentGenerationException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handlerDocumentGenerationException(final DocumentGenerationException ex) {
        log.error(ex.getMessage(), ex);
    	ErrorResponse err = new ErrorResponse("DOCUMENT_GENERATION_EXCEPTION", ex.getMessage());
    	return new ResponseEntity<ErrorResponse>(err, HttpStatus.SERVICE_UNAVAILABLE);
    }
    
}
