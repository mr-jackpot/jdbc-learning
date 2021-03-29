package adam.home.learn;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Attempting to connect to SQL Server..." );
        
        SQLDatabaseConnection conn = new SQLDatabaseConnection();
        conn.establishConnection();
    }
}
