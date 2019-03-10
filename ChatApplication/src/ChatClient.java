import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient {
	
	//Let's start building our GUI for the chat client
	//For this purpose I will use SWING library components
	//First let's create JFrame Object which will be an outer container for the chat user application window
	static JFrame chatWindow = new JFrame("D15124507 Chat Application");
	
	//Secondly let's create Chat Area part of the application window, all messages will be displayed in this part of the window
	//let's set up the number of rows and columns for this area at 22 and 40 respectively
	static JTextArea chatArea = new JTextArea(22, 40);
	
	//Thirdly let's create an area where we will be able to enter our messages
	static JTextField textField = new JTextField(40);
	
	//Blank label only to display a blank-line-space between chat area and TextField area
	static JLabel blankLabel = new JLabel("         ");
	
	//Let's create button that will be trigger the function to send the message
	static JButton sendButton = new JButton("Send");
	
	
	//Let's define class constructor
	ChatClient()
	{
		//To arrange components inside our application frame I will use FlowLayout layout manager
		chatWindow.setLayout(new FlowLayout());
		
		//Let's start adding components to the chat window
		chatWindow.add(new JScrollPane(chatArea));
		chatWindow.add(blankLabel);
		chatWindow.add(textField);
		chatWindow.add(sendButton);
		
		//Let's define default close operation for the chat window
		//we have to explicitly define the EXIT (x) button of the window to EXIT the application
		//otherwise it would only hide the chat window without exiting (would be running in the background)
		chatWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		chatWindow.setSize(475, 500);
		chatWindow.setVisible(true);
		
		//Let's set up by default that the text area of the chat will be not editable,
		//until the user will be accepted by the server to join the chat - when the connection will be set up
		textField.setEditable(false);
		
		//We don't want user to edit the displayed messages in the chat window	
		chatArea.setEditable(false);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Let's create chatClient object
		ChatClient client = new ChatClient();
		
	}

}
