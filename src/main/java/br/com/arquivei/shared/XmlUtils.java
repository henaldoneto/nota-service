package br.com.arquivei.shared;

import br.com.arquivei.application.nota.dto.xml.Nfe;
import br.com.arquivei.application.nota.dto.xml.NfeProc;
import com.thoughtworks.xstream.XStream;

import java.math.BigDecimal;

public final class XmlUtils {

    public static final String NFE_PROC_FIELD = "<nfeProc";

    public static BigDecimal getNfValueFromXml(String xml){

        XStream xstream = new XStream();
        xstream.ignoreUnknownElements();
        xstream.processAnnotations(NfeProc.class);
        xstream.processAnnotations(Nfe.class);

        if(xml.contains(NFE_PROC_FIELD)){
            var nfeProc = (NfeProc) xstream.fromXML(xml);
            return nfeProc.getValorTotalNf();
        }else {
            var nfe = (Nfe) xstream.fromXML(xml);
            return nfe.getValorTotalNf();
        }

    }
}
