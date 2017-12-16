package finalProject;

/**
 * The StringUtils class provides utility methods for manipulating strings.
 */
public class StringUtils {

    /**
     * Modifies a string, padding with spaces on the left
     * @param s   String for padding
     * @param len int for total length of padded string
     * @return    String with padding
     */
    public static String leftPad( String s, int len ) {
        return String.format( "%" + len + "." + len + "s", s );
    } // leftPad

    /**
     * Modifies a string, padding with spaces on the right
     * @param s   String for padding
     * @param len int for total length of padded string
     * @return    String with padding
     */
    public static String rightPad( String s, int len ) {
        return String.format( "%-" + len + "." + len + "s", s );
    } // rightPad

    /**
     * Modifies a string, escaping single quotes within double quote delimiters (for example in SQL statements)
     * @param s String for escaping single quotes
     * @return  String with escaped single quotes
     */
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
