package br.com.arquivei.domain.service.nota;

import br.com.arquivei.adapters.web.NfeSandboxClient;
import br.com.arquivei.application.nota.NotaFactory;
import br.com.arquivei.application.nota.dto.NfeDTO;
import br.com.arquivei.application.nota.dto.NfeSandboxResponse;
import br.com.arquivei.domain.model.Nota;
import br.com.arquivei.shared.NotaNotFoundException;
import br.com.arquivei.shared.NotaQuery;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NotaDomainService implements NotaService {

    private final NotaRepository notaRepository;
    private final NfeSandboxClient nfeSandboxClient;

    public NotaDomainService(NotaRepository notaRepository, NfeSandboxClient nfeSandboxClient) {
        this.notaRepository = notaRepository;
        this.nfeSandboxClient = nfeSandboxClient;
    }

    @Override
    public Nota findByAccessKey(String accessKey) {
        return notaRepository.findByAccessKey(accessKey).orElseThrow(NotaNotFoundException::new);
    }

    @Override
    public Page<Nota> find(NotaQuery query) {
        return notaRepository.find(query);
    }

    @Override
    public void save(Nota nota) {
        notaRepository.save(nota);
    }

    @Override
    public void receiveNfe() {
        NfeSandboxResponse receivedNfe = nfeSandboxClient.getReceivedNfe();

        List<NfeDTO> notas = receivedNfe.getData();
        notas.stream().map(NotaFactory::createNotaFromNfe).forEach(notaRepository::save);

    }
}
