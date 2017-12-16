package week4;

import java.util.Scanner;

public class PersonApp {

    public static void main( String[] args ) {
        Scanner     sc = new Scanner( System.in );
        String      prompt;
        String      response;
        MyValidator v  = new MyValidator( sc );

        Person      p  = null;

        System.out.println( "Welcome to the Person Tester application" );

        while ( true ) {
            System.out.println( "" );
            prompt   = "Create customer or employee? (c/e): ";
            response = v.getChoiceString( prompt, "c", "e" );

            if ( response.equalsIgnoreCase( "c" ) ) {
                Customer c = new Customer();
                p = c;

                prompt   = "Enter first name: ";
                response = v.getRequiredString( prompt );
                p.setFname( response );

                prompt   = "Enter last name: ";
                response = v.getRequiredString( prompt );
                p.setLname( response );

                prompt   = "Enter email address: ";
                response = v.getRequiredString( prompt );
                p.setEmail( response );

                prompt   = "Enter customer number: ";
                response = v.getRequiredString( prompt );
                c.setCustomerNumber( response );                // not known to p
            } 
            else if ( response.equalsIgnoreCase( "e" ) ) {
                Employee e = new Employee();
                p = e;

                prompt   = "Enter first name: ";
                response = v.getRequiredString( prompt );
                p.setFname( response );

                prompt   = "Enter last name: ";
                response = v.getRequiredString( prompt );
                p.setLname( response );

                prompt   = "Enter email address: ";
                response = v.getRequiredString( prompt );
                p.setEmail( response );

                prompt   = "Enter Social Security number: ";
                response = v.getRequiredString( prompt );
                e.setSocialSecurityNumber( response );            // not known to p
            }

            System.out.println( "" );
            print( p );

            System.out.println( "" );
            response = v.getChoiceString( "Continue? (y/n): ", "y", "n" );
            if ( response.equalsIgnoreCase( "y" ) ) {
                continue;
            } else if ( response.equalsIgnoreCase( "n" ) ) {
                break;
            }
        }

        sc.close();
    } // end main

    public static void print( Person p ) {
        if ( p instanceof Person ) {
            System.out.print( "You entered:\n" + p.getDisplayText() );
        }
    } // end print

} // end PersonApp
