import java.util.Scanner;
/**
 * ThreadHandler class to kick off Client program, offer menu choices, and pass (hostname, port number,
 * menu selection) to the client through each client thread instantiated.
 * 
 * @author Stephen Hartman
 * @author Seth Johnson
 * @author Bing Lim
 * @author Dan Sawyer
 * @version 5/25/17
 */
public class ThreadHandler {

	static String hostname = "";
	static int port = 0;  // Server accepts port 2222
	static int menuSelect = 0;

	public static void main(String[] args) {
		// If insufficient command line arguments, exit program with error message
		if (args.length < 2) {
			System.out.println("Please enter arguments in this format <server IP Address> <port number>\n");
			System.exit(0);
		}
		hostname = args[0];
		
		try {
			port = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {  // Handle non-integer command line argument (socket's 2nd argument is int)
			System.out.println("User invalid input, please enter an Integer for port number.");
			System.exit(-1);
		}

		menu();
		
		// Run concurrent client threads specified times
		runThreads(1);
		runThreads(5);
		runThreads(10);
		runThreads(20);
		runThreads(30);
		runThreads(40);
		runThreads(50);
		runThreads(60);
		runThreads(70);
		runThreads(80);
		runThreads(90);
		runThreads(100);
	}
	/**
	 * Runs threads to open client sockets according to the number of threads needed.
	 * 
	 * @param threadCount Number of concurrent clients necessary
	 */
	public static void runThreads(int threadCount) {

		Thread[] t = new Thread[threadCount];
		System.out.println("Concurrent Client #" + threadCount);
		for (int i = 0; i < t.length; i++) {
			System.out.println("Thread #" + (i + 1));
			t[i] = new Client(hostname, port, menuSelect);
			t[i].run();
		}
	}
	/**
	 * Menu to display choices and evaluate menuSelect expression for socket connection.
	 */
	public static void menu() {

		System.out.println("\n*** MENU ***: ");
		System.out.print("\n1. Host current Date and Time\n" + "2. Host uptime\n" + "3. Host memory use\n"
				+ "4. Host IPV4 socket connections\n" + "5. Host current users\n" + "6. Host running processes\n"
				+ "7. Quit\n" + "\nSelect option: ");

		Scanner sc = new Scanner(System.in);

		try {
			menuSelect = sc.nextInt();
			if (menuSelect < 1 || menuSelect > 7) {
				System.out.println("\nUser invalid input, input number between 1 and 7");
				System.exit(0);
			}
		} catch (Exception e) {
			System.out.println("\nUser invalid input, input number between 1 and 7");
			System.exit(-1);
		}
		switch (menuSelect) {
		case 1:
			System.out.println("Date Request from Client");
			break;
		case 2:
			System.out.println("Uptime Request from Client");
			break;
		case 3:
			System.out.println("Memory Use Request from Client");
			break;
		case 4:
			System.out.println("IPV4 Socket Connections Request from Client");
			break;
		case 5:
			System.out.println("Current Users Request from Client");
			break;
		case 6:
			System.out.println("Current OS Version Request from Client");
			break;
		case 7:
			System.out.println("Quit");
			break;
		default:
			break;
		}
		sc.close();  // close the Scanner object
	}
}