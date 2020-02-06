package br.com.arquivei.application.nota.dto.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.math.BigDecimal;

@XStreamAlias("NFe")
public class Nfe {

    @XStreamAlias("infNFe")
    private InfNfe infNfe;

    public InfNfe getInfNfe() {
        return infNfe;
    }

    public BigDecimal getValorTotalNf(){
        return infNfe.getTotal().getIcmsTot().getVnf();
    }
}
