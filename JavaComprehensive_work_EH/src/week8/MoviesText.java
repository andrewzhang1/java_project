package week8;

import java.util.ArrayList;

import java.nio.file.*;        // Paths
                               // Files
                               // Path  (interface)
import java.io.*;              // File
                               // FileReader, BufferedReader
                               // FileWriter, BufferedWriter, PrintWriter
                               // IOException

public class MoviesText {

    private String  moviesText;
    private Path    path;
    private File    file;

    public MoviesText ( String moviesText ) {
        this.moviesText = moviesText;

        path = Paths.get( moviesText );
        file = path.toFile();
    }

    public void setMoviesText( String moviesText ) {
        this.moviesText = moviesText;

        // also (re)set path and file consistent with conversionsText
        path = Paths.get( moviesText );
        file = path.toFile();
    }

    public String getMoviesText() {
        return  moviesText;
    }

    public ArrayList<Movie> getMovies() {
        String            line;
        String[]          fields;
        ArrayList<Movie>  list = new ArrayList<>();

        if ( ! Files.exists( path ) ) {        // avoid FileNotFoundException
            try {
                Files.createFile( path );
            }
            catch ( IOException e ) {
                e.printStackTrace();

                return  null;
            }
        }

        try ( BufferedReader in = new BufferedReader(
                                  new FileReader( file ) ) )
        {
            line = in.readLine();
            while ( line != null ) {    // avoid EOFException ?
                // fields[0] = actor, fields[1] = title, fields[2] = year
                fields = line.split( "\t" );

                list.add( new Movie( fields[0], fields[1], Integer.valueOf( fields[2] ) ) );

                line = in.readLine();
            }
        }
        catch ( IOException e ) {
            e.printStackTrace();
        }

        return list;
    } // getMovies
   
    public void putMovies ( ArrayList<Movie> list ) {
        /*
        if ( Files.exists( path ) ) {
            System.out.println( path.toAbsolutePath() + " exists");
        } else {
            System.out.println( path.toAbsolutePath() + " does not exist");
        }
        */
        // if file exists, overwrite it (ie, FileWriter append option = false default)
        try ( PrintWriter out = new PrintWriter(
                                new BufferedWriter(
                                new FileWriter( file ) ) ) )
        {
            for ( Movie item : list ) {
                out.println( item.getYear() + "\t" + item.getTitle() + "\t" + item.getActor() );
            }
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
    } // putMovies

} // MoviesText