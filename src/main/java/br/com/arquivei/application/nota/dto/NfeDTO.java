package br.com.arquivei.application.nota.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.sql.Clob;
import java.util.UUID;

@Data
@Builder
@Accessors(fluent = true)
@AllArgsConstructor(onConstructor_ = @Builder)
@NoArgsConstructor
public class NfeDTO {

    @JsonProperty("access_key")
    private String accessKey;
    @JsonProperty("xml")
    private String xml;

}
