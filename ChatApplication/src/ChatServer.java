import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Waiting for clients...");
		
		//Let's create Server Socket object and bind it with the Port Number 9800
		ServerSocket ss = new ServerSocket(9800);
		
		//Let's make the server to continuously wait for the incoming clients' connections
		while(true)
		{
			//Let's accept client's connection, this will create new socket for that particular connection
			//leaving Listening server socket ss to listen for another clients incoming connections
			Socket soc = ss.accept();
			System.out.println("Connection has been successfully established");
			
			//Let's create a thread for the accepted chat user
			ConversationHandler handler = new ConversationHandler(soc);
			
			//Let's start the thread
			handler.start();			
		}
		
	}

}

//Here we define our own Thread class, this class will be responsible for managing 
//multiuser chat connections simultaneously, different threads will be managing different chat users
class ConversationHandler extends Thread
{
	//Let's define some variables that will serve a chat user action
	//This is connection socket, buffer for input messages and PrintWriter for sending messages
	Socket socket;
	BufferedReader in;
	PrintWriter out;
	
	//Let's create class constructor, this constructor will take-in as a parameter a socket
	//soc "assigned" to the accepted chat user
	public ConversationHandler(Socket socket) throws IOException {
		this.socket = socket;		
	}
	
	//Let's define run method, code in this function will be executed 
	//once the thread is created - it's like a main() function for a thread
	//This function will hold all the server-side logic
	public void run()
	{
		try
		{
			//Let's create BufferedReader to buffer input stream from the socket
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//Let's create PrintWriter that will be used for sending data to the socket output stream
			out = new PrintWriter(socket.getOutputStream(), true);
			
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
}