package week7;

import java.util.Scanner;
import java.util.ArrayList;

public class CustomerMaintApp {

    public static void main( String[] args ) {

        Scanner   sysin = new Scanner( System.in );
        Validator val   = new Validator( sysin );

        String  response;
        String  firstName;
        String  lastName;
        String  emailAddress;

        ArrayList<Customer> list;

        System.out.println( "Welcome to the Customer Maintenance application" );
        System.out.println( "" );
        showMenu();

        loop:
        while ( true ) {
            System.out.println( "" );
            response = val.getString( "Enter a command: " );
            System.out.println( "" );

            switch ( response.toLowerCase() ) {
                case "list" :
                    list = CustomerDB.getCustomers();

                    System.out.println( "CUSTOMER LIST" );
                    for ( Customer item : list ) {
                        System.out.println(
                            StringUtils.rightPad( item.getEmailAddress(), 30 ) +
                            StringUtils.rightPad( item.getFirstName(),    15 ) +
                            StringUtils.rightPad( item.getLastName(),     15 )
                            );
                    }

                    break;
                case "add" :
                    emailAddress = val.getEmail(  "Enter email address of customer to add: " );
                    firstName    = val.getString( "Enter first name:                       " );
                    lastName     = val.getString( "Enter last  name:                       " );
                    
                    System.out.println( "" );
                    if ( CustomerDB.insertCustomer( lastName, firstName, emailAddress ) ) {
                        System.out.println( "Insertion of " + emailAddress + " succeeded" );
                    } else {
                        System.out.println( "Insertion of " + emailAddress + " failed" );
                    }

                    break;
                case "update" :
                    emailAddress = val.getEmail(  "Enter email address of customer to update: " );
                    firstName    = val.getString( "Enter first name:                          " );
                    lastName     = val.getString( "Enter last  name:                          " );
                    
                    System.out.println( "" );
                    if ( CustomerDB.updateCustomer( firstName, lastName, emailAddress ) ) {
                        System.out.println( "Update of " + emailAddress + " succeeded" );
                    } else {
                        System.out.println( "Update of " + emailAddress + " failed" );
                    }

                    break;
                case "delete" :
                    emailAddress = val.getEmail( "Enter email address of customer to delete: " );
                    
                    System.out.println( "" );
                    if ( CustomerDB.deleteCustomer( emailAddress ) ) {
                        System.out.println( "Deletion of " + emailAddress + " succeeded" );
                    } else {
                        System.out.println( "Deletion of " + emailAddress + " failed" );
                    }

                    break;
                case "help" :
                    showMenu();

                    break;
                case "exit" :
                    System.out.println( "Bye" );

                    break loop;
                default :
                    System.out.println( response + " is not a menu command" );

                    break;
            }
        }

        sysin.close();

    } // main

    private static void showMenu() {

        System.out.println( "COMMAND MENU" );
        System.out.println( "list   - List all customers" );
        System.out.println( "add    - Add a customer" );
        System.out.println( "update - Update a customer" );
        System.out.println( "delete - Delete a customer" );
        System.out.println( "help   - Show this menu");
        System.out.println( "exit   - Exit" );

    } // showMenu

} // CustomerMaintApp