/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Modelo.Util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author inftel08
 */
public class MD5Signature {

    public static String generateMD5Signature(String input){
        byte[] huella = null;
        String res = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            huella = md.digest(input.getBytes());
            res = transformaAHexadecimal(huella);
            
        } catch (NoSuchAlgorithmException | NullPointerException ex) {
            Logger.getLogger(MD5Signature.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    private static String transformaAHexadecimal(byte buf[]) {
        StringBuilder strbuf = new StringBuilder(buf.length * 2);
        for (int i = 0; i < buf.length; i++) {
            if (((int) buf[i] & 0xff) < 0x10) {
                strbuf.append("0");
            }
            strbuf.append(Long.toString((int) buf[i] & 0xff, 16));
        }
        return strbuf.toString();
    }

}
