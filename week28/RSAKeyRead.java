package week28;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSAKeyRead {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException{
        // retrieve key files
        File f1 = new File("C:\\Users\\defpr\\Programs\\cyberModule\\week28\\mo242.prv");
        File f2 = new File("C:\\Users\\defpr\\Programs\\cyberModule\\week28\\mo242.pub");
        byte[] prvKeyBytes = Files.readAllBytes(f1.toPath());
        byte[] pubKeyBytes = Files.readAllBytes(f2.toPath());

        // convert keys from byte format to keySpec format for reading
        PKCS8EncodedKeySpec prvSpec = new PKCS8EncodedKeySpec(prvKeyBytes);
        X509EncodedKeySpec pubSpec = new X509EncodedKeySpec(pubKeyBytes);
        
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        RSAPrivateKey privateKey = (RSAPrivateKey) keyFactory.generatePrivate(prvSpec);
        RSAPublicKey publicKey = (RSAPublicKey) keyFactory.generatePublic(pubSpec);

        // output modulus and exponents to console
        BigInteger n = publicKey.getModulus();
        BigInteger e = publicKey.getPublicExponent();
        BigInteger d = privateKey.getPrivateExponent();
        System.out.println("modulus: "+n);
        System.out.println("public key exponent: "+e);
        System.out.println("private key exponent: "+d);
    }
}
