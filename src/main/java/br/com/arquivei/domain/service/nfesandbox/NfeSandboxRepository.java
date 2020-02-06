package br.com.arquivei.domain.service.nfesandbox;

import br.com.arquivei.application.nota.dto.NfeSandboxResponse;

public interface NfeSandboxRepository {

    NfeSandboxResponse getReceivedNfe();

}
