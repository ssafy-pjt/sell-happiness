package com.sfs.sellhappiness.global.util;

import io.jsonwebtoken.io.Encoders;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Base64Encode {

    public static String encode(String key) throws NoSuchAlgorithmException {
//        MessageDigest digest = MessageDigest.getInstance("SHA-256");
//        byte[] bytes = key.getBytes();
//        byte[] digestBytes = digest.digest(bytes);

        return Encoders.BASE64.encode(key.getBytes(StandardCharsets.UTF_8));
//        return String.format("%064x", new java.math.BigInteger(1, digestBytes));
    }

}
