package yoon;

import java.net.*;
import java.io.*;
import java.util.*;

public class ChatServer {
	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			server = new ServerSocket(10001);
			System.out.println("접속을 기다립니다.");
			HashMap<String, PrintWriter> hm = new HashMap<String, PrintWriter>();
			while (true) {
				Socket sock = server.accept();
				ChatThread chatthread = new ChatThread(sock, hm);
				chatthread.start();
			} // while
		} catch (Exception e) {
			System.out.println("server main : " + e);
		} finally {
			try {
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	} // main
}

class ChatThread extends Thread {
	private Socket sock;
	private String id;
	private BufferedReader reader;
	private HashMap<String, PrintWriter> mapUsers;
	
	public ChatThread(Socket sock, HashMap<String, PrintWriter> hm) {
		this.sock = sock;
		this.mapUsers = hm;
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
			reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			id = reader.readLine();
			broadcast(id + "님이 접속하였습니다.");
			System.out.println("접속한 사용자의 아이디는 " + id + "입니다.");
			synchronized (hm) {
				hm.put(id, pw);
			}
		} catch (Exception ex) {
			System.out.println("server thread constructor: " + ex);
		}
	} // 생성자

	public void run() {
		try {
			String line = null;
			while ((line = reader.readLine()) != null) {
				if (line.equals("/quit"))
					break;
				if (line.indexOf("/to ") == 0) {
					sendmsg(line);
				} else {
					broadcast(id + " : " + line);
				}
			}
		} catch (Exception ex) {
			System.out.println("server thread run : " + ex);
		} finally {
			synchronized (mapUsers) {
				PrintWriter writer = mapUsers.remove(id);
				writer.println("/quit");
				writer.flush();
			}
			String info = id + " 님이 접속 종료하였습니다.";
			broadcast(info);
			System.out.println(info);
			try {
				if (sock != null) {
					sock.close();
				}
			} catch (Exception ex) {
			}
		}
	} // run

	// /to id message
	public void sendmsg(String msg) {
		int start = msg.indexOf(" ") + 1;
		int end = msg.indexOf(" ", start);
		if (end != -1) {
			String to = msg.substring(start, end);
			String msg2 = msg.substring(end + 1);
			PrintWriter writer = mapUsers.get(to);
			if (writer != null) {
				writer.println(id + " 님이 다음의 귓속말을 보내셨습니다. :" + msg2);
				writer.flush();
			} // if
			writer = mapUsers.get(id);
			writer.println(id + " 님께 다음의 귓속말을 보냈습니다. :" + msg2);
			writer.flush();
		}
	} // sendmsg

	public void broadcast(String msg) {
		synchronized (mapUsers) {
			Collection<PrintWriter> collection = mapUsers.values();
			Iterator<PrintWriter> iter = collection.iterator();
			while (iter.hasNext()) {
				PrintWriter pw = iter.next();
				pw.println(msg);
				pw.flush();
			}
		}
	} // broadcast
}
// 클라이언트

package yoon;

import java.net.*;
import java.io.*;
import javax.swing.*;

public class ChatClient {
	private Socket sock = null;
	private BufferedReader reader = null;
	private PrintWriter writer = null;

	public ChatClient() {
		String ip = JOptionPane.showInputDialog("접속할 IP를 입력하세요");
		String id = JOptionPane.showInputDialog("사용할 ID를 입력하세요");
		if (ip.length() == 0 || id.length() == 0) {
			System.out.println("IP와 ID를 제대로 입력하지 않아 프로그램을 종료합니다.");
			System.exit(-1);
		}
		try {
			sock = new Socket(ip, 10001);
			writer = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
			reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

			// 사용자의 id를 전송한다.
			writer.println(id);
			writer.flush();
			new Thread() {
				public void run() {
					try {
						// 사용자 메세지 읽기
						String line = null;
						while ((line = reader.readLine()) != null) {
							if (line.equals("/quit")) {
								throw new Exception();
							}
							System.out.println(line);
						}
					} catch (Exception e) {
					} finally {
						exit();
					}
				}
			}.start();
			String line = null;
			// 키보드입력 읽기
			// /quit
			while ((line = keyboard.readLine()) != null) {
				writer.println(line);
				writer.flush();
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			exit();
		} // finally
	}

	private void exit() {
		try {
			if (writer != null) {
				writer.close();
			}
		} catch (Exception ex) {
		}
		try {
			if (reader != null)
				reader.close();
		} catch (Exception ex) {
		}
		try {
			if (sock != null)
				sock.close();
		} catch (Exception ex) {
		}

		System.out.println("클라이언트의 접속을 종료합니다.");
		System.exit(0);
	}

	public static void main(String[] args) {
		new ChatClient();
	} // main
} // class
