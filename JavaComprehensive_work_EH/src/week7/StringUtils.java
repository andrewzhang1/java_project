package week7;

public class StringUtils {

    public static String leftPad( String s, int len ) {
        return String.format( "%" + len + "." + len + "s", s );
    } // leftPad

    public static String rightPad( String s, int len ) {
        return String.format( "%-" + len + "." + len + "s", s );
    } // rightPad

    public static String fixDBString( String s ) {
        // avoid NullPointerException
        if ( s == null ) {
            return s;
        }

        // escape single quote inside double quoted string
        // by inserting another single quote to form adjacent single quotes
        StringBuilder b = new StringBuilder( s );
        for ( int i = 0 ; i < b.length() ; i++ ) {
            if ( b.charAt( i ) == 39 ) {
                b.insert( i++,  "'" );
            }
        }
        return b.toString();
    } // fixDBString

} // StringUtils
