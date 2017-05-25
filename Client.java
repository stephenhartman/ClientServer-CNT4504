import java.net.*;
import java.io.*;

public class Client extends Thread {

	private String hostname;
	private int port;
	private int menuSelect;

	public Client(String hostname, int port, int menuSelect) {
		this.hostname = hostname;
		this.port = port;
		this.menuSelect = menuSelect;
	}

	@Override
	public void run() {
		double startTime;
		double endTime;
		Socket clientSocket;

		try {
			clientSocket = new Socket(hostname, port);

			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintStream os = new PrintStream(clientSocket.getOutputStream());

			startTime = System.currentTimeMillis();
			os.println("Request " + menuSelect);
			String serverOutput = in.readLine();
			System.out.println(serverOutput);
			endTime = System.currentTimeMillis();

			clientSocket.close();

			System.out.println("Response time = " + (endTime - startTime));
		} catch (Exception e) {
			System.out.println("Can't open socket at " + hostname + ":" + port); 
		}
	}
}
