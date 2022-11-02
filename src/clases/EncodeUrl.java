/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.net.*;
import java.util.Base64;

public class EncodeUrl {

    public String encode(String q) throws MalformedURLException {
        String finalEncodedUrl = "";
        URL urlToEncode = new URL(q);

        try {
            URI uri = new URI(urlToEncode.getProtocol(),
                    urlToEncode.getUserInfo(),
                    IDN.toASCII(urlToEncode.getHost()),
                    urlToEncode.getPort(),
                    urlToEncode.getPath(),
                    urlToEncode.getQuery(), urlToEncode.getRef());

            finalEncodedUrl = uri.toASCIIString();

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return finalEncodedUrl;
    }

    public String encode64(String string) {
        
        String encodedString = Base64.getEncoder().encodeToString(string.getBytes());
        return encodedString;
    }

}
