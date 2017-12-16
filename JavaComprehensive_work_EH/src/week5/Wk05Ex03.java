package week5;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map;

public class Wk05Ex03 {

    public static void main( String[] args ) {
        ArrayList<Movie>         movies  = new ArrayList<>( 100 );
        TreeMap<String, String>  movies2 = new TreeMap<>();

        String  response;

        Scanner sysin = new Scanner( System.in );
        Validator val = new Validator( sysin );

        System.out.println( "Welcome to the Movie List application" );

        System.out.println( "" );
        System.out.println( "There are 100 movies in the list" );

        // populate arraylist movies
        for ( int i = 0 ; i < 100 ; i++ ) {
            movies.add( MovieIO.getMovie( i+1 ) );
        }

        // populate treemap movies2
        for ( int i = 0 ; i < 100 ; i++ ) {
            movies2.put( MovieIO.getMovie( i+1 ).title, MovieIO.getMovie( i+1 ).category );
        }

        while ( true ) {
            System.out.println( "" );
            // response in { animated, drama, horror, musical, scifi }
            response = val.getString( "What category are you interested in? " );

            // using index on arraylist
            System.out.println( "" );
            for ( int i = 0 ; i < 100 ; i++ ) {
                if ( movies.get( i ).category.equalsIgnoreCase( response ) ) {
                    System.out.println( movies.get( i ).title );
                }
            }

            // using foreach on arraylist
            System.out.println( "" );
            for ( Movie movie : movies ) {
                if ( movie.category.equalsIgnoreCase( response ) ) {
                    System.out.println( movie.title );
                }
            }

            // using foreach on treemap
            System.out.println( "" );
            for ( Map.Entry<String,String> movie : movies2.entrySet() ) {
                if ( movie.getValue().toString().equalsIgnoreCase ( response ) ) {
                    System.out.println( movie.getKey() );
                }
            }

            System.out.println( "" );
            response = val.getString( "Continue? (y/n): " );
            if ( response.equalsIgnoreCase( "y" ) ) {
                continue;
            } else {
                break;
            }
        }

        sysin.close();
    } // main

} // Wk05Ex03