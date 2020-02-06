package br.com.arquivei.application.nota.dto.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class Total {

    @XStreamAlias("ICMSTot")
    private IcmsTot icmsTot;

    public IcmsTot getIcmsTot() {
        return icmsTot;
    }
}
