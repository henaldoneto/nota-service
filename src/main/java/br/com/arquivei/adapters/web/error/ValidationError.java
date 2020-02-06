package br.com.arquivei.adapters.web.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import static lombok.AccessLevel.PRIVATE;

@Data
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(staticName = "of")
public class ValidationError implements Serializable {

    private String property;
    private Object value;
    private String message;
    private Constraint constraint;

}
