package br.com.arquivei.application.nota.dto.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class InfNfe {

    @XStreamAlias("total")
    private Total total;

    public Total getTotal() {
        return total;
    }

}
