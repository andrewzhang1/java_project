package week1;

import java.util.Scanner;

public class Wk01Ex05 {

    public static void main( String[] args ) {
    	int     cents;
    	String  response;

    	Scanner sc = new Scanner( System.in );

    	System.out.println( "Welcome to the Change Calculator" );

    	while (true) {
    		System.out.println( "" );
    		System.out.print( "Enter number of cents (0-99): " );
    		cents = sc.nextInt();

    		printChange ( cents );

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

    private static void printChange ( int cents ) {
    	int  quarters;
    	int  dimes;
        int  nickels;
        int  pennies;

        quarters  = cents / 25;
        cents    %= 25;
        
        dimes     = cents / 10;
        cents    %= 10;
        
        nickels   = cents /  5;
        cents    %= 5;
        
        pennies   = cents /  1;

        System.out.println( "" );
        System.out.println( "Quarters: " + quarters );
        System.out.println( "Dimes:    " + dimes );
        System.out.println( "Nickels:  " + nickels );
        System.out.println( "Pennies:  " + pennies );

        return;
    } // end printChange

} // end Wk01Ex05
