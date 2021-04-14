package adam.home.learn;

import java.sql.Connection;
import java.sql.ResultSet;
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
	
	public String getAccountDetails() {
		
		
		return null;
	}
	
	public void closeAccount(Scanner s, Connection conn) {
		
		System.out.println("Please enter the name of the account holder:");
		String name = s.nextLine();
		System.out.println("Please confirm the city that the account holder lives in:");
		String city = s.nextLine();
		
		System.out.println("Processing request . . .");


		String q = "DELETE FROM accounts where name = '"+name.toUpperCase()+"' AND city = '"+city.toUpperCase()+"';";

		try (Statement stmt = conn.createStatement()){
			stmt.execute(q);
			System.out.println("Removing account of " + name.toUpperCase());
		

		} catch (SQLException e) {
			System.out.println("ERROR - SQL statement execution FAILED!");
			e.printStackTrace();
		}
	}
	
	public void OpenAccount(Scanner s, Connection conn) {
		
		System.out.println("Please enter your name:");
		String name = s.nextLine();
		System.out.println("Please enter the country that you live in:");
		String country = s.nextLine();
		System.out.println("Please enter the city that you live in:");
		String city = s.nextLine();
		
		System.out.println("Processing request . . .");
	
		
		String q = "INSERT INTO accounts (name, country, city, bank, balance) VALUES ('"+name.toUpperCase()+"', '"+country.toUpperCase()+"', '"+city.toUpperCase()+"','"+BANK+"','"+BALANCE+"');";

		try (Statement stmt = conn.createStatement()){
			stmt.execute(q);
			System.out.println("Opening account for " + name.toUpperCase());

		} catch (SQLException e) {
			System.out.println("ERROR - SQL statement execution FAILED!");
			e.printStackTrace();
		}
	}
	
	
}
