package adam.home.learn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BankAccount {

	final String BANK = "BANK OF SCOTLAND";
	final int BALANCE = 0;
	
	
	public void depositMoney() {
		
	}
	
	public void withdrawMoney() {
		
	}
	
	public void changeName() {
		
	}
	
	public void changeAddress() {
		
	}
	
	public void searchAccounts(Scanner s, Connection conn) {

		// Take user input and assign it to variables that will be used in the SQL query string.		
		System.out.println("Please enter the name of the account holder to search:");
		String name = s.nextLine();
		
		String q = "SELECT * FROM accounts where name LIKE '%"+name.toUpperCase()+"%';";
		
		// Executing SQL query string above. The account name search criteria will be inserted above.
		try (Statement stmt = conn.createStatement()){
			ResultSet rs = stmt.executeQuery(q);

			// Go through results of SQL query and print them out to the console. In this case it is printing out all bank accounts that match the search criteria.
			while (rs.next()) {
        
		        System.out.println("----------------------------------------------");
		        System.out.println("CUSTOMER ID: " + rs.getInt("customer-id"));
		        System.out.println("ACCOUNT HOLDER: " + rs.getString("name"));
		        System.out.println("COUNTRY: " + rs.getString("country"));
		        System.out.println("CITY: " + rs.getString("city"));
		        System.out.println("BANK: " + rs.getString("bank"));
		        System.out.println("ACCOUNT BALANCE: £" + rs.getFloat("balance"));
		        System.out.println("----------------------------------------------");

		      }
			
		//Print out details of SQL error when trying to execute query.
		} catch (SQLException e) {
			System.out.println("ERROR - SQL statement execution FAILED!");
			e.printStackTrace();
		}
		
	}
	
	public void closeAccount(Scanner s, Connection conn) {

		// Take user input and assign it to variables that will be used in the SQL query string.		
		System.out.println("Please enter the name of the account holder:");
		String name = s.nextLine();
		System.out.println("Please confirm the city that the account holder lives in:");
		String city = s.nextLine();
		
		System.out.println("Processing request . . .");


		String q = "DELETE FROM accounts where name = '"+name.toUpperCase()+"' AND city = '"+city.toUpperCase()+"';";

		// Executing SQL query string above. The account name & city will be inserted above.
		try (Statement stmt = conn.createStatement()){
			stmt.execute(q);
			System.out.println("Removing account of " + name.toUpperCase());
		
		//Print out details of SQL error when trying to execute query.
		} catch (SQLException e) {
			System.out.println("ERROR - SQL statement execution FAILED!");
			e.printStackTrace();
		}
	}
	
	
	public void OpenAccount(Scanner s, Connection conn) {
		
		// Take user input and assign it to variables that will be used in the SQL query string.
		System.out.println("Please enter your name:");
		String name = s.nextLine();
		System.out.println("Please enter the country that you live in:");
		String country = s.nextLine();
		System.out.println("Please enter the city that you live in:");
		String city = s.nextLine();
		
		System.out.println("Processing request . . .");
	
		
		String q = "INSERT INTO accounts (name, country, city, bank, balance) VALUES ('"+name.toUpperCase()+"', '"+country.toUpperCase()+"', '"+city.toUpperCase()+"','"+BANK+"','"+BALANCE+"');";
		
		// Executing SQL query string above. The account name & city will be inserted above.
		try (Statement stmt = conn.createStatement()){
			stmt.execute(q);
			System.out.println("Opening account for " + name.toUpperCase());
			
		// Print out details of SQL error when trying to execute query.
		} catch (SQLException e) {
			System.out.println("ERROR - SQL statement execution FAILED!");
			e.printStackTrace();
		}
	}
	
	
}
