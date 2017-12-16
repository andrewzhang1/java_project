package week1;

import java.util.Scanner;

public class Wk01Ex02 {

    public static void main( String[] args ) {
    	int     score;
    	String  response;

    	Scanner sc = new Scanner( System.in );

    	System.out.println( "Welcome to the Letter Grade Converter" );

    	while (true) {
    		System.out.println( "" );
    		System.out.print( "Enter numerical grade: " );
    		score = sc.nextInt();

    		System.out.println( "Letter grade: " + toLetter( score ) );

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

    private static char toLetter ( int score ) {
    	char    grade;

    	if ( score > 87 ) {
    		grade = 'A';
    	} else if ( score > 79 ) {
    		grade = 'B';
    	} else if ( score > 66 ) {
    		grade = 'C';
    	} else if ( score > 59) {
    		grade = 'D';
    	} else {
    		grade = 'F';
    	}

    	return  grade;
    } // end toLetter

} // end Wk01Ex02
