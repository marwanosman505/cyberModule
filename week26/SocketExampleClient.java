import java.io.*;
import java.net.*;

class SocketExampleClient {

	public static void main(String [] args) throws Exception {

		String host = "localhost"; // hostname of server
		int port = 5678;           // port of server

		try {
			Socket s = new Socket(host, port);
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			DataInputStream dis = new DataInputStream(s.getInputStream());

			dos.writeUTF("Hello World!");
			dos.writeUTF("Happy new year!");
			dos.flush();

			String x = null;


			while ((x = dis.readUTF()) != null) {
				System.out.println(x);
				s.close();
			}

			}
		catch(IOException e) {
			System.err.println("Server closed its connection.");
		}catch (Exception e) {
			System.err.println("Cannot connect to server.");
		} 	

	}
}
