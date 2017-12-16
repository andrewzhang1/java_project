package week4;

import java.util.Scanner;

public class MyValidator extends OOValidator {

    public MyValidator( Scanner sc ){
        super( sc );
    } // end MyValidator

    public String getRequiredString( String prompt ) {
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
    } // end getRequiredString

    public String getChoiceString( String prompt, String s1, String s2 ) {
        String  s;

        while ( true ) {
            s = getRequiredString( prompt );
            if ( s.equalsIgnoreCase( s1 ) || s.equalsIgnoreCase( s2 ) ) {
                break;
            } else {
                System.out.println( "Error! Entry must be \"" + s1 + "\" or \"" + s2 + "\". Try again." );
                continue;
            }
        }

        return s;
    } // end getChoiceString

} // end MyValidator
