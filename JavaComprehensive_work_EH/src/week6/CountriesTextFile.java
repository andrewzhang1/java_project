package week6;

import java.util.ArrayList;
import java.util.Iterator;     // allow deleting from array list while reading in foreach loop

import java.nio.file.*;        // Paths
                               // Files
                               // Path  (interface)
import java.io.*;              // File
                               // FileReader, BufferedReader
                               // FileWriter, BufferedWriter, PrintWriter
                               // IOException

public class CountriesTextFile {

    private String  countriesText;
    private Path    path;
    private File    file;

    public CountriesTextFile() {
        this( "/Users/edwardhuie/Documents/Resources/UC Extension/Java Programming Comprehensive/Homework/week6/countries.txt " );
    }

    public CountriesTextFile( String countriesText ) {
        this.countriesText = countriesText;

        path = Paths.get( countriesText );
        file = path.toFile();
    }

    public void setCountriesText( String countriesText ) {
        this.countriesText = countriesText;

        // also (re)set path and file consistent with countriesText
        path = Paths.get( countriesText );
        file = path.toFile();
    }

    public String getCountriesText() {
        return  countriesText;
    }

    public ArrayList<String> getCountries() {
        String             line;
        ArrayList<String>  list = new ArrayList<>();

        if ( Files.exists( path ) ) {           // avoid FileNotFoundException
            try ( BufferedReader in = new BufferedReader(
                                      new FileReader( file ) ) )
            {
                line = in.readLine();
                while ( line != null ) {        // avoid EOFException ?
                    list.add( line );

                    line = in.readLine();
                }
            }
            catch ( IOException e )
            {
                e.printStackTrace();
            }
        } else {
            System.out.println( path.toAbsolutePath() + " does not exist");
        }

        return list;
    } // getCountries

    public void appendCountry ( ArrayList<String> list, String item ) {
        list.add( item );
    } // appendCountry

    public void deleteCountry ( ArrayList<String> list, String item ) {
        /*
        // this results in ConcurrentModificationException
        // workaround is following pattern using Iterator
        for ( String member : list ) {
            if ( member.equalsIgnoreCase( item ) ) {
                list.remove( list.indexOf( member ) );
            }
        }
        */
        Iterator<String> iter = list.iterator();
        while ( iter.hasNext() ) {
            if ( iter.next().equalsIgnoreCase( item ) ) {
                iter.remove();
            }
        }
    } // deleteCountry

    public boolean saveCountries( ArrayList<String> list ) {
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
            for ( String item : list ) {
                out.println( item );
            }
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }

        return true;
    } // saveCountries

} // CountriesTextFile
