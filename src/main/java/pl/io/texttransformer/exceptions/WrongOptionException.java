package pl.io.texttransformer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Option must be either 'decipher' or 'cipher'")
public class WrongOptionException extends RuntimeException {
}
