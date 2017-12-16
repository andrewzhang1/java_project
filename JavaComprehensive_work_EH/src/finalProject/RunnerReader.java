package finalProject;

import java.util.ArrayList;

/**
 * The RunnerReader interface represents input functionality of data sources for applications of the Runner class.
 */
public interface RunnerReader {

    /*
     * Gets array list of runners
     * @return array list of Runner objects
     * @throws Exception
     */
    ArrayList<Runner> getRunners() throws Exception;

    /**
     * Gets runner of given name
     * @param  name String for name of runner
     * @return Runner object
     * @throws Exception such as IllegalArgumentException, IOException, XMLStreamException, SQLException
     */
    Runner            selectRunner( String name ) throws Exception;

} // RunnerReader
