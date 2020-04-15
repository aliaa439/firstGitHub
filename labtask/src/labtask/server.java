package labtask;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
	
	// Create static object from ServerSocket.
	static ServerSocket serverSocket;
	static String ar1[]={"ahmed","mohammed","adel","gamal","ramy"}; 
	static int ar2[]={40,30,35,27,28};
	
	public static void main(String[] args) {
		
		
		try {
			// Initialize Server Socket with port number as parameter.
			serverSocket = new ServerSocket(4000);
			System.out.println("Server is booted up and is waiting for clients to connect.");

			while (true) {
				// Accept any Client wants to connect to the server.
				Socket clientSocket = serverSocket.accept();
				System.out.println("A new client [" + clientSocket + "] is connected to the server.");

				// Create a new thread for this client.
				Thread client = new ClientConnection(clientSocket);

				// Start thread.
				client.start();

			}
		} catch (IOException e) {
			System.out.println("Problem with Server Socket.");
		}
	}

	static class ClientConnection extends Thread {

		final private Socket clientSocket;

		public ClientConnection(Socket clientSocket) {
			this.clientSocket = clientSocket;
		}

		public void run() {
			try {

				// Takes input from the client socket.
				DataInputStream input = new DataInputStream(clientSocket.getInputStream());

				// Print output to the client socket.
				DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

				// Send to the client that it is now connected.
				output.writeUTF("connected.");

				// Start communication with client.
				while (true) {
					output.writeUTF("Send your request or 'close' to close the connection.");

					// Read the request from the client and output it to Server's console.
					String request = input.readUTF();
					System.out.println("Client [ " + clientSocket + " ]: " + request);
					
					for(int i=0;i<5;i++)
					{
					
						if(request.equals(ar1[i]))
						{
							System.out.println(ar2[i]);
							break;
						}
					    else
						{
							System.out.println("this student is not exist");
						}
					}
						
						
					}
				
			} catch (IOException e) 
		       
			{
				System.out.println("Connection with this client [" + clientSocket + "] is terminated.");
			}
		}

		private int equals(int i) {
			// TODO Auto-generated method stub
			return 0;
		}
	}

}

