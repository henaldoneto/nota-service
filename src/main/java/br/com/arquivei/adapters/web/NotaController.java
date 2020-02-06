package br.com.arquivei.adapters.web;

import br.com.arquivei.application.nota.NotaApplicationService;
import br.com.arquivei.application.nota.dto.NotaDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("v1/nota")
public class NotaController {

    private final NotaApplicationService notaApplicationService;

    public NotaController(NotaApplicationService notaApplicationService) {
        this.notaApplicationService = notaApplicationService;
    }

    @GetMapping("/{accessKey}")
    @ApiOperation(value = "Recover Nota by Access Key", response = NotaDTO.class)
    public ResponseEntity<NotaDTO> consultarNota(@PathVariable String accessKey){
        var nota = notaApplicationService.findByAccessKey(accessKey);
        return ok(nota);
    }

}
