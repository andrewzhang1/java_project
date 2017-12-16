package week4;

import java.util.Scanner;

public class ValidatorTestApp {

    public static void main( String[] args ) {
        String  prompt;

        Scanner     sc = new Scanner( System.in );
        MyValidator v  = new MyValidator( sc );

        System.out.println( "Welcome to the Validation Tester application" );

        System.out.println( "" );
        System.out.println( "Int Test" );
        prompt = "Enter an integer between -100 and 100: ";
        v.getIntWithinRange( prompt, -100, 100 );

        System.out.println( "" );
        System.out.println( "Double Test" );
        prompt = "Enter any number between -100 and 100: ";
        v.getDoubleWithinRange( prompt, -100, 100 );

        System.out.println( "" );
        System.out.println( "Required String Test" );
        prompt = "Enter your email address: ";
        v.getRequiredString( prompt );

        System.out.println( "" );
        System.out.println( "Choice String Test" );
        prompt = "Select one (x/y): ";
        v.getChoiceString( prompt, "x", "y" );

        sc.close();
    } // end main

} // end ValidatorTestApp
