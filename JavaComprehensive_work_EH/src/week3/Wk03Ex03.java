package week3;

import java.util.Scanner;

public class Wk03Ex03 {

    public static void main( String[] args ) {
        String         string;
        StringBuilder  pigStr;
        String         response;

        Scanner sysin = new Scanner ( System.in );

        System.out.println ( "Welcome to the Pig Latin Translator" );

        while ( true ) {
            System.out.println( "" );
            System.out.print( "Enter a line to be translated to Pig Latin: " );
            string = sysin.nextLine();                

            // do the work
            pigStr = getPig( string );

            System.out.println( "" );
            System.out.println( pigStr );

            System.out.println( "" );
            response = Validator.getString( sysin, "Translate another line? (y/n): ", "y", "n" );

            if ( response.equalsIgnoreCase( "y" ) ) {
                continue;
            } else {
                break;
            }
        }

        sysin.close();
    } // end main

    private static boolean isSpaceOrPunctuation( char c ) {
        switch ( (int) c ) {
            case   9 : // tab
            case  32 : // space
            case  33 : // !
            case  44 : // ,
            case  46 : // .
            case  58 : // :
            case  59 : // ;
            case  63 : // ?
                       return true;
            default  : return false;
        }
    } // end isSpaceOrPunctuation

    private static boolean isNumberOrSymbol( char c ) {
        switch ( c ) {
            case '#' :
            case '$' :
            case '%' :
            case '&' :
            case '*' :
            case '+' :
            case '-' :
            case '/' :
            case '0' :
            case '1' :
            case '2' :
            case '3' :
            case '4' :
            case '5' :
            case '6' :
            case '7' :
            case '8' :
            case '9' :
            case '<' :
            case '=' :
            case '>' :
            case '@' :
                       return true;
            default  : return false;
        }
    } // end isNumberOrSymbol

    private static boolean isVowel( char c ) {
        switch ( c ) {
            case 'A' :
            case 'E' :
            case 'I' :
            case 'O' :
            case 'U' :
            case 'a' :
            case 'e' :
            case 'i' :
            case 'o' :
            case 'u' :
                       return true;
            default  : return false;
        }
    } // end isVowel

    private static boolean isConsonantOrContraction( char c ) {
        if (   ( (int) c >= 65 && (int) c <=  90 )        // 'A'(65) <= c <= 'Z'(90)
            || ( (int) c >= 97 && (int) c <= 122 )        // 'a'(97) <= c <= 'z'(122)
            || ( (int) c == 39 )                        // apostrophe
           ) {
            switch ( c ) {
                case 'A' :
                case 'E' :
                case 'I' :
                case 'O' :
                case 'U' :
                case 'a' :
                case 'e' :
                case 'i' :
                case 'o' :
                case 'u' :
                           return false;
                default  : return true;
            }
        } else {
            return false;
        }
    } // end isConsonantOrContraction

    private static StringBuilder getSeparator( StringBuilder s ) {
        // returns first separator substring in s, or null string
        // removes first separator substring in s
        StringBuilder subStr = new StringBuilder( "" );

        for ( int i = 0; i < s.length(); i++ ) {
            if ( isSpaceOrPunctuation( s.charAt( i ) ) ) {
                subStr.append( s.charAt( i ) );
            } else {
                break;
            }
        }

        // delete Separator substring from (beginning of) input string s
        if ( subStr.length() > 0 ) {
            s.delete( 0, subStr.length() );
        }

        // return Separator substring
        return  subStr;
    } // end getSeparator

    private static StringBuilder getWord( StringBuilder s ) {
        // returns first word substring in s, or null string
        // removes first word substring in s
        StringBuilder subStr = new StringBuilder( "" );

        for ( int i = 0; i < s.length(); i++ ) {
            if ( ! isSpaceOrPunctuation( s.charAt( i ) ) ) {
                subStr.append( s.charAt( i ) );
            } else {
                break;
            }
        }

        // delete Word substring from (beginning of) input string s
        if ( subStr.length() > 0 ) {
            s.delete( 0, subStr.length() );
        }

        // return Word substring
        return  subStr;
    } // end getWord

    private static StringBuilder getTranslation( StringBuilder s ) {
        // s is a word
        // returns Pig Latin translation
        char    chr;
        int     idx;
        String  str;

        // case 1:

        // if Word s has any Number or Symbol, return it unaltered
        for ( int i = 0; i < s.length(); i++ ) {
            if ( isNumberOrSymbol( s.charAt( i ) ) ) {
                return  s;
            }
        }

        // case 2:

        // if Word s starts with Vowel, return it with "way" appended
        if ( isVowel( s.charAt( 0 ) ) ) {
            return  s.append( "way" );
        }

        // case 3:

        // if Word s starts with 'y', consider 'y' as consonant, move 'y' to end
        chr = s.charAt( 0 );
        if ( chr == 'y' || chr == 'Y' ) {
            s.delete( 0, 1 );
            s.append( chr );
        }

        // now (after moving starting 'y') if Word s starts with Consonant or Contraction,
        // find index of last contiguous consonant
        idx = -1;
        for ( int i = 0; i < s.length(); i++ ) {
            if ( isConsonantOrContraction( s.charAt( i ) ) ) {
                idx = i;
            } else {
                break;
            }
        }

        // move contiguous consonants to end
        // idx = -1 means no consonants (first character is a vowel)
        if ( idx == 0 ) {
            chr = s.charAt( 0 );
            s.delete( 0, 1 );
            s.append( chr );
        } else if ( idx > 0 ) {
            str = s.substring( 0, idx + 1 );
            s.delete( 0, idx + 1 );
            s.append( str );
        }

        // return it with "ay" appended
        return  s.append( "ay" );
    } // end getTranslation

    private static StringBuilder getPig( String string ) {
        StringBuilder  engStr;
        StringBuilder  pigStr;
        StringBuilder  tmpStr;

        engStr = new StringBuilder( string );
        pigStr = new StringBuilder( "" );

        while ( ! engStr.toString().equals( "" ) ) {
            tmpStr = getSeparator( engStr );
            pigStr.append( tmpStr );

            tmpStr = getWord( engStr );
            pigStr.append( getTranslation( tmpStr ) );
        }

        return  pigStr;
    } // end getPig

} // end Wk03Ex03
