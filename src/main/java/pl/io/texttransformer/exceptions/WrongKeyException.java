package pl.io.texttransformer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Key must contain only letters")
public class WrongKeyException extends RuntimeException {
}
