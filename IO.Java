import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		FileOutputStream fw = null;
		BufferedOutputStream bos = null;
		DataOutputStream dos = null;
		try {
			fw = new FileOutputStream("my-data.bin");
			bos = new BufferedOutputStream(fw);
			dos = new DataOutputStream(bos);
		
			dos.writeBoolean(true);
			dos.writeInt(10000);
			dos.writeDouble(5.55);
			dos.writeUTF("문자열 ~~");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (dos != null) {
				try {
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		DataInputStream dis = null;
		
		try {
			fis = new FileInputStream("my-data.bin");
			bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);
			
			boolean b = dis.readBoolean();
			int i = dis.readInt();
			double d = dis.readDouble();
			String s = dis.readUTF();
			
			System.out.println(b);
			System.out.println(i);
			System.out.println(d);
			System.out.println(s);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (dis != null) {
				try {
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
