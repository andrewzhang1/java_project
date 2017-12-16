package week1;

import java.util.Scanner;

public class Wk01Ex04 {

    public static void main( String[] args ) {
    	double  miles;
    	double  milesPerHour;
    	String  response;

    	Scanner sc = new Scanner( System.in );

    	System.out.println( "Welcome to the Travel Time Converter" );

    	while (true) {
    		System.out.println( "" );
    		System.out.print( "Enter miles:          " );
    		miles = sc.nextDouble();

    		System.out.print( "Enter miles per hour: " );
    		milesPerHour = sc.nextDouble();

    		printTime ( miles, milesPerHour );

    		System.out.println( "" );
    		System.out.print( "Continue? (y/n): " );
    		response = sc.next();
    		if ( ! response.equalsIgnoreCase( "y" ) ) {
    			sc.nextLine();
    			break;
    		}
    	}

    	sc.close();
    } // end main

    private static void printTime ( double miles, double milesPerHour ) {
    	int  totMins;
    	int  hours;
        int  minutes;

        totMins = (int) Math.round(miles / milesPerHour * 60);        // Math.round( double ) : long
        hours   = totMins / 60;
        minutes = totMins % 60;
        
        System.out.println( "" );
        System.out.println( "Estimated travel time" );
        System.out.println( "Hours:   " + hours );
        System.out.println( "Minutes: " + minutes );

        return;
    } // end printTime

} // end Wk01Ex04
