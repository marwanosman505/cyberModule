package week27;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class fileToBytes {
    public static void main(String[] args) {
        try {
            // read file to java byte array
            FileInputStream fis = new FileInputStream("C:\\Users\\defpr\\Programs\\cyberModule\\week27\\myfile.pdf");
            byte[] data = new byte[8];
            fis.read(data);
            System.err.println(data);

            // convert byte to hex string
            StringBuilder sb = new StringBuilder();
            for (byte b : data) sb.append(String.format("%02X", b));
            String s = sb.toString();
            System.out.println(s);
            fis.close();
        } catch (FileNotFoundException e) {
            System.err.println(e);        
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
