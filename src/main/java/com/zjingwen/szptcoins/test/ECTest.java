package com.zjingwen.szptcoins.test;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.Cipher;

import org.bouncycastle.jce.interfaces.ECPrivateKey;
import org.bouncycastle.jce.interfaces.ECPublicKey;

public class ECTest {

    static {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    }

    public static void main(String[] argu) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC",
                "BC");
        keyPairGenerator.initialize(256, new SecureRandom());

        KeyPair kp = keyPairGenerator.generateKeyPair();

        ECPublicKey publicKey = (ECPublicKey) kp.getPublic();
        ECPrivateKey privateKey = (ECPrivateKey) kp.getPrivate();

        System.out.println(kp.getPrivate());
        System.out.println(kp.getPublic());

        Cipher encrypter = Cipher.getInstance("ECIES", "BC");
        Cipher decrypter = Cipher.getInstance("ECIES", "BC");
        encrypter.init(Cipher.ENCRYPT_MODE, publicKey);
        decrypter.init(Cipher.DECRYPT_MODE, privateKey);

        String text = "";
        for (int i = 0; i < 1024; i++) {
            text += "This is a test!@#$This is a test!@#$This is a test!@#This is a test!@#$This is a test!@#$This is a test!@#This is a test!@#$This is a test!@#$This is a test!@#";
        }
        byte[] e = encrypter.doFinal(text.getBytes("UTF-8"));

        // System.out.println("Encrypted: " + Arrays.toString(e));  

        System.out.println("Encrypted, length = " + e.length);

        byte[] de = decrypter.doFinal(e);
        String result = new String(de, "UTF-8");

        // System.out.println("Decrypted :" + result);  
        if (result.equals(text)) {
            System.out.println("OK!");
        }
    }
} 