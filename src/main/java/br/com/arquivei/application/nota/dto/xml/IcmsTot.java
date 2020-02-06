package br.com.arquivei.application.nota.dto.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.math.BigDecimal;

public class IcmsTot {

    @XStreamAlias("vNF")
    private BigDecimal vnf;

    public BigDecimal getVnf() {
        return vnf;
    }
}
