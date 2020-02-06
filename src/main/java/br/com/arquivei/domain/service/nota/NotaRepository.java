package br.com.arquivei.domain.service.nota;

import br.com.arquivei.domain.model.Nota;
import br.com.arquivei.shared.NotaQuery;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface NotaRepository {

    Nota save(Nota nota);

    Optional<Nota> findByAccessKey(String accessKey);

    Page<Nota> find(NotaQuery query);

}
