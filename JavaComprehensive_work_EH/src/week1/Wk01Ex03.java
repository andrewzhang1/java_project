package week1;

import java.util.Scanner;

public class Wk01Ex03 {

    public static void main( String[] args ) {
    	double  farenheit;
    	String  response;

    	Scanner sc = new Scanner( System.in );

    	System.out.println( "Welcome to the Temperature Converter" );

    	while (true) {
    		System.out.println( "" );
    		System.out.print( "Enter degress in Farenheit: " );
    		farenheit = sc.nextDouble();

    		System.out.println( "Degrees in Celsius: " + toCelsius( farenheit ) );

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

    private static double toCelsius ( double farenheit ) {
    	// celsius = (farenheit - 32) * 5/9
    	// round to two decimal digits:  (double) Math.round( celsius ) * 100 / 100

    	return  (double) Math.round( ((farenheit - 32) * 5/9) * 100 ) / 100;
    } // end toCelsius

} // end Temperature
