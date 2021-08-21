import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private static final int PORT = 4885;
	
	public static void main(String[] args) {
		System.out.println("--서버 시작--");
		try (ServerSocket server = new ServerSocket(PORT);) {
			try (Socket client = server.accept();
					DataOutputStream out
						= new DataOutputStream
							(client.getOutputStream());
					DataInputStream in
						= new DataInputStream
							(client.getInputStream());) {
				System.out.println("--클라이언트가 접속을 함.--");
				
				while (true) {
					String fromClient = in.readUTF();
					out.writeUTF(fromClient);
					out.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("--서버 종료--");
	}
}
