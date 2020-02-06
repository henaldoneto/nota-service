package br.com.arquivei.shared;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class NotaQuery {

    private Integer pageNumber = 0;
    private Integer pageSize = 10;
}
