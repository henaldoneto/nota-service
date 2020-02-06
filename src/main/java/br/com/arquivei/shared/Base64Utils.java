package br.com.arquivei.shared;

import java.util.Base64;

public final class Base64Utils {

    public static String decode(String encodedString){
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        var decodedString = new String(decodedBytes);
        return decodedString;
    }
}
