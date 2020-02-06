package br.com.arquivei.adapters.repository.nota;

import br.com.arquivei.domain.model.Nota;
import br.com.arquivei.domain.service.nota.NotaRepository;
import br.com.arquivei.shared.NotaQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class NotaRepositoryJpa implements NotaRepository {

    private final NotaRepositorySpringData delegate;

    public NotaRepositoryJpa(NotaRepositorySpringData delegate) {
        this.delegate = delegate;
    }

    @Override
    public Nota save(Nota nota) {
        return delegate.save(nota);
    }

    @Override
    public Optional<Nota> findByAccessKey(String accessKey) {
        return delegate.findByAccessKey(accessKey);
    }

    @Override
    public Page<Nota> find(NotaQuery query) {
        var page = PageRequest.of(query.getPageNumber(), query.getPageSize());
        return delegate.findAll(page);
    }

}
