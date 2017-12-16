package finalProject;

/**
 * The RunnerWriter interface represents output functionality of data sources for applications of the Runner class.
 */
public interface RunnerWriter {

    /**
     * Adds information of given runner
     * @param  r Runner object
     * @return Boolean representing success/failure (true/false) of add operation
     * @throws Exception such as IOException, XMLStreamException, SQLException
     */
    boolean insertRunner( Runner r ) throws Exception;

    /**
     * Modifies information of given runner
     * @param  r Runner object
     * @return Boolean representing success/failure (true/false) of modify operation
     * @throws Exception such as IOException, XMLStreamException, SQLException
     */
    boolean updateRunner( Runner r ) throws Exception;

    /**
     * Removes information of given runner
     * @param  r Runner object
     * @return Boolean representing success/failure (true/false) of remove operation
     * @throws Exception such as IOException, XMLStreamException, SQLException
     */
    boolean deleteRunner( Runner r ) throws Exception;

} // RunnerWriter
