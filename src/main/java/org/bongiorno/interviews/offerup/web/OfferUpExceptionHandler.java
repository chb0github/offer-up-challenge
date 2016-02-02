package org.bongiorno.interviews.offerup.web;

import org.bongiorno.interviews.offerup.dto.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class OfferUpExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({BadRequestException.class, ResourceNotFoundException.class})
    protected ResponseEntity<Object> handleBadRequest(RuntimeException e, WebRequest request) {

        ResponseStatus annotation = e.getClass().getAnnotation(ResponseStatus.class);
        HttpStatus httpStatus = annotation.value();

        ErrorResponse response = new ErrorResponse(httpStatus.value(), e.getMessage());

        return handleExceptionInternal(e, response, new HttpHeaders(), httpStatus, request);
    }
}
