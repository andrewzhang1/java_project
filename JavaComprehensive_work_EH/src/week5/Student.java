package week5;

// java.lang.Comparable;

public class Student implements Comparable<Object> {

    private String  lname;
    private String  fname;
    private int     score;

    public Student( String lname, String fname, int score ) {
        this.lname = lname;
        this.fname = fname;
        this.score = score;
    }

    public void setLname( String lname ) {
        this.lname = lname;
    }

    public String getLname() {
        return lname;
    }

    public void setFname( String fname ) {
        this.fname = fname;
    }

    public String getFname() {
        return fname;
    }

    public void setScore( int score ) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    // implements java.lang.Comparable<Object>.compareTo()
    public int compareTo( Object o ) throws IllegalArgumentException {
        int  comparison;

        if ( o instanceof Student ) {
            Student s = (Student) o;

            comparison = this.getLname().compareTo( s.getLname() );
            if ( comparison != 0 ) {
                return comparison;
            } else {
                comparison = this.getFname().compareTo( s.getFname() );
                if ( comparison != 0 ) {
                    return comparison;
                } else {
                    return 0;
                }
            }
        } else {
            throw new IllegalArgumentException( "Argument " + o.toString() + " is not of type Student" );
        }
    } // compareTo

} // Student