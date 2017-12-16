package week5;

import java.util.Comparator;

public class StudentScore implements Comparator<Object> {

    // implements java.util.Comparator<Object>.compare()
    public int compare( Object o1, Object o2 ) throws IllegalArgumentException {
        int   score1;
        int   score2;

        if ( o1 instanceof Student && o2 instanceof Student ) {
            Student s1 = (Student) o1;
            Student s2 = (Student) o2;

            score1 = s1.getScore();
            score2 = s2.getScore();

            if ( score1 < score2 ) {
                return -1;
            } else if ( score1 > score2 ) {
                return  1;
            } else {
                return  0;
            }
        } else {
            throw new IllegalArgumentException( "Argument " + o1.toString() + " or " + o2.toString() + " is not of type Student" );
        }
    } // end compare

    // implements java.util.Comparator<Object>.equals()
    public boolean equals( Object o1, Object o2 ) throws IllegalArgumentException {
        int   score1;
        int   score2;

        if ( o1 instanceof Student && o2 instanceof Student ) {
            Student s1 = (Student) o1;
            Student s2 = (Student) o2;

            score1 = s1.getScore();
            score2 = s2.getScore();

            return  (score1 == score2);
        } else {
            throw new IllegalArgumentException( "Argument " + o1.toString() + " or " + o2.toString() + " is not of type Student" );
        }
    } // end equals

} // StudentScore