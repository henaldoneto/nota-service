package br.com.arquivei.application.nota;

import br.com.arquivei.application.nota.dto.NfeDTO;
import br.com.arquivei.application.nota.dto.NotaDTO;
import br.com.arquivei.domain.model.Nota;

import static br.com.arquivei.shared.Base64Utils.decode;
import static br.com.arquivei.shared.XmlUtils.getNfValueFromXml;

public final class NotaFactory {

    private NotaFactory(){
    }

    public static NotaDTO createNotaDTO(Nota nota){
        return  NotaDTO.builder()
                .accessKey(nota.accessKey())
                .valor(nota.valor())
                .build();
    }

    public static Nota createNotaFromNfe(NfeDTO nfeDTO){
        var xml = decode(nfeDTO.xml());
        return  Nota.builder()
                .accessKey(nfeDTO.accessKey())
                .xml(xml)
                .valor(getNfValueFromXml(xml))
                .build();
    }

}
