package br.com.arquivei.adapters.web;

import br.com.arquivei.application.nota.NotaApplicationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("v1/nfe")
public class NfeController {

    private final NotaApplicationService notaApplicationService;

    public NfeController(NotaApplicationService notaApplicationService) {
        this.notaApplicationService = notaApplicationService;
    }

    @GetMapping("/receive")
    @ApiOperation(value = "Receive/Import NFEs from Arquivei Sandbox Nfes Api")
    public ResponseEntity<Void> received(){
        notaApplicationService.receiveNfe();
        return ok().build();
    }

}
