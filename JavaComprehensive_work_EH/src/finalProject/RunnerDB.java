package finalProject;

import java.sql.*;
import java.util.ArrayList;

/**
 * The RunnerDB class implements the RunnerDAO interface with Derby database as data source.
 */
public class RunnerDB implements RunnerDAO {

    private String  runnerDB;
    
    // note: unlike other classes (RunnerText, RunnerXML) in this package, this class does not have instance variable
    //    private ArrayList<Runner>  runners;
    // as none of its instance methods uses it; instead all data modifications are directly with database

    /**
     * Default constructor, assumes Derby database named "RunnerDB"
     */
    public RunnerDB() {
        this( "RunnerDB" );
    } // RunnerDB

    /**
     * Constructor
     * @param runnerDB String for name of Derby database
     */
    public RunnerDB( String runnerDB ) {
        this.runnerDB = runnerDB;
    } // RunnerDB

    /**
     * Gets name of Derby database data source
     * @return String for name of Derby database
     */
    public String getRunnerDB() {
        return runnerDB;
    } // getRunnerDB

    /**
     * Sets name of Derby database data source
     * @param runnerDB String for name of Derby database
     */
    public void setRunnerDB( String runnerDB ) {
        this.runnerDB = runnerDB;
    } // setRunnerDB

    /**
     * Gets connection to database, assumes Derby database in default (Eclipse project) folder
     * @return Connection object
     */
    private Connection getConnection() throws SQLException {
        String  directory = "Resources";
        String  url       = "jdbc:derby:" + runnerDB;
        String  username  = "";
        String  password  = "";

        System.setProperty( "derby.system.home", directory );

        try {
            return DriverManager.getConnection( url, username, password );
        }
        catch ( SQLException e ) {
            throw e;
        }
    } // getConnection

    /**
     * Gets array list of runners
     */
    @Override
    public ArrayList<Runner> getRunners() throws SQLException {
        String             sql;
        ArrayList<Runner>  list = new ArrayList<>();

        sql = "select  name, "
            + "        speed, "
            + "        restPct "
            + "from    RunnerStats";

        try (
            Connection        cn = getConnection();
            PreparedStatement ps = cn.prepareStatement( sql );
            ResultSet         rs = ps.executeQuery();
            )
        {
            while ( rs.next() ) {
                list.add( new Runner( rs.getString( "name" ), rs.getInt( "speed" ), rs.getInt( "restPct" ) ) );
            }

            return list;
        }
        catch ( SQLException e )
        {
            throw e;
        }
    } // getRunners

    // no setRunners() method as changes are implemented at statement level (insert, update, delete), 
    // rather than as multi-statement transactions

    /**
     * Gets runner of given name
     */
    @Override
    public Runner selectRunner( String name ) throws SQLException {
        String  sql;
        Runner  runner;

        sql = "select  name, "
            + "        speed, "
            + "        restPct "
            + "from    RunnerStats "
            + "where   name = ?";

        try (
            Connection        cn = getConnection();
            PreparedStatement ps = cn.prepareStatement( sql );
            )
        {
            ps.setString( 1, name );
            ResultSet rs = ps.executeQuery();

            if ( rs.next() ) {
                runner = new Runner( name, rs.getInt( "speed" ), rs.getInt( "restPct" )  );
                rs.close();      // rs not autoclosed as in try-with-resources
                return runner;
            } else {
                rs.close();      // rs not autoclosed as in try-with-resources
                return null;
            }
        }
        catch ( SQLException e )
        {
            throw e;
        }
    } // selectRunner

    /**
     * Adds information of given runner
     */
    @Override
    public boolean insertRunner( Runner r ) throws SQLException {
        String  sql;

        sql = "insert "
            + "into    RunnerStats ( "
            + "        name, "
            + "        speed, "
            + "        restPct "
            + "        ) "
            + "values  ( "
            + "        ?, "
            + "        ?, "
            + "        ? "
            + "        )";

        try (
            Connection        cn = getConnection();
            PreparedStatement ps = cn.prepareStatement( sql );
            )
        {
            ps.setString( 1, r.getName() );
            ps.setInt(    2, r.getSpeed() );
            ps.setInt(    3, r.getRestPct() );
            ps.executeUpdate();

            return true;
        }
        catch ( SQLException e )
        {
            throw e;
        }
    } // insertRunner

    /**
     * Modifies information of given runner
     */
    @Override
    public boolean updateRunner( Runner r ) throws SQLException {
        String  sql;

        sql = "update  RunnerStats "
            + "set     speed   = ?, "
            + "        restPct = ? "
            + "where   name    = ?";

        try (
            Connection        cn = getConnection();
            PreparedStatement ps = cn.prepareStatement( sql );
            )
        {
            ps.setInt(    1, r.getSpeed() );
            ps.setInt(    2, r.getRestPct() );
            ps.setString( 3, r.getName() );
            ps.executeUpdate();

            return true;
        }
        catch ( SQLException e )
        {
            throw e;
        }
    } // updateRunner

    /**
     * Removes information of given runner
     */
    @Override
    public boolean deleteRunner( Runner r ) throws SQLException {
        String  sql;

        sql = "delete "
            + "from    RunnerStats "
            + "where   name = ?";

        try (
            Connection        cn = getConnection();
            PreparedStatement ps = cn.prepareStatement( sql );
            )
        {
            ps.setString( 1, r.getName() );
            ps.executeUpdate();

            return true;
        }
        catch ( SQLException e )
        {
            throw e;
        }
    } // deleteRunner

} // RunnerDB
