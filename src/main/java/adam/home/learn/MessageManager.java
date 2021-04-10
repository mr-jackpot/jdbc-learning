package adam.home.learn;

import java.sql.Connection;
import java.util.Scanner;

public class MessageManager {
	
	public static void main(String[] args) {
		
		System.out.println("Please enter the database, username, & password: ");
		Scanner input = new Scanner(System.in);
		
		SQLDatabase sandbox = new SQLDatabase();
		sandbox.setConnectionDetails(input.nextLine(), input.nextLine(), input.nextLine());
			
		Connection conn = sandbox.establishConnection();
		System.out.println("INFO - Active SQL Server Connection: " + sandbox.connectionStatus(conn));
		
		BankAccount account = new BankAccount();
		account.OpenAccount(input, conn);

	}
}
