import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class QuizServer {
	public static void main(String[] args) throws IOException {
		System.out.println("-- 서버 시작 --");
		
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(5555);
		} catch (IOException e) {
			System.err.println("다음의 포트 번호에 연결할 수 없습니다: 5555");
			System.exit(1);
		}

		Socket clientSocket = null;
		try {
			clientSocket = serverSocket.accept();
		} catch (IOException e) {
			System.err.println("accept() 실패");
			System.exit(1);
		}

		PrintWriter out = new PrintWriter(
				clientSocket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(
				new InputStreamReader(
						clientSocket.getInputStream()));
		String inputLine, outputLine;
		QuizProtocol qp = new QuizProtocol();
		
		outputLine = qp.process(null);
		out.println(outputLine);
		
		while ((inputLine = in.readLine()) != null) {
			outputLine = qp.process(inputLine);
			out.println(outputLine);
			if (outputLine.equals("quit"))
				break;
		}
		out.close();
		in.close();
		clientSocket.close();
		serverSocket.close();
	}
}

// ppp client
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class QuizClient {
	public static void main(String[] args) throws IOException {
		Socket quizSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		
		try {
			quizSocket = new Socket("localhost", 5555);
			out = new PrintWriter(quizSocket.getOutputStream(), true);
			in = new BufferedReader(
					new InputStreamReader(
							quizSocket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("localhost에 접근할 수 없습니다.");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("입출력 오류");
			System.exit(1);
		}
		
		BufferedReader user = new BufferedReader(
				new InputStreamReader(
						System.in));
		
		String fromServer;
		String fromUser;
		
		while ((fromServer = in.readLine()) != null) {
			System.out.println("서버: " + fromServer);
			if (fromServer.equals("quit"))
				break;
			
			fromUser = user.readLine();
			if (fromUser != null) {
				System.out.println("클라이언트: " + fromUser);
				out.println(fromUser);
			}
		}
		out.close();
		in.close();
		quizSocket.close();
	}
}
//--- protocol

public class QuizProtocol {
	private static final int WAITING = 0;
	private static final int PROBLEM = 1;
	private static final int ANSWER = 2;
	
	private static final int NUMPROBLEMS = 3;
	
	private int state = WAITING;
	private int currentProblem = 0;
	
	private String[] problems = { "네트워크 처리 패키지는?"
		, "자바의 최신버전은?"
		, "인터넷에서 컴퓨터를 식별하는 주소는?"
	};
	private String[] answers = { "java.io", "1.7", "IP 주소" };
	
	public String process(String theInput) {
		String theOutput = null;
		
		if (state == WAITING) {
			theOutput = "퀴즈를 시작합니다(y/n)";
			state = PROBLEM;
		} else if (state == PROBLEM) {
			if (theInput.equalsIgnoreCase("y")) {
				theOutput = problems[currentProblem];
				state = ANSWER;
			} else {
				state = WAITING;
				theOutput = "quit";
			}
		} else if (state == ANSWER) {
			if (theInput.equalsIgnoreCase(answers[currentProblem])) {
				theOutput = "정답입니다. 계속하시겠습니까? (y/n)";
				state = PROBLEM;
			} else {
				state = PROBLEM;
				theOutput = "오답입니다. 계속하시겠습니까? (y/n)";
			}
			currentProblem = (currentProblem + 1) % NUMPROBLEMS;
		}
		return theOutput;
	}
}
