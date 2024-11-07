import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class BankClient {

	public static void main(String[] args) throws IOException {
		
		//local copy of account (keep in sync with server)
		BankAccount accounts[] = new BankAccount[10];
		for(int i=0; i<accounts.length; i++) {
			accounts[i] = new BankAccount();
		}
		
		//FrogData:
		//Frog ID int
		//Frog Name str
		//Frog Movement str: ahead back left right
		//Frog status str: alive dead
		
		
		//set up socket request to send to the server
		final int SOCKET_PORT = 5556;
		Socket s = new Socket("localhost", SOCKET_PORT);
		
		//initialize a data stream to send data out to server
		OutputStream outStream = s.getOutputStream();
		PrintWriter out = new PrintWriter(outStream);
		
		//initialize an data stream to receive data
		//sent back via the socket
		InputStream inStream = s.getInputStream();
		Scanner in = new Scanner(inStream);
		
		//send Frog go ahead
		String command = "Frog go ahead\n";
		System.out.println("Sending: " + command);
		out.println(command); //command is sent to server via socket
		out.flush();
		
		//receive a response from the server
		String response = in.nextLine();
		System.out.println("RECEIVED: " + response);
		
		//update frog id, name, movement and status
		String serverCommand = in.next(); //UPDATE BALANCE
		System.out.println("serverCommand: " + serverCommand);
		int frogID = in.nextInt(); // Frog ID to seperate to the other frog
		String frogName = in.nextLine(); // frog name: Grogu
		String frogMovement = in.nextLine(); // Go Ahead/Back/Left/Right
		String frogStatus = in.nextLine(); // Alive/ Dead
		
		//send next command to server
		command = "Frog go back\n";
		System.out.println("Sending: " + command);
		out.println(command); //command is sent to server via socket
		out.flush();
		response = in.nextLine();
		System.out.println("RECEIVED: " + response);
		
		//send next command to server
		command = "Frog turn left\n";
		System.out.println("Sending: " + command);
		out.println(command); //command is sent to server via socket
		out.flush();
		response = in.nextLine();
		System.out.println("RECEIVED: " + response);
		
		//send next command to server
		command = "Frog turn right\n";
		System.out.println("Sending: " + command);
		out.println(command); //command is sent to server via socket
		out.flush();
		response = in.nextLine();
		System.out.println("RECEIVED: " + response);
		
		s.close();
	}

}













