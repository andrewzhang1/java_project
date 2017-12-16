package week6;

import java.nio.file.*;       // Paths
                              // Files
                              // Path  (interface)
import java.io.*;             // File
                              // FileReader, BufferedReader
                              // IOException

import javax.xml.stream.*;    // XMLInputFactory
                              // XMLStreamReader, XMLStreamConstants
                              // XMLStreamException

import java.util.ArrayList;

public class MusicArtistsApp {

    public static void main( String[] args ) {

        String  dir  = "/Users/edwardhuie/Documents/Resources/UC Extension/Java Programming Comprehensive/Homework/week6";
        String  xml  = "music_artists.xml";
        Path    path = Paths.get( dir, xml );
        File    file = path.toFile();

        int     evtType;
        String  eltName;

        String  artist = "";
        String  album  = "";

        ArrayList<String> list = new ArrayList<>();

        if ( Files.exists( path ) ) {        // avoid FileNotFoundException
            XMLInputFactory inFactory = XMLInputFactory.newFactory();

            try {
                XMLStreamReader in = inFactory.createXMLStreamReader(
                                        new BufferedReader(
                                        new FileReader( file ) ) );

                while ( in.hasNext() ) {
                    in.next();
                    
                    evtType = in.getEventType();
                    switch ( evtType ) {
                        case XMLStreamConstants.START_ELEMENT :
                            eltName = in.getLocalName();

                            if ( eltName.equals( "Artists" ) ) {
                                ;
                            } else if ( eltName.equals( "Artist" ) ) {
                                ;
                            } else if ( eltName.equals( "Name" ) ) {
                                artist = in.getElementText();
                            } else if ( eltName.equals( "Albums" ) ) {
                                ;
                            } else if ( eltName.equals( "Album" ) ) {
                                album = in.getElementText();

                                // it appears that on innermost tags (<Album>...</Album>)
                                // getElementText() on START_ELEMENT also reads END_ELEMENT
                                // so that our list append must be done here
                                list.add( artist + "|" + album );
                            }

                            break;
                        case XMLStreamConstants.END_ELEMENT :
                            eltName = in.getLocalName();

                            if ( eltName.equals( "Artists" ) ) {
                                ;
                            } else if ( eltName.equals( "Artist" ) ) {
                                ;
                            } else if ( eltName.equals( "Name" ) ) {
                                ;
                            } else if ( eltName.equals( "Albums" ) ) {
                                ;
                            } else if ( eltName.equals( "Album" ) ) {
                                // it appears that on innermost tags (<Album>...</Album>)
                                // getElementText() on START_ELEMENT also reads END_ELEMENT
                                // so that our list append must be done above
                                //list.add( artist + "|" + album );
                                ;
                            }

                            break;
                        default :
                            break;
                    }
                }

                in.close();
            }
            catch ( IOException | XMLStreamException e) {
                System.out.println( e );
                e.printStackTrace();
            }
        } else {
            System.out.println( xml + " does not exist" );
        }

        System.out.println( "Artist and Album Listing" );

        System.out.println( "" );
        System.out.println( "Artists" );
        System.out.println( "-------" );
        artist = "";
        for ( String item : list ) {
            String[] fields = item.split( "\\|" );

            if ( ! artist.equalsIgnoreCase( fields[0] ) ) {
                artist = fields[0];
                System.out.println( artist );
            }
        }

        System.out.println( "" );
        System.out.println( "Albums" );
        System.out.println( "------" );
        for ( String item : list ) {
            String[] fields = item.split( "\\|" );

            album = fields[1];
            System.out.println( album );
        }

        System.out.println( "" );
        System.out.println( "Artists and Albums" );
        System.out.println( "------------------" );
        artist = "";
        for ( String item : list ) {
            String[] fields = item.split( "\\|" );
            if ( ! artist.equalsIgnoreCase( fields[0] ) ) {
                artist = fields[0];
                System.out.println( artist );
            }

            album = fields[1];
            System.out.println( "\t" + album );
        }

    } // main

} // MusicArtistsApp