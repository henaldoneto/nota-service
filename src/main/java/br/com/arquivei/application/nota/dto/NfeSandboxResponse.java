package br.com.arquivei.application.nota.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@ToString
@Value
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class NfeSandboxResponse implements Serializable {

    List<NfeDTO> data;
}
