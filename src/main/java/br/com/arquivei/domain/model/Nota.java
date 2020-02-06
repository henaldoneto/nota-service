package br.com.arquivei.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Builder
@Accessors(fluent = true)
@AllArgsConstructor(onConstructor_ = @Builder)
@NoArgsConstructor
@Entity
public class Nota {

    @Id
    private String accessKey;
    private BigDecimal valor;
    @Column(columnDefinition="TEXT")
    private String xml;


}
