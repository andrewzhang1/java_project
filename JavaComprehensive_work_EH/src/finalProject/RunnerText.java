package finalProject;

import java.nio.file.*;        // Paths, Files, Path (interface)
import java.io.*;              // File, FileReader, BufferedReader, FileWriter, BufferedWriter, PrintWriter, IOException
import java.util.ArrayList;

/**
 * The RunnerText class implements the RunnerDAO interface with text file as data source.
 */
public class RunnerText implements RunnerDAO {

    private String             runnerText;
    private Path               path;
    private File               file;
    private ArrayList<Runner>  runners;

    /**
     * Default constructor, assumes text file named "RunnerData.txt"
     */
    public RunnerText() {
        this( "RunnerData.txt" );
    } // RunnerText

    /**
     * Constructor
     * @param runnerText String for name of text file
     */
    public RunnerText( String runnerText ) {
        String  directory = "Resources";

        this.runnerText = runnerText;
        
        path = Paths.get( directory, runnerText );
        file = path.toFile();
    } // RunnerText

    /**
     * Gets name of text file data source
     * @return String for name of text file
     */
    public String getRunnerText() {
        return runnerText;
    } // getRunnerText

    /**
     * Sets name of text file data source
     * @param runnerText String for name of text file
     */
    public void setRunnerText( String runnerText ) {
        String  directory = "Resources";

        this.runnerText = runnerText;

        path = Paths.get( directory, runnerText );
        file = path.toFile();
    } // setRunnerText

    /**
     * Gets array list of runners
     */
    @Override
    public ArrayList<Runner> getRunners() throws IllegalArgumentException, IOException {
        String             line;
        String[]           fields;
        ArrayList<Runner>  list = new ArrayList<>();

        if ( Files.exists( path ) ) {
            try (
                BufferedReader in = new BufferedReader(
                                    new FileReader( file ) ) )
            {
                line = in.readLine();
                while ( line != null ) {
                    fields = line.split( FIELD_SEP_REGEX );
                    // fields[0] -> Runner name
                    // fields[1] -> Runner speed
                    // fields[2] -> Runner restPct
                    list.add( new Runner ( fields[0], Integer.parseInt( fields[1] ), Integer.parseInt( fields[2] ) ) );

                    line = in.readLine();
                }
            }
            catch ( IOException e ) {
                throw e;
            }
        } else {
            throw new IllegalArgumentException( runnerText + " does not exist" );
        }

        return list;
    } // getRunners

    /**
     * Saves array list of runners to text file
     * @return Boolean representing success/failure (true/false) of save operation
     */
    private boolean putRunners() throws IOException {

        try (
            // if file exists, overwrite it (ie, FileWriter append option = false (default))
            PrintWriter out = new PrintWriter(
                              new BufferedWriter(
                              new FileWriter( file ) ) ) )
        {
            for ( Runner r : runners ) {
                out.println( r.getName() + FIELD_SEP + r.getSpeed() + FIELD_SEP + r.getRestPct() );
            }
        }
        catch ( IOException e ) {
            throw e;
        }

        return true;
    } // putRunners

    /**
     * Gets runner of given name
     */
    @Override
    public Runner selectRunner( String name ) {
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
    public boolean insertRunner( Runner r ) throws IOException {
        runners.add( r );
        
        try {
            return putRunners();
        }
        catch ( IOException e ) {
            throw e;
        }
    } // insertRunner

    /**
     * Modifies information of given runner
     */
    @Override
    public boolean updateRunner( Runner r ) throws IOException {
        int i = runners.indexOf( selectRunner( r.getName() ) );
        runners.remove( i );
        runners.add( i, r );

        try {
            return putRunners();
        }
        catch ( IOException e ) {
            throw e;
        }
    } // updateRunner

    /**
     * Removes information of given runner
     */
    @Override
    public boolean deleteRunner( Runner r ) throws IOException {
        runners.remove( r );

        try {
            return putRunners();
        }
        catch ( IOException e ) {
            throw e;
        }
    } // deleteRunner

} // RunnerText
