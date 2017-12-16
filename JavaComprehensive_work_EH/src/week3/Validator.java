package week3;

import java.util.Scanner;

public class Validator {

    public static int getInt( Scanner sc, String prompt ) {
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
    } // end getInt( , )

    public static int getInt( Scanner sc, String prompt, int min, int max ) {
        int     i;

        while ( true ) {
            i = getInt( sc, prompt );

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
    } // end getInt( , , , )

    public static Double getDouble( Scanner sc, String prompt ) {
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
    } // end getDouble( , )

    public static double getDouble( Scanner sc, String prompt, double min, double max ) {
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
    } // end getDouble( , , , )

    public static String getString( Scanner sc, String prompt ) {
        String  s;

        /*
        while ( true ) {
            System.out.print( prompt );
            
            // do not use hasNext here
            // sc.hasNext() blocks when false, waiting on input
            if ( sc.hasNext() ) {
                s = sc.next();

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

            if ( ! tokens[0].isEmpty() ) {
                s = tokens[0];

                break;
            } else {
                System.out.println( "Error! This entry is required. Try again." );

                continue;
            }
        }

        return  s;
    } // end getString( , )

    public static String getString( Scanner sc, String prompt, String option1, String option2 ) {
        String  s;

        while ( true ) {
            s = getString( sc, prompt );
            if ( s.equalsIgnoreCase( option1 ) || s.equalsIgnoreCase( option2 ) ) {
                break;
            } else {
                System.out.println( "Error! Entry must be \"" + option1 + "\" or \"" + option2 + "\". Try again." );
                continue;
            }
        }

        return s;
    } // end getString( , , , )

} // end Validator
