package br.com.arquivei.adapters.web;

import br.com.arquivei.application.nota.dto.NfeSandboxResponse;
import br.com.arquivei.domain.service.nfesandbox.NfeSandboxRepository;
import br.com.arquivei.shared.FeignUtils;
import br.com.arquivei.shared.NotaNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class NfeSandboxClient implements NfeSandboxRepository {

    private final NfeSandboxFeignClient nfeSandboxFeignClient;

    public NfeSandboxClient(NfeSandboxFeignClient nfeSandboxFeignClient) {
        this.nfeSandboxFeignClient = nfeSandboxFeignClient;
    }

    @Override
    public NfeSandboxResponse getReceivedNfe() {

        Map<String, String> headers = new HashMap<>();
        headers.put("x-api-id", "f96ae22f7c5d74fa4d78e764563d52811570588e");
        headers.put("x-api-key", "cc79ee9464257c9e1901703e04ac9f86b0f387c2");
        headers.put("Content-Type", "application/json");

        var response = FeignUtils.catchFeignException(() -> nfeSandboxFeignClient.getNfeReceived(headers)).orElseThrow(NotaNotFoundException::new);

        return response;
    }

}
