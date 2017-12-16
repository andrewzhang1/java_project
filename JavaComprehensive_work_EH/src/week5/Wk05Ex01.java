package week5;

import java.util.Scanner;
import java.util.Arrays;

public class Wk05Ex01 {

    public static void main( String[] args ) {
        int     count;
        String  lname;
        String  fname;
        int     score;

        Scanner sysin = new Scanner( System.in );
        Validator val = new Validator( sysin );

        System.out.println( "Welcome to the Student Scores application" );

        System.out.println( "" );
        count = val.getInt( "Enter number of students: " );

        Student[] students = new Student[ count ];

        for ( int i = 0 ; i < count ; i++ ) {
            System.out.println( "" );

            lname = val.getString( "Student " + (i+1) + " last name:  " );
            fname = val.getString( "Student " + (i+1) + " first name: " );
            score = val.getInt(    "Student " + (i+1) + " score:      " );

            students[ i ] = new Student( lname, fname, score );
        }

        // sort by lame/fname, using Comparable (aka natural order)
        Arrays.sort( students );

        System.out.println( "" );
        for ( Student s : students ) {
            System.out.println( s.getLname() + ", " + s.getFname() + ": " + s.getScore() );
        }

        // sort by score, using Comparator
        Arrays.sort( students, new StudentScore() );

        System.out.println( "" );
        for ( Student s : students ) {
            System.out.println( s.getLname() + ", " + s.getFname() + ": " + s.getScore() );
        }

        sysin.close();
    } // main

} // Wk05Ex01