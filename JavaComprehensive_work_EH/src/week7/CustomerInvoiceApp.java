package week7;

import java.sql.*;
import java.text.NumberFormat;

public class CustomerInvoiceApp {

    public static void main( String[] args ) {
        
        String         sql;
        String         row;
        
        String         emailAddress;
        String         invoiceNumber;
        java.sql.Date  invoiceDate;
        double         invoiceTotal;
        
        NumberFormat   currency = NumberFormat.getCurrencyInstance();
        
        System.out.println( "Welcome to the Customer Invoice Report" );
        System.out.println( "" );

        sql = "select  c.emailAddress, "
            + "        i.invoiceNumber, "
            + "        i.invoiceDate, "
            + "        i.invoiceTotal "
            + "from    customers as c "
            + "join    invoices  as i "
            + "on      c.customerid = i.customerid "
            + "order by c.emailAddress, i.invoiceNumber";

        // an alternative to
        //     Connection resource creation in try-with-resources clause
        //     disconnect in catch block
        // is
        //     Connection resource creation before try-catch
        //     disconnect after try-catch
        Connection con = getConnection();
        if ( con != null ) {
            try (
//              Connection        con = getConnection();
                PreparedStatement ps  = con.prepareStatement( sql );
                ResultSet         rs  = ps.executeQuery(); )
            {
                while ( rs.next() ) {
                    emailAddress  = rs.getString( "EmailAddress" );
                    invoiceNumber = rs.getString( "InvoiceNumber" );
                    invoiceDate   = rs.getDate(   "InvoiceDate" );
                    invoiceTotal  = rs.getDouble( "InvoiceTotal" );
                    
                    row = StringUtils.rightPad( emailAddress, 25 )
                        + StringUtils.rightPad( invoiceNumber, 10 )
                        + StringUtils.rightPad( invoiceDate.toString(), 10 )
                        + StringUtils.leftPad( currency.format( invoiceTotal ), 10 );
                    System.out.println( row );
                }
            }
            catch ( SQLException e ) {
                for ( Throwable t : e ) {
                    t.printStackTrace();
                }
                
//              disconnect();
            }

            disconnect();
        }

    } // main
    
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
            
            return  null;
        }
    } // getConnection
    
    // useful when Connection object created outside try-with-resources
    // (where Autocloseable objects are automatically closed)
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
    
} // CustomerInvoiceApp
