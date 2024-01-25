
package week27;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

/**
 * bytes
 */
public class bytes {

    public static void main(String[] args) {
        byte[] b = {0x12, 0x34, 0x56, 0x78, (byte)0x9A, (byte)0xBC, (byte)0xDE, (byte)0xF0}; // 8-byte array
        System.out.println(b[0]);
        
        // DISPLAYING BYTES
        try {
            String s = new String(b);
            System.out.println(s);
        } catch (Exception e) {
            System.err.println(e);
            // TODO: handle exception
        }

        System.out.println(Arrays.toString(b));

        try {
            String s2 = "hello world";
            byte[] b2 = s2.getBytes("UTF8");
            System.out.println(b2);
            String s3 = new String(b2, "UTF8");
            System.out.println(s3);
            
        } catch (Exception e) {
            System.err.println(e);
        }

        // HEXADECIMAL CONVERSION
        byte[] input = {0x5F, 0x43, 0x20};
        StringBuilder sb = new StringBuilder();
        for (byte b3 : input) sb.append(String.format("%02X", b3));
        String sHex = sb.toString();
        System.out.println(sHex);

        // BASE 64 
        byte[] b4 = {0x12, 0x34, 0x56, 0x78, (byte)0x9A, (byte)0xBC, (byte)0xDE, (byte)0xF0}; // 8-byte array
        Base64.Encoder encoder64 = Base64.getEncoder();
        String s2 = encoder64.encodeToString(b4);
        System.out.println(s2);
    }
}