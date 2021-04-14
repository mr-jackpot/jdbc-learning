package adam.home.learn;

import java.sql.Connection;
import java.util.Scanner;

public class MessageManager {
	
	public static void main(String[] args) {
		
		System.out.println("Please enter the Database Name, Username, & Password: ");
		Scanner input = new Scanner(System.in);
		Scanner menu = new Scanner(System.in);
		
		SQLDatabase sandbox = new SQLDatabase();
		sandbox.setConnectionDetails(input.nextLine(), input.nextLine(), input.nextLine());
			
		Connection conn = sandbox.establishConnection();
		System.out.println("INFO - Active SQL Server Connection: " + sandbox.connectionStatus(conn));
		
		BankAccount account = new BankAccount();
		int menuSelect = 0;
		
		while (sandbox.connectionStatus(conn)) {
			
			System.out.println("");
			System.out.println("Welcome to Bank of Scotland. Please choose an option from the menu below:");
			System.out.println("[1] Open a new Bank Account");
			System.out.println("[2] Close a Bank Account");
			System.out.println("[5] Exit Application");
			
			menuSelect = menu.nextInt();
			
			if (menuSelect == 1) {
				account.OpenAccount(input, conn);
			}
			
			else if (menuSelect == 2) {
				account.closeAccount(input, conn);
			}		
			
			else if (menuSelect == 5) {
				break;
			}
			


		}
		
		input.close();
		System.out.println("Connection Closed.");

	}
}
