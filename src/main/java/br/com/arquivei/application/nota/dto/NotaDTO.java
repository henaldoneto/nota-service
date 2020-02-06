package br.com.arquivei.application.nota.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


@Builder
@Data
public class NotaDTO {

    private String accessKey;
    private BigDecimal valor;

}
