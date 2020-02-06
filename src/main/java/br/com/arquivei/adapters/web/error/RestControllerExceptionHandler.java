package br.com.arquivei.adapters.web.error;


import br.com.arquivei.domain.exception.IntegrationException;
import br.com.arquivei.shared.NotaNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static br.com.arquivei.domain.exception.IntegrationExceptionType.NOT_NULL;
import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.*;

@RestControllerAdvice
public class RestControllerExceptionHandler {

    @InitBinder
    public void activateDirectFieldAccess(DataBinder dataBinder) {
        dataBinder.initDirectFieldAccess();
    }

    @ExceptionHandler(IntegrationException.class)
    public ResponseEntity<IntegrationError> handleIntegrationException(IntegrationException ex) {
        IntegrationError error = IntegrationError.of(ex.type(), ex.message());

        return status(ex.status()).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<IntegrationError> handleConstraintViolationException(MethodArgumentNotValidException ex) {
        IntegrationError error = IntegrationError.of(NOT_NULL, "Parâmetros inválidos.");

        List<ValidationError> validationErrors =
            ex.getBindingResult().getFieldErrors().stream().map(f -> ValidationError.of(f.getField(),
                f.getRejectedValue(), f.getDefaultMessage(), Constraint.of(f.getCode()))).collect(toList());

        error.setErrors(validationErrors);

        return badRequest().body(error);
    }

    @ExceptionHandler(NotaNotFoundException.class)
    public ResponseEntity<Void> saleNotFoundExceptionException(NotaNotFoundException ex) {

        return notFound().build();
    }

}
