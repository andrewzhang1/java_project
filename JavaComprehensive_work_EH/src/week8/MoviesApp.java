package week8;

import java.util.ArrayList;

public class MoviesApp {

    public static void main( String[] args ) {

        String  inMoviesText  = "/Users/edwardhuie/Documents/Resources/UC Extension/Java Programming Comprehensive/Homework/week8/imdb.tsv";
        String  outMoviesText = "/Users/edwardhuie/Documents/Resources/UC Extension/Java Programming Comprehensive/Homework/week8/sort.tsv";

        MoviesText inMovies  = new MoviesText( inMoviesText );
        MoviesText outMovies = new MoviesText( outMoviesText );

        // read unsorted input file into arraylist
        ArrayList<Movie> list = inMovies.getMovies();

        // sort arraylist
        /*
        // single threaded
        MoviesMergeSort sorter = new MoviesMergeSort( list );
        sorter.mergeSort();
        */
        // multi-threaded
        Thread t = new Thread( new MoviesMergeSort( list ) );
        t.start();
        try {
            t.join();
        } catch( InterruptedException e ) {
            e.printStackTrace();
        }

        // write sorted arraylist into output file
        outMovies.putMovies( list );
    } // main

} // MoviesApp