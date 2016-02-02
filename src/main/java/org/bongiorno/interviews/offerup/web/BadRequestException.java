package org.bongiorno.interviews.offerup.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "Bad query params")
public class BadRequestException extends RuntimeException{
    public BadRequestException(String mess) {
        super(mess);
    }
}
