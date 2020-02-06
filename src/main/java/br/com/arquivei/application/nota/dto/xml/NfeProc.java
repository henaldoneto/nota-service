package br.com.arquivei.application.nota.dto.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.math.BigDecimal;

@XStreamAlias("nfeProc")
public class NfeProc {

    @XStreamAlias("NFe")
    private Nfe nfe;

    public BigDecimal getValorTotalNf(){
        return nfe.getInfNfe().getTotal().getIcmsTot().getVnf();
    }

}
