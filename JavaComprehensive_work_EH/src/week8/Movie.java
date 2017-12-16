package week8;

public class Movie implements Comparable<Object> {

    private String  actor;
    private String  title;
    private int     year;

    public Movie( String actor, String title, int year) {
        this.actor = actor;
        this.title = title;
        this.year  = year;
    }

    public String getActor() {
        return  actor;
    }

    public String getTitle() {
        return  title;
    }

    public int getYear() {
        return  year;
    }

    @Override    // Comparable.compareTo
    public int compareTo( Object o ) throws IllegalArgumentException {
        int  comparison;

        if ( o instanceof Movie ) {
            Movie m = (Movie) o;

            // order on year
            if ( this.year < m.getYear() ) {
                return  -1;
            } else if ( this.year > m.getYear() ) {
                return   1;
            } else {
                // order on title
                comparison = this.title.compareTo( m.getTitle() );
                if ( comparison != 0 ) {
                    return  comparison;
                } else {
                    // order on actor
                    return  this.actor.compareTo( m.getActor() );
                }
            }
        } else {
            throw new IllegalArgumentException( "Argument " + o.toString() + " is not of type Movie" );
        }
    } // compareTo

} // Movie