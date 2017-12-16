package week2;

import java.util.Scanner;

public class Wk02Ex03 {

    public static void main( String[] args ) {
        double  length;
        double  width;
        String  response;

        Scanner sc = new Scanner( System.in );

        System.out.println( "Welcome to the Area and Perimeter Calculator" );

        while ( true ) {
            System.out.println( "" );

            length = getDoubleWithinRange( sc, "Enter length: ", 0, 1000000 );
            width  = getDoubleWithinRange( sc, "Enter width:  ", 0, 1000000 );
            
            System.out.println( "Area:         " + area( length, width ) );
            System.out.println( "Perimeter:    " + perimeter( length, width ) );

            // see Wk02Ex01 or Wk02Ex02 for another way to validate String input
            System.out.println( "" );
            response = getStringWithinRange( sc, "Continue? (y/n): " );
            if ( ! response.equalsIgnoreCase( "y" ) ) {
                //sc.nextLine();
                break;
            }
        }

        sc.close();
    } // end main

    private static double getDoubleWithinRange( java.util.Scanner sc, String prompt, double min, double max ) {
        double  d;
        
        while ( true ) {
            d = getDouble( sc, prompt );

            if ( d < min ) {
                System.out.println( "Error! Number must be greater than " + min + "." );
                continue;
            } else if ( d > max ) {
                System.out.println( "Error! Number must be less than " + max + "." );
                continue;
            } else {
                break;
            }
        }
            
        return d;
    } // end getDoubleWithinRange

    private static double getDouble( java.util.Scanner sc, String prompt ) {
        double  d;
        
        while ( true ) {
            System.out.print( prompt );
            
            if ( sc.hasNextDouble() ) {
                d = sc.nextDouble();
            
                sc.nextLine();
                break;
            } else {
                System.out.println( "Error! Invalid decimal value. Try again." );
            
                sc.nextLine();
                continue;
            }
        }

        return d;
    } // end getDouble

    private static String getStringWithinRange( java.util.Scanner sc, String prompt ) {
        // WithinRange means in ("y","Y","n","N")

        String  response;
        
        while ( true ) {
            response = getString( sc, prompt );
            if ( response.equalsIgnoreCase( "y" ) || response.equalsIgnoreCase( "n" ) ){
                break;
            } else {
                System.out.println( "Error! Entry must be 'y' or 'n'. Try again." );
                continue;
            }
        }
        
        return response;
    } // end getStringWithinRange
    
    private static String getString( java.util.Scanner sc, String prompt ) {
        String  response;
        
        /*
        while ( true ) {
            System.out.print( prompt );
            
            // do not use hasNext here
            // sc.hasNext() blocks when false, waiting on input
            if ( sc.hasNext() ) {
                response = sc.next();
                
                sc.nextLine();
                break;
            } else {
                System.out.println( "Error: response required" );

                //sc.nextLine();
                continue;
            }
        }
        */
        while ( true ) {
            System.out.print( prompt );
            
            // this alternative works
            // read whole input line, continue loop if too few/many tokens
            String[] tokens = sc.nextLine().split( "[ ]+" );
            
            /*
            if ( tokens.length != 1 ) {
                System.out.println( "Error: expect exactly one value.  Please try again" );
                continue;
            } else {
                //response = tokens[0];
                //return response;
                return  tokens[0];
            }
            */
            if ( ! tokens[0].isEmpty() ) {
                response = tokens[0];

                break;
            } else {
                System.out.println( "Error! This entry is required. Try again." );
                
                continue;
            }
        }
        
        return response;
    } // end getString

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
    
} // end Wk02Ex03
