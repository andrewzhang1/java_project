package week7;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDB {

    private static Connection getConnection() {
        try {
            String  dbDir = "/Users/edwardhuie/Documents/Resources/UC Extension/Java Programming Comprehensive/Homework/week7";
            System.setProperty( "derby.system.home", dbDir );

            String  dbUrl     = "jdbc:derby:BineetDB";
            String  username  = "";
            String  password  = "";

            return  DriverManager.getConnection( dbUrl, username, password );
        }
        catch ( SQLException e ) {
            for ( Throwable t : e ) {
                t.printStackTrace();
            }

            return null;
        }
    } // getConnection

    private static boolean disconnect() {
        // on successful shutdown, DriveManager.getConnection() throws exception
        // then return true; else return false
        try {
            String  shutdownURL = "jdbc:derby:;shutdown=true";
            DriverManager.getConnection( shutdownURL );
        }
        catch ( SQLException e ) {
            if ( e.getMessage().equals( "Derby system shutdown." ) ) {
                return true;
            }
        }

        return false;
    } // disconnect

    public static ArrayList<Customer> getCustomers() {

        String  sql;
        String  firstName;
        String  lastName;
        String  emailAddress;

        ArrayList<Customer> customers = new ArrayList<>();

        sql = "select  firstName, "
            + "        lastName, "
            + "        emailAddress "
            + "from    customers "
            + "order by emailAddress";

        try (
            Connection        con = getConnection();
            PreparedStatement ps  = con.prepareStatement( sql );
            ResultSet         rs  = ps.executeQuery();
            )
        {
            while ( rs.next() ) {
                firstName    = rs.getString( "FirstName" );
                lastName     = rs.getString( "LastName" );
                emailAddress = rs.getString( "EmailAddress" );

                customers.add( new Customer( firstName, lastName, emailAddress ) );    
            }

            return  customers;        
        }
        catch ( SQLException e ) {
            for ( Throwable t : e ) {
                t.printStackTrace();
            }

            // in case autoclose fails, ensure connection dropped so reconnection not blocked
            disconnect();

            return  null;
        }

    } // getCustomers

    public static Customer getCustomerByEmailAddress( String emailAddress ) {

        String  sql;        
        String  firstName    = "";
        String  lastName     = "";

        sql = "select  firstName, "
            + "        lastName "
            + "from    customers "
            + "where   emailAddress = ?";

        try (
            Connection        con = getConnection();
            PreparedStatement ps  = con.prepareStatement( sql );
            )
        {
            ps.setString( 1, emailAddress );     // this PreparedStatement method call cannot be in try-with-resources clause
            ResultSet rs = ps.executeQuery();    // so ResultSet is created afterward outside try-with-resources clause
                                                 // and will need to be explicitly closed

            if ( rs.next() ) {
                firstName = rs.getString( "FirstName" );
                lastName  = rs.getString( "LastName" );
                rs.close();

                return  new Customer( firstName, lastName, emailAddress );
            } else {
                rs.close();

                return  null;
            }
        }
        catch ( SQLException e ) {
            for ( Throwable t : e ) {
                t.printStackTrace();
            }

            // in case autoclose fails, ensure connection dropped so reconnection not blocked
            disconnect();

            return  null;
        }

    } // getCustomerByEmailAddress

    public static boolean insertCustomer( String lastName, String firstName, String emailAddress ) {

        String  sq1;
        String  sq2;
        int     customerId;

        sq1 = "select  max( CustomerID ) "
            + "from    customers";

        sq2 = "insert "
            + "into    customers "
            + "        ( customerId, firstName, lastName, emailAddress ) "
            + "values  ( ?, ?, ?, ? )";

        try (
            Connection        con = getConnection();
            PreparedStatement ps1 = con.prepareStatement( sq1 );
            ResultSet         rs1 = ps1.executeQuery();
            PreparedStatement ps2 = con.prepareStatement( sq2 );
            )
        {
            // get max(customerId) in customers table
            // move cursor to first row and get result set's first column (ie, max(customerId))
            rs1.next();
            customerId = rs1.getInt( 1 );

            // increment customerId for new row
            customerId++;

            ps2.setInt(    1, customerId );
            ps2.setString( 2, firstName );
            ps2.setString( 3, lastName );
            ps2.setString( 4, emailAddress );
            ps2.executeUpdate();

            return  true;
        }
        catch ( SQLException e ) {
            for ( Throwable t : e ) {
                t.printStackTrace();
            }

            // in case autoclose fails, ensure connection dropped so reconnection not blocked
            disconnect();

            return  false;
        }

    } // insertCustomer

    public static boolean updateCustomer( String firstName, String lastName, String emailAddress ) {

        String  sql;

        sql = "update  customers "
            + "set     FirstName  = ?, "
            + "        LastName   = ? "
            + "where   EmailAddress = ?";

        try (
            Connection        con = getConnection();
            PreparedStatement ps  = con.prepareStatement( sql );
            )
        {
            ps.setString( 1, firstName );
            ps.setString( 2, lastName );
            ps.setString( 3, emailAddress );
            ps.executeUpdate();

            return  true;
        }
        catch ( SQLException e ) {
            for ( Throwable t : e ) {
                t.printStackTrace();
            }

            // in case autoclose fails, ensure connection dropped so reconnection not blocked
            disconnect();

            return  false;
        }

    } // updateCustomer

    public static boolean deleteCustomer( String emailAddress ) {

        String  sql;

        sql = "delete "
            + "from    customers "
            + "where   EmailAddress = ?";

        try (
            Connection        con = getConnection();
            PreparedStatement ps  = con.prepareStatement( sql );
            )
        {
            ps.setString( 1, emailAddress );
            ps.executeUpdate();

            return  true;
        }
        catch ( SQLException e ) {
            for ( Throwable t : e ) {
                t.printStackTrace();
            }

            // in case autoclose fails, ensure connection dropped so reconnection not blocked
            disconnect();

            return  false;
        }

    } // deleteCustomer

} // CustomerDB