import java.io.*;

class DataStreamExample {

	public static void main(String [] args) throws Exception {
	
		FileOutputStream f = new FileOutputStream("somefile");
		DataOutputStream out = new DataOutputStream(f);


		int x=1;
		String y = "zzz";
		out.writeUTF(y);
		out.writeInt(x);
		out.flush();

        FileInputStream fin = new FileInputStream("./somefile");
        DataInputStream in = new DataInputStream(fin);

        String input = in.readUTF();
        Integer num = in.readInt();
        System.out.println(input+num.toString());
	}
}