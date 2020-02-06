package br.com.arquivei.domain.service.nota;

import br.com.arquivei.domain.model.Nota;
import br.com.arquivei.shared.NotaQuery;
import org.springframework.data.domain.Page;

public interface NotaService {

    Nota findByAccessKey(String accessKey);

    Page<Nota> find(NotaQuery query);

    void save(Nota nota);

    void receiveNfe();

}
