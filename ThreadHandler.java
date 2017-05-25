import java.util.Scanner;

public class ThreadHandler {

	static String hostname = "";
	static int port = 0;
	static int menuSelect = 0;

	public static void main(String[] args) {

		if (args.length < 2) {
			System.out.println("Please enter arguments in this format <server IP Address> <port number>\n");
			System.exit(0);
		}

		hostname = args[0];
		try {
			port = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
			System.out.println("User invalid input, please enter an Integer for port number.");
			System.exit(-1);
		}

		menu();
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

	public static void runThreads(int threadCount) {

		Thread[] t = new Thread[threadCount];
		System.out.println("Concurrent Client #" + threadCount);
		for (int i = 0; i < t.length; i++) {
			System.out.println("Thread #" + (i + 1));
			t[i] = new Client(hostname, port, menuSelect);
			t[i].run();
		}
	}

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
			System.exit(5);
			break;
		default:
			break;
		}
		sc.close();
	}
}
