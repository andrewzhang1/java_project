package week4;

import java.util.Scanner;

public class OOValidator {

    protected Scanner sc;       // visible to subclass MyValidator where field sc is needed
                                // alternatively, private sc and public getter method

    public OOValidator( Scanner sc ) {
        this.sc = sc;
    } // end OOValidator

    public int getInt( String prompt ) {
        int     i;

        while ( true ) {
            System.out.print( prompt );

            if ( sc.hasNextInt() ) {
                i = sc.nextInt();

                sc.nextLine();
                break;
            } else {
                System.out.println( "Error! Invalid integer value. Try again." );

                sc.nextLine();
                continue;
            }
        }

        return i;        
    } // end getInt( )

    public int getIntWithinRange( String prompt, int min, int max ) {
        int     i;

        while ( true ) {
            i = getInt( prompt );

            if ( i < min ) {
                System.out.println( "Error! Number must be greater than " + min + "." );
                continue;
            } else if ( i > max ) {
                System.out.println( "Error! Number must be less than " + max + "." );
                continue;
            } else {
                break;
            }
        }

        return i;        
    } // end getIntWithinRange( , , )

    public double getDouble ( String prompt ) {
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
    } // end getDouble( )

    public double getDoubleWithinRange( String prompt, double min, double max ) {
        double  d;

        while ( true ) {
            d = getDouble( prompt );

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
    } // end getDoubleWithinRange( , , )

} // end OOValidator
