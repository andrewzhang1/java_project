package finalProject;

import java.nio.file.*;        // Paths, Files, Path (interface)
import java.io.*;              // File, FileReader, BufferedReader, FileWriter, BufferedWriter, IOException
import javax.xml.stream.*;     // XMLInputFactory, XMLStreamReader, XMLOutputFactory, XMLStreamWriter, XMLStreamConstants, XMLStreamException
import java.util.ArrayList;

/**
 * The RunnerXML class implements the RunnerDAO interface with XML file as data source.
 */
public class RunnerXML implements RunnerDAO {

    private String             runnerXML;
    private Path               path;
    private File               file;
    private ArrayList<Runner>  runners;

    /**
     * Default constructor, assumes XML file named "RunnerData.xml"
     */
    public RunnerXML() {
        this( "RunnerData.xml" );
    } // RunnerXML

    /**
     * Constructor
     * @param runnerXML String for name of XML file
     */
    public RunnerXML( String runnerXML ) {
        String  directory = "Resources";

        this.runnerXML = runnerXML;

        path = Paths.get( directory, runnerXML );
        file = path.toFile();
    } // RunnerXML

    /**
     * Gets name of XML file data source
     * @return String for name of XML file
     */
    public String getRunnerXML() {
        return runnerXML;
    } // getRunnerXML

    /**
     * Sets name of XML file data source
     * @param runnerXML String for name of XML file
     */
    public void setRunnerXML( String runnerXML ) {
        String  directory = "Resources";

        this.runnerXML = runnerXML;

        path = Paths.get( directory, runnerXML );
        file = path.toFile();
    } // setRunnerXML

    /**
     * Gets array list of runners
     */
    @Override
    public ArrayList<Runner> getRunners() throws IllegalArgumentException, IOException, XMLStreamException {
        int                evtType;
        String             eltName;
        Runner             r    = null;
        ArrayList<Runner>  list = new ArrayList<>();

        if ( Files.exists( path ) ) {
            XMLInputFactory inFactory = XMLInputFactory.newFactory();

            try {
                XMLStreamReader in = inFactory.createXMLStreamReader(
                                     new BufferedReader(
                                     new FileReader( file ) ) );

                while ( in.hasNext() ) {
                    evtType = in.getEventType();

                    switch ( evtType ) {
                    case XMLStreamConstants.START_ELEMENT :
                        eltName = in.getLocalName();

                        if ( eltName.equals( "Runner" ) ) {
                            // begin of runner properties, create runner object; set properties
                            r = new Runner( null, 0, 0 );

                            r.setName( in.getAttributeValue( 0 ) );
                        } else if ( eltName.equals( "RunnersMoveIncrement" ) ) {
                            r.setSpeed( Integer.parseInt( in.getElementText() ) );
                        } else if ( eltName.equals( "RestPercentage" ) ) {
                            r.setRestPct( Integer.parseInt( in.getElementText() ) );
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT :
                        eltName = in.getLocalName();

                        if ( eltName.equals( "Runner" ) ) {
                            // end of runner properties, add runner to array list
                            list.add( r );
                        }
                        break;
                    default :
                        break;
                    }

                    in.next();
                }
            }
            catch ( IOException | XMLStreamException e ) {
                throw e;
            }
        } else {
            throw new IllegalArgumentException( runnerXML + " does not exist" );
        }

        return list;
    } // getRunners

    /**
     * Saves array list of runners to XML file
     * @return Boolean representing success/failure (true/false) of save operation
     */
    private boolean putRunners() throws IOException, XMLStreamException {
        XMLOutputFactory outFactory = XMLOutputFactory.newFactory();

        try {
            // if file exists, overwrite it (ie, FileWriter append option = false (default))
            XMLStreamWriter out = outFactory.createXMLStreamWriter(
                                  new BufferedWriter(
                                  new FileWriter( file ) ) );

            out.writeStartDocument( "1.0" );

            out.writeStartElement( "Runners" );

            for ( Runner r : runners ) {
                out.writeStartElement( "Runner" );
                out.writeAttribute( "Name", r.getName() );

                out.writeStartElement( "RunnersMoveIncrement" );
                out.writeCharacters( Integer.toString( r.getSpeed() ) );
                out.writeEndElement();    // </RunnersMoveIncrement>

                out.writeStartElement( "RestPercentage" );
                out.writeCharacters( Integer.toString( r.getRestPct() ) );
                out.writeEndElement();    // </RestPercentage>

                out.writeEndElement();    // </Runner>
            }

            out.writeEndElement();        // </Runners>

            out.flush();
            out.close();
        }
        catch ( IOException | XMLStreamException e ) {
            throw e;
        }

        return true;
    } // putRunners

    /**
     * Gets runner of given name
     */
    @Override
    public Runner selectRunner(String name) {
        for ( Runner r : runners ) {
            if ( r.getName().equals( name ) ) {
                return r;
            }
        }

        return null;
    } // selectRunner

    /**
     * Adds information of given runner
     */
    @Override
    public boolean insertRunner(Runner r) throws IOException, XMLStreamException {
        runners.add( r );

        try {
            return putRunners();
        }
        catch ( IOException | XMLStreamException e ) {
            throw e;
        }
    } // insertRunner

    /**
     * Modifies information of given runner
     */
    @Override
    public boolean updateRunner(Runner r) throws IOException, XMLStreamException {
        int i = runners.indexOf( selectRunner( r.getName() ) );
        runners.remove( i );
        runners.add( i, r );

        try {
            return putRunners();
        }
        catch ( IOException | XMLStreamException e ) {
            throw e;
        }
    } // updateRunner

    /**
     * Removes information of given runner
     */
    @Override
    public boolean deleteRunner(Runner r) throws IOException, XMLStreamException {
        runners.remove( r );

        try {
            return putRunners();
        }
        catch ( IOException | XMLStreamException e ) {
            throw e;
        }
    } // deleteRunner

} // RunnerXML
