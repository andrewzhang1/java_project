package week1;

import java.util.Scanner;

public class Wk01Ex01 {

    public static void main( String[] args ) {
    	double  length;
    	double  width;
    	String  response;

    	Scanner sc = new Scanner( System.in );

    	System.out.println( "Welcome to the Area and Perimeter Calculator" );

    	while (true) {
    		System.out.println( "" );
    		System.out.print( "Enter length: " );
    		length = sc.nextDouble();

    		System.out.print( "Enter width:  " );
    		width = sc.nextDouble();

    		System.out.println( "Area:         " + area( length, width ) );
    		System.out.println( "Perimeter:    " + perimeter( length, width ) );

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

    private static double area( double length, double width ) {
    	// area = length * width
    	// round to two decimal digits:  (double) Math.round( area * 100 ) / 100

    	return  (double) Math.round( (length * width) * 100 ) / 100;
    } // end area

    private static double perimeter( double length, double width ) {
    	// perimeter = 2 * (length + width)
    	// round to two decimal digits:  (double) Math.round( perimeter * 100 ) / 100

    	return  (double) Math.round( 2*(length + width) * 100 ) / 100 ;
    } // end perimeter

} // end Wk01Ex01
