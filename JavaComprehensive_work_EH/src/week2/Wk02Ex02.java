package week2;

import java.util.Scanner;

public class Wk02Ex02 {

    public static void main( String[] args ) {
        int     integer;
        String  table    = "";
        String  response;

        Scanner sc = new Scanner( System.in );

        System.out.println( "Welcome to the Squares and Cubes Table" );

        while ( true ) {
            System.out.println( "" );            
            while ( true ) {
                System.out.print( "Enter an integer: " );
                if ( sc.hasNextInt() ) {
                    integer = sc.nextInt();

                    sc.nextLine();
                    break;
                } else {
                    System.out.println( "Error: data type mismatch" );

                    sc.nextLine();
                    continue;
                }
            }

            table += "Number\tSquared\tCubed\n";
            table += "======\t=======\t=====\n";
            for ( int i = 1; i < integer + 1; i++ ) {
                table += i + "\t" + i*i + "\t" + i*i*i + "\n";
            }

            System.out.println( "" );
            System.out.print( table );

            // see Wk02Ex01 or Wk02Ex03 for another way to validate String input
            System.out.println( "" );
            while ( true ) {
                System.out.print( "Continue? (y/n): " );
                response = sc.next();
                if ( response.equalsIgnoreCase( "y" ) || response.equalsIgnoreCase( "n" ) ) {
                    sc.nextLine();
                    break;
                } else {
                    System.out.println( "Error: invalid value" );

                    sc.nextLine();
                    continue;
                }
            }

            if ( response.equalsIgnoreCase( "y" ) ) {
                continue;
            } else if ( response.equalsIgnoreCase( "n" ) ) {
                break;
            }
        }

        sc.close();
    } // end main

} // end Wk01Ex02
