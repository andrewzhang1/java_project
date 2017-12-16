package week8;

// adapted from: www.codexpedia.com/java-merge-sort-implementation

import java.util.ArrayList;

public class MoviesMergeSort implements Runnable {

    private ArrayList<Movie> list;

    public MoviesMergeSort ( ArrayList<Movie> list ){
        this.list = list;
    }

    public void mergeSort() {
        list = sort( list );
    } // mergeSort

    public ArrayList<Movie> sort(ArrayList<Movie> whole) {
        ArrayList<Movie> left  = new ArrayList<Movie>();
        ArrayList<Movie> right = new ArrayList<Movie>();
        int              center;

        if ( whole.size() == 1 ) {    
            return whole;
        } else {
            center = whole.size()/2;
            // copy the left half of whole into the left.
            for ( int i = 0 ; i < center ; i++ ) {
                    left.add( whole.get( i ) );
            }

            //copy the right half of whole into the new arraylist.
            for ( int i = center ; i < whole.size() ; i++ ) {
                    right.add( whole.get(i) );
            }

            // Sort the left and right halves of the arraylist.
            /*
            // single threaded
            left  = sort(left);
            right = sort(right);
            */

            // multi-threaded
            Thread t1 = new Thread( new MoviesMergeSort( left ) );
            Thread t2 = new Thread( new MoviesMergeSort( right ) );
            t1.start();
            t2.start();
            try {
                t1.join();
                t2.join();
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }

            // Merge the results back together.
            merge( left, right, whole );
        }
        return whole;
    } // sort

    private void merge( ArrayList<Movie> left, ArrayList<Movie> right, ArrayList<Movie> whole) {
        int leftIndex  = 0;
        int rightIndex = 0;
        int wholeIndex = 0;

        // As long as neither the left nor the right ArrayList has
        // been used up, keep taking the smaller of left.get(leftIndex)
        // or right.get(rightIndex) and adding it at both.get(bothIndex).
        while ( leftIndex < left.size() && rightIndex < right.size() ) {
            if ( left.get( leftIndex ).compareTo( right.get( rightIndex ) ) < 0 ) {
                whole.set( wholeIndex, left.get( leftIndex ) );
                leftIndex++;
            } else {
                whole.set( wholeIndex, right.get( rightIndex ) );
                rightIndex++;
            }
            wholeIndex++;
        }

        ArrayList<Movie> rest;
        int restIndex;
        if ( leftIndex >= left.size() ) {
            // The left  ArrayList has been used up...
            rest      = right;
            restIndex = rightIndex;
        } else {
            // The right ArrayList has been used up...
            rest      = left;
            restIndex = leftIndex;
        }

        // Copy the rest of whichever (left or right) ArrayList was not used up.
        for ( int i = restIndex ; i < rest.size() ; i++) {
            whole.set( wholeIndex, rest.get( i ) );
            wholeIndex++;
        }
    } // merge

    @Override    // Runnable.run
    public void run() {
        list = sort( list );
    }

} // MoviesMergeSort