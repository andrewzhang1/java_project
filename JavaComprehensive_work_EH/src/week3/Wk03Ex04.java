package week3;

import java.util.Scanner;

public class Wk03Ex04 {

    public static void main( String[] args ) {
        int     number;
        String  word;
        String  response;

        Scanner sysin = new Scanner( System.in );

        System.out.println( "Welcome to the Number to Word Converter" );

        while ( true ) {
            System.out.println( "" );
            number = Validator.getInt( sysin, "Enter the number you want to convert to words: ", 0, 9999 );;

            // do the work
            word = getWord( number );

            System.out.println( "" );
            System.out.println( word );

            System.out.println( "" );
            response = Validator.getString( sysin, "Convert another number? (y/n): ", "y", "n" );

            if ( response.equalsIgnoreCase( "y" ) ) {
                continue;
            } else {
                break;
            }
        }
    } // end main

    private static int getDigit( int number, int power ) {
        int  quotient  = number;
        int  remainder = 0;

        for ( int i = 0; i < power + 1; i++ ) {
            remainder = quotient % 10;
            quotient  = quotient / 10;
        }

        return  remainder;
    } // end getDigit

    private static String getWord( int number ) {
        final String[]  WORD0 = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        final String[]  WORD1 = { "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
        final String[]  WORD2 = { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

        int     thousands = getDigit( number, 3 );
        int     hundreds  = getDigit( number, 2 );
        int     tens      = getDigit( number, 1 );
        int     units     = getDigit( number, 0 );

        String str = "";

        // note: in all cases, begin str with space " ", to follow a canonical form

        if ( thousands == 0 ) {
            ;
        } else {
            str += " " + WORD0[thousands] + " thousand";
        }

        if ( hundreds == 0 ) {
            ;
        } else {
            str += " " + WORD0[hundreds] + " hundred";
        }

        if ( tens == 0 ) {
            if ( units == 0 ) {
                ;
            } else {
                str += " " + WORD0[units];
            }
        } else if ( tens == 1 ) {
            str += " " + WORD1[units];
        } else {
            if ( units == 0 ) {
                str += " " + WORD2[tens];
            } else {
                str += " " + WORD2[tens] + " " + WORD0[units];
            }
        }

        // case not covered above (thousands/hundreds/tens may all be zero)
        if ( thousands == 0 && hundreds == 0 && tens == 0 && units == 0 ) {
            str = " " + WORD0[units];    // " zero"
        }

        // remove beginning space " " of str, return normalized string
        return  str.substring( 1 );
    } // getWord

} // end Wk03Ex04
