package pl.io.texttransformer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Unknown transformation")
public class UnknownTransformException extends RuntimeException {
}
