import java.util.Scanner;

public class ThreadHandler {
	
	static String hostname = "";
	static int port = 0;
	static int menuSelect = 0;
	
	public static void main(String[] args) {
		
		if(args.length < 2)  
		{
			System.out.println("Type: java -jar Server6 <server IP Address>, <port number>\n");
			System.exit(0);
		}
		
		boolean validInput = false;
		hostname = args[0];
		port = Integer.parseInt(args[1]);
		
	      
		while(true)
		{
			System.out.println("\n*** MENU ***: ");
			System.out.println("\n1. Host current Date and Time\n" + 
			"2. Host uptime\n" + 
			"3. Host memory use\n" + 
			"4. Host IPV4 socket connections\n" + 
			"5. Host current users\n" + 
			"6. Host running processes\n" +
			"7. Quit\n" + 
			"\nSelect option: ");

			Scanner sc = new Scanner(System.in);

			while(!sc.hasNextInt())
			{
				System.out.println("User invalid input, input number between 1 and 7");
			    sc.next();
			}
			menuSelect = sc.nextInt();
			switch(menuSelect)
			{
				case 1:
					System.out.println("Date Request from Client");
					validInput = true;
					break;
				case 2:
					System.out.println("Uptime Request from Client"); 	
					validInput = true; 	
					break;
				case 3:	
					System.out.println("Memory Use Request from Client");
				    validInput = true;
				    break;
			    case 4:
				    System.out.println("IPV4 Socket Connections Request from Client");
				    validInput = true;
				    break;
				case 5:	
					System.out.println("Current Users Request from Client");
					validInput = true;
				    break;
			    case 6:
				    System.out.println("Current OS Version Request from Client");
				    validInput = true;
				    break;
			    case 7:
				    System.out.println("Quit");
				    System.exit(5);
				    break;
			    default:
				    System.out.println("Invalid Input");
				    validInput = false;
				    break;
			}
			
			sc.close();
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
	}
	
	public static void runThreads(int threadCount) {

		Thread[] t = new Thread[threadCount];
		
		for (int i = 1; i < t.length; i++) {
			t[i] = new Client(hostname, port, menuSelect);
			t[i].run();
			}
	}
}