package adam.home.learn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLDatabaseConnection {

    // Connect to database.
    public void establishConnection() {
        String connectionString = "";
        // Taken away connection string from public repo.

        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(connectionString);
                Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String sqlStatement = "SELECT * FROM dbo.accounts";
            resultSet = statement.executeQuery(sqlStatement);

            // Prints first column - need to print all columns
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));

            }
        }
        catch (SQLException e) {
        	System.out.println("ERROR - SQL Database connection FAILED!");
            e.printStackTrace();
        }
    }
}