package br.com.arquivei.application.nota;

import br.com.arquivei.application.nota.dto.NotaDTO;
import br.com.arquivei.domain.model.Nota;
import br.com.arquivei.domain.service.nota.NotaService;
import br.com.arquivei.shared.NotaQuery;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.com.arquivei.application.nota.NotaFactory.createNotaDTO;

@Service
@Transactional
public class NotaApplicationService {

    private final NotaService notaService;

    public NotaApplicationService(NotaService notaService) {
        this.notaService = notaService;
    }

    public NotaDTO findByAccessKey(String accessKey){
        var nota = notaService.findByAccessKey(accessKey);
        return createNotaDTO(nota);
    }

    public Page<NotaDTO> find(NotaQuery query){
        var page = notaService.find(query);
        return page.map(NotaFactory::createNotaDTO);
    }

    public void save(Nota nota){
        notaService.save(nota);
    }

    public void receiveNfe(){
        notaService.receiveNfe();
    }

}
