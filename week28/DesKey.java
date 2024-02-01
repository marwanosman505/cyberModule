package week28;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.security.Key;
import javax.crypto.SecretKey;
import javax.crypto.KeyGenerator;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

public class DesKey {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        // generate random DES key
        KeyGenerator kg = KeyGenerator.getInstance("DES");
        kg.init(new SecureRandom());
        SecretKey key = kg.generateKey();
        System.out.println(key.getEncoded());

        // convert byte to String
        Base64.Encoder encoder = Base64.getEncoder();
        String hexValues = encoder.encodeToString(key.getEncoded());
        System.out.println(hexValues);

        // convert byte to HEX array
        System.out.println(Arrays.toString(key.getEncoded()));
    }

}
