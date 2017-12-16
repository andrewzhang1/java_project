package week3;

import java.util.Scanner;

public class CircleApp {

    public static void main( String[] args ) {
        double  radius;
        String  response;

        Scanner sysin = new Scanner( System.in );

        System.out.println( "Welcome to the Circle Tester" );

        while ( true ) {
            System.out.println( "" );
            radius = Validator.getDouble( sysin, "Enter radius:  ", 0.0, Double.MAX_VALUE );

            Circle c = new Circle( radius );            
            System.out.println( "Circumference: " + c.getFormattedCircumference() );
            System.out.println( "Area:          " + c.getFormattedArea() );

            System.out.println( "" );
            response = Validator.getString( sysin, "Continue? (y/n): ", "y", "n" );

            if ( response.equalsIgnoreCase( "y" ) ) {
                continue;
            } else {
                break;
            }
        }

        System.out.println( "" );
        System.out.println( "Goodbye. You created " + Circle.getObjectCount() + " Circle object(s)." );
    
        sysin.close();
    } // end main

} // end CircleApp
