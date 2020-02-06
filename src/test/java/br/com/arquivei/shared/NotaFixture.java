package br.com.arquivei.shared;

import br.com.arquivei.domain.model.Nota;

import static br.com.arquivei.shared.TestConstants.*;

public final class NotaFixture {

    private NotaFixture(){}

    public static Nota getNota(){
        var nota = Nota.builder().build();
        return nota.accessKey(ACCESS_KEY)
                .valor(VALOR_467_75)
                .xml(XML_NOTA);
    }
}
