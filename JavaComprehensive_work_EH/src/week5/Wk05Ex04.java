package week5;

import java.util.Scanner;

public class Wk05Ex04 {

    public static void main( String[] args ) {
        Scanner         sysin = new Scanner( System.in );
        StackCalculator calc  = new StackCalculator();

        double[] d;

        System.out.println( "Welcome to the Stack Calculator" );

        System.out.println( "" );
        System.out.println( "Commands: push x, add, sub, mult, div, pow, sqrt, clear, or quit" );

        loop:
        while ( true ) {
            System.out.println( "" );
            System.out.print( "? " );
            String[] tokens = sysin.nextLine().split( "[ ]+" );

            switch ( tokens[0].toLowerCase() ) {
                case "push"  :  calc.push( Double.valueOf( tokens[1] ) );
                                break;
                case "add"   :
                case "+"     :  calc.add();
                                break;
                case "sub"   :
                case "-"     :  calc.subtract();
                                break;
                case "mult"  :
                case "*"     :  calc.multiply();
                                break;
                case "div"   :
                case "/"     :  calc.divide();
                                break;
                case "pow"   :
                case "^"     :  calc.power();
                                break;
                case "sqrt"  :
                case "v"     :  calc.sqrt();
                                break;
                case "clear" :  calc.clear();
                                System.out.println( "empty" );
                                break;
                case "quit"  :  break loop;
                default      :  ;
            }

            d = calc.getValues();
            for ( int i = 0 ; i < d.length ; i++ ) {
                System.out.println( d[ (d.length - 1) - i ] );
            }
        }

        System.out.println( "" );
        System.out.println( "Thanks for using the stack calculator");

        sysin.close();
    } // main

} // Wk05Ex04
