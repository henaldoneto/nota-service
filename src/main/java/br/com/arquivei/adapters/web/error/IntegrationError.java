package br.com.arquivei.adapters.web.error;

import br.com.arquivei.domain.exception.IntegrationExceptionType;
import lombok.*;

import java.io.Serializable;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
@RequiredArgsConstructor(staticName = "of")
public class IntegrationError implements Serializable {

    @NonNull
    private IntegrationExceptionType type;

    @NonNull
    private String message;
    private List<ValidationError> errors;

}
