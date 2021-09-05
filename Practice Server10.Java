import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(Protocol.PORT)) {
			while (true) {
				System.out.println("기다리는 중");
				Socket client = server.accept();
				ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
				
				Thread th = new Thread(new Runnable() {
					public ReadRequest rr = new ReadRequest(oos, ois);
					
					@Override
					public void run() {
						Object o = null;
						try {
							while((o = ois.readObject()) != null) {
								rr.readObject(o);
							}
							
						} catch (ClassNotFoundException | IOException e) {
							e.printStackTrace();
						}
					}
				});
				th.start();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
// client
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.SwingUtilities;

public class Client {
	private static ObjectInputStream ois;
	private static ObjectOutputStream oos;
	private static FirstFrame first;

	public static void main(String[] args) {
		try(Socket socket = new Socket("127.0.0.1", Protocol.PORT);){
			
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					first = new FirstFrame(oos);
				}
			});
			//서버의 대답을 들을 준비가 되어있는 것 하나 만들기
			
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
				
	}

}
//FirstFrame


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FirstFrame extends JFrame {
	private ObjectOutputStream oos;
	public FirstFrame(ObjectOutputStream oos) {
		this.oos = oos;
		
		JPanel btnpnl = new JPanel();
		JButton signIn = new JButton("로그인");
		JButton signUp = new JButton("회원가입");
		//회원가입 창이라는 가정하에
		User u = new User();
		//아이디
		//비밀
//		u.setProtocol(Protocol.LOGIN);
//		u.setId(idtf.getText());
//		u.setPassword(pwtf.getText());
//		oos.writeObject(u);
//		oos.flush();
		btnpnl.add(signIn);
		btnpnl.add(signUp);
//		signIn.addActionListener(new ActionListener() { 
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				new TSignIn();
//			}
//		});
		
		signUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				try {
//					oos.writeObject(Protocol.LOGIN);
//					oos.writeObject("hiyo");
//					oos.flush();
//				} catch (IOException e1) {
//					e1.printStackTrace();
//				}
			}
		});
		
		add(btnpnl);
		showGUI();
	}

	private void showGUI() {
		setSize(400, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
//REadAnswer

public class ReadAnswer {
// 프로토콜 대답이 뭐가 왔냐
// LOGINOK >> 메인프레임 호출
//	LOGINNO >> 니 틀렸다 다시해라
}
//User
import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID =  1L;
	
	private String Protocol;
	private String id;
	private String password;
	
	public User() {
	}
	
	public User(String protocol, String id, String password) {
		Protocol = protocol;
		this.id = id;
		this.password = password;
	}

	public String getProtocol() {
		return Protocol;
	}

	public void setProtocol(String protocol) {
		Protocol = protocol;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [Protocol=" + Protocol + ", id=" + id + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Protocol == null) ? 0 : Protocol.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (Protocol == null) {
			if (other.Protocol != null)
				return false;
		} else if (!Protocol.equals(other.Protocol))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	
}
//ReadRequest
