package br.com.arquivei.adapters.web;

import br.com.arquivei.application.nota.dto.NfeSandboxResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

@FeignClient(value = "sandbox-api", url = "${api.sandbox-api}")
public interface NfeSandboxFeignClient {

    @GetMapping(value = "/v1/nfe/received")
    NfeSandboxResponse getNfeReceived(@RequestHeader Map<String, String> headerMap);

}
