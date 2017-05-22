package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client 
{
	public static void main(String[] args) 
	{
		double startTime;
		boolean validInput = false;
	      
			if(args.length < 2)  
			{
				System.out.println("Type: java -jar Server6 <server IP Address>, <port number>\n");
				System.exit(0);
			}
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			Socket s = null;
			
			try
			{
				s = new Socket(args[0], Integer.parseInt(args[1]));
			}
			catch(Exception e)
			{
				System.out.println("cant open socket !! " + args[0] + "\n");
				System.exit(100);
			}
			
			BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
	      
			int menuSelect;
	      
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

				startTime = System.currentTimeMillis();

				while(!sc.hasNextInt())
				{
					System.out.println("User invalid input, input number between 1 or 7");
				        sc.next();
				}
				menuSelect = sc.nextInt();
				switch(menuSelect)
				{
					case 1:
						System.out.println("Date Request from Client");
						out.println("Request 1");
						validInput =true;
						break;
				        case 2:
					     	System.out.println("Uptime Request from Client");
					     	out.println("Request 2");
					     	validInput =true;
					     	break;
				        case 3:
					     	System.out.println("Memory Use Request from Client");
					     	out.println("Request 3");
					     	validInput =true;
					     	break;
				       	case 4:
					     	System.out.println("IPV4 Socket Connections Request from Client");
					     	out.println("Request 4");
					     	validInput =true;
					     	break;
				       	case 5:
					     	System.out.println("Current Users Request from Client");
					     	out.println("Request 5");
					     	validInput =true;
					     	break;
				       	case 6:
					     	System.out.println("Current OS Version Request from Client");
					     	out.println("Request 6");
					     	validInput =true;
					     	break;
				       	case 7:
					     	System.out.println("Quit");
					     	out.println("Request 7");
					     	System.exit(5);
					     	break;
				       	default:
					     	System.out.println("Invalid Input");
					     	validInput =false;
					     	break;
				    	}//end switch
					if (validInput)
			      		{
	         				String answer;
	   					while((answer = input.readLine()) != null && !answer.equals("ServerDone"))
	   					{
	   						System.out.println(answer);
	   					}
	                
	         			double endTime;
	         			double totalTime;
	         			endTime = System.currentTimeMillis();
	         			totalTime = endTime - startTime;
	         			System.out.printf("Total time spent: %.3f\n ", totalTime);
	      			}
			}
		}
	}
}
