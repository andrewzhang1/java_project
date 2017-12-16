package finalProject;

import java.util.Scanner;

/**
 * The Validator class provides utility methods to prompt for user input and validate responses.
 */
public class Validator {

    private Scanner  sc;

    /**
     * Constructor
     * @param sc Scanner object for reading user input
     */
    public Validator( Scanner sc ) {
        this.sc = sc;
    } // end Validator

    /**
     * Gets first token of user response as int
     * @param prompt String representing prompt presented to user
     * @return       int representing user response
     */
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
    } // end getInt

    /**
     * Gets first token of user response as int, within given limits
     * @param prompt String representing prompt presented to user
     * @param min    int representing minimum of acceptable values
     * @param max    int representing maximum of acceptable values
     * @return       int representing user response
     */
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
    } // end getInt

    /**
     * Gets first token of user response as double
     * @param prompt String representing prompt presented to user
     * @return       double representing user response
     */
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
    } // end getDouble

    /**
     * Gets first token of user response as double, within given limits
     * @param prompt String representing prompt presented to user
     * @param min    double representing minimum of acceptable values
     * @param max    double representing maximum of acceptable values
     * @return       double representing user response
     */
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
    } // end getDouble

    /**
     * Gets first token of user response as String
     * @param prompt String representing prompt presented to user
     * @return       String representing user response
     */
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
    } // end getString

    /**
     * Gets first token of user response as String, within given limits
     * @param prompt String representing prompt presented to user
     * @param s1     String representing one of several acceptable values
     * @param s2     String representing one of several acceptable values
     * @return       String representing user response
     */
    public String getString( String prompt, String s1, String s2 ) {
        String  s = "";

        while ( true ) {
            s = getString( prompt );

            if ( s.equals( s1 ) || s.equals( s2 ) ) {
                break;
            } else {
                System.out.println( "Error! Entry must be \"" + s1 + "\" or \"" + s2 + "\". Try again." );
                continue;
            }
        }

        return s;
    } // end getString

    /**
     * Gets all tokens of user response as String
     * @param prompt String representing prompt presented to user
     * @return       String representing user response (whole string, unparsed)
     */
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
    } // end getLine

    /**
     * Gets first token of user response as String representing email address
     * @param prompt String representing prompt presented to user
     * @return       String representing user response
     */
    public String getEmail( String prompt ) {
        String s = "";

        while ( true ) {
            s = getString( prompt );

            if ( s.matches( "^[a-zA-Z_0-9]+@[a-zA-Z_0-9]+.[.a-zA-Z_0-9]*[a-zA-Z_0-9]+$" ) ) {
                // approximate regex for matching xxx@yyy.[...]zzz
                break;
            } else {
                System.out.println( "Error! Entry must be of form xxx@yyy.[...]zzz" );
                continue;
            }
        }

        return s;
    } // getEmail

} // end Validator
