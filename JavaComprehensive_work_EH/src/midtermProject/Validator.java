package midtermProject;

import java.util.Scanner;

// A utility comprising methods to prompt for user input and validate responses
// (int/double, within specified range; String, among specified options; whole Line).
//
// Constructors:
//     public Validator( Scanner sc )
// Methods:
//     public int    getInt(    String prompt )                            // get first token in response, as int
//     public int    getInt(    String prompt, int min, int max )
//     public double getDouble( String prompt )                            // get first token in response, as double
//     public double getDouble( String prompt, double min, double max )
//     public String getString( String prompt )                            // get first token in response, as String
//     public String getString( String prompt, String s1, String s2 )
//     public String getLine(   String prompt )                            // get whole line  of response

public class Validator {

    // instance variables
    private Scanner sc;

    // constructor
    public Validator( Scanner sc ) {
        this.sc = sc;
    } // end Validator

    // instance methods

    public int getInt( String prompt ) {
        int  i = 0;

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

    public int getInt( String prompt, int min, int max ) {
        int  i = 0;

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
    } // end getInt( , , )

    public double getDouble ( String prompt ) {
        double  d = 0;

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

    public double getDouble( String prompt, double min, double max ) {
        double  d = 0;

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
    } // end getDouble( , , )

    public String getString( String prompt ) {
        String  s = "";

        while ( true ) {
            System.out.print( prompt );

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
    } // end getString( )

    public String getString( String prompt, String s1, String s2 ) {
        String  s = "";

        while ( true ) {
            s = getString( prompt );

            if ( s.equalsIgnoreCase( s1 ) || s.equalsIgnoreCase( s2 ) ) {
                break;
            } else {
                System.out.println( "Error! Entry must be \"" + s1 + "\" or \"" + s2 + "\". Try again." );
                continue;
            }
        }

        return s;
    } // end getString( , , )

    public String getLine( String prompt ) {
        String  s = "";

        while ( true ) {
            System.out.print( prompt );

            s = sc.nextLine();

            if ( ! (s == null || s.equals( "" ) ) ) {
                break;
            } else {
                System.out.println( "Error! This entry is required. Try again." );

                continue;
            }
        }

        return  s;        
    } // end getLine( )

} // end Validator