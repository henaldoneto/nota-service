package br.com.arquivei.adapters.repository.nota;

import br.com.arquivei.domain.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface NotaRepositorySpringData extends JpaRepository<Nota, UUID> {

    Optional<Nota> findByAccessKey(String accessKey);

}
