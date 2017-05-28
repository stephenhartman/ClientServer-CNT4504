import java.io.*;
import java.net.*;

/**
 * Server socket program to accept requests from the Client.
 *
 * @author Stephen Hartman
 * @author Seth Johnson
 * @author Bing Lim
 * @author Dan Sawyer
 * @version 5/25/17
 */
public class Server {

	static DataInputStream inputFromClient;
	static DataOutputStream outputToClient;

	public static void main(String[] args) {

		ServerSocket server;
		Socket clientConnection;
		String menuSelection;
		int portNum = 2222; // Preset port number
		int timeout = 15000;
		BufferedReader input;
		;

		try {
			// Step 1: Create Server Socket
			server = new ServerSocket(portNum);

			while (true) {
				System.out.print("Waiting for connection");
				clientConnection = server.accept();
				clientConnection.setSoTimeout(timeout); // Timeout = 15 seconds

				System.out.println("Connection received from " + clientConnection.getInetAddress() + ":"
						+ clientConnection.getPort());
				inputFromClient = new DataInputStream(clientConnection.getInputStream());
				outputToClient = new DataOutputStream(clientConnection.getOutputStream());

				input = new BufferedReader(new InputStreamReader(inputFromClient));
				menuSelection = input.readLine();
				selection(menuSelection);

				// Close streams
				outputToClient.close();
				inputFromClient.close();
				server.close();
				clientConnection.close();
			}
		} catch (Exception e) {
			System.out.println("Can't open socket.");
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public static void selection(String menuSelect) {
		Process process;
		String output;
		BufferedReader br;
		try {
			switch (menuSelect) {

			case "Request 1":
				process = Runtime.getRuntime().exec("date");
				br = new BufferedReader(new InputStreamReader(process.getInputStream()));
				while ((output = br.readLine()) != null)
					outputToClient.writeChars(output);
				break;
			case "Request 2":
				process = Runtime.getRuntime().exec("uptime");
				br = new BufferedReader(new InputStreamReader(process.getInputStream()));
				while ((output = br.readLine()) != null)
					outputToClient.writeChars(output);
				break;
			case "Request 3":
				process = Runtime.getRuntime().exec("free");
				br = new BufferedReader(new InputStreamReader(process.getInputStream()));

				while ((output = br.readLine()) != null)
					outputToClient.writeChars(output);
				break;
			case "Request 4":
				process = Runtime.getRuntime().exec("netstat");
				br = new BufferedReader(new InputStreamReader(process.getInputStream()));

				while ((output = br.readLine()) != null)
					outputToClient.writeChars(output);
				break;
			case "Request 5":
				process = Runtime.getRuntime().exec("who");
				br = new BufferedReader(new InputStreamReader(process.getInputStream()));

				while ((output = br.readLine()) != null)
					outputToClient.writeChars(output);
				break;
			case "Request 6":
				process = Runtime.getRuntime().exec("ps -e");
				br = new BufferedReader(new InputStreamReader(process.getInputStream()));

				while ((output = br.readLine()) != null)
					outputToClient.writeChars(output);
				break;
			case "Request 7":
				System.out.println("Quit option chosen.");
				outputToClient.writeChars("Closing socket...");
				break;
			default:
				System.out.println("Please enter a valid selection.");
				break;
			}
		} catch (Exception e) {
			System.out.println("There was an exception.  Exiting...");
			e.printStackTrace();
			System.exit(-1);
		}
	}
}
