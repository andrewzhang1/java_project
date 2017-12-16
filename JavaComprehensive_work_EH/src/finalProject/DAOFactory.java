package finalProject;

/**
 * The DAOFactory class provides selection from various data sources (including Text file, XML file, Derby database, hard-coded Default)
 */
public class DAOFactory {

    /**
     * Gets DAO for given data source
     * @param type String representing given type of data source (including "TXT", "XML", "SQL", "DEF")
     * @param name String representing given name of data source
     * @return     RunnerDAO object
     */
    public static RunnerDAO getRunnerDAO ( String type, String name ) {
        RunnerDAO  rDAO = null;

        switch ( type.toUpperCase() ) {
        case "DEF" :
            rDAO = new RunnerDefault();
            break;
        case "TXT" :
            rDAO = new RunnerText( name );
            break;
        case "XML" :
            rDAO = new RunnerXML( name );
            break;
        case "SQL" :
            rDAO = new RunnerDB( name );
            break;
        default :
            break;
        }

        return rDAO;
    } // RunnerDAO

} // DAOFactory
