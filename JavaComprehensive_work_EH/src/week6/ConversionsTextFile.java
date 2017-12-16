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

public class ConversionsTextFile {

    private String  conversionsText;
    private Path    path;
    private File    file;

    public ConversionsTextFile() {
        this( "/Users/edwardhuie/Documents/Resources/UC Extension/Java Programming Comprehensive/Homework/week6/conversions.txt" );
    }

    public ConversionsTextFile( String conversionsText ) {
        this.conversionsText = conversionsText;

        path = Paths.get( conversionsText );
        file = path.toFile();
    }

    public void setConversionsText( String conversionsText ) {
        this.conversionsText = conversionsText;

        // also (re)set path and file consistent with conversionsText
        path = Paths.get( conversionsText );
        file = path.toFile();
    }

    public String getConversionsText() {
        return  conversionsText;
    }

    public ArrayList<Conversion> getConversions() {
        String                 line;
        String[]               fields;
        ArrayList<Conversion>  list = new ArrayList<>();

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
                // fields[0] = fromUnit, fields[1] = toUnit, fields[2] = conversionRatio
                fields = line.split( "\t" );

                list.add( new Conversion( fields[0], fields[1], Double.valueOf( fields[2] ) ) );

                line = in.readLine();
            }
        }
        catch ( IOException e ) {
            e.printStackTrace();
        }

        return list;
    } // getConversions

    public void appendConversion( ArrayList<Conversion> list, Conversion item ) {
        list.add( item );
    } // appendConversion

    public void deleteConversion ( ArrayList<Conversion> list, Conversion item ) {
        /*
        // this results in ConcurrentModificationException
        // workaround is following pattern using Iterator
        for ( String member : list ) {
            if ( member.equalsIgnoreCase( item ) ) {
                list.remove( list.indexOf( member ) );
            }
        }
        */
        Iterator<Conversion> iter = list.iterator();
        while ( iter.hasNext() ) {
            if ( iter.next().equals( item ) ) {
                iter.remove();
            }
        }
    } // deleteConversion

    public boolean saveConversions ( ArrayList<Conversion> list ) {
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
            for ( Conversion item : list ) {
                out.println( item );
            }
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }

        return true;
    } // saveConversions

} // ConversionsTextFile
