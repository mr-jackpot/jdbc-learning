package adam.home.learn;

import java.sql.Connection;
import java.util.Scanner;

public class MessageManager {
	
	public static void main(String[] args) {
		
		// Ask user for DB details. This is for security reasons so my fuken user account isnt on the public repository.
		System.out.println("Please enter the Database Name, Username, & Password: ");
		Scanner userConnectionDetails = new Scanner(System.in);
		
		// Initialise connection to database.
		SQLDatabase sandbox = new SQLDatabase();
		sandbox.setConnectionDetails(userConnectionDetails.nextLine(), userConnectionDetails.nextLine(), userConnectionDetails.nextLine());
		
		// Start up user menu.
		userMenu(sandbox.establishConnection(), sandbox);


	}
	
	
	public static void userMenu(Connection conn, SQLDatabase sandbox) {
		
		// Checking if the SQL connection is active.
		System.out.println("INFO - Active SQL Server Connection: " + sandbox.connectionStatus(conn));
		
		BankAccount account = new BankAccount();
		Scanner userMenuNavigation = new Scanner(System.in);
		Scanner input = new Scanner(System.in);
		int menuSelect = 0;
		
		// If the connection drops, the program will close down.
		while (sandbox.connectionStatus(conn)) {
			
			System.out.println("");
			System.out.println("Welcome to Bank of Scotland. Please choose an option from the menu below:");
			System.out.println("[1] Open a new Bank Account");
			System.out.println("[2] Close a Bank Account");
			System.out.println("[3] Extract Account Information");	
			System.out.println("[5] Exit Application");
			
			menuSelect = userMenuNavigation.nextInt();
			
			if (menuSelect == 1) {
				account.OpenAccount(input, conn);
			}
			
			else if (menuSelect == 2) {
				account.closeAccount(input, conn);
			}	
			
			else if (menuSelect == 3) {
				account.searchAccounts(input, conn);
			}	
			
			else if (menuSelect == 5) {
				break;
			}
			
		}
		
		System.out.println("Connection Closed.");
	}
}
