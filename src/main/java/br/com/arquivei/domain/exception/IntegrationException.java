package br.com.arquivei.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

@Getter
@Accessors(fluent = true)
@AllArgsConstructor
public abstract class IntegrationException extends RuntimeException {

    private final HttpStatus status;
    private final IntegrationExceptionType type;
    private final String message;

}
