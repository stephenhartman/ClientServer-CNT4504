import java.net.*;
import java.io.*;

/**
 * Client socket program to open the client socket and communicate with the server.
 *
 * @author Stephen Hartman
 * @author Seth Johnson
 * @author Bing Lim
 * @author Dan Sawyer
 * @version 5/25/17
 */
public class Client extends Thread {

	private String hostname;
	private int port;
	private int menuSelect;

	/**
	 * Constructor to instantiate a client socket
	 * @param hostname argument 0
	 * @param port argument 1
	 * @param menuSelect menu selection from ThreadHandler.menu()
	 */
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

			// Reads input from server
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			// Prints output from server
			PrintStream os = new PrintStream(clientSocket.getOutputStream());

			startTime = System.currentTimeMillis();  //Timer starts just before server request
			os.println("Request " + menuSelect);  //Server acception format: "Request #"
			String serverOutput = in.readLine();
			System.out.println(serverOutput);
			endTime = System.currentTimeMillis();  //Timer stops after last byte is sent

			clientSocket.close();

			System.out.println("Response time = " + (endTime - startTime));  //Print calculation of Response time
		} catch (Exception e) {
			System.out.println("Can't open socket at " + hostname + ":" + port); 
			System.exit(-1);
		}
	}
}
