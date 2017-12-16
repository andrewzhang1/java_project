package finalProject;

import java.util.ArrayList;

/**
 * The RunnerText class implements the RunnerDAO interface with default data hard-coded.
 */
public class RunnerDefault implements RunnerDAO {

    private ArrayList<Runner>  runners;

    /**
     * Default constructor
     */
    public RunnerDefault() {
        runners = getRunners();
    } // RunnerDefault

    /**
     * Gets array list of runners, from hard-coded data
     */
    @Override
    public ArrayList<Runner> getRunners() {
        ArrayList<Runner> list = new ArrayList<>();

        list.add( new Runner ( "Tortoise",  10, 30 ) );
        list.add( new Runner ( "Hare",     100, 90 ) );

        return list;
    } // getRunners

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
     * Adds information of given runner, which is a no-op for hard-coded data
     */
    @Override
    public boolean insertRunner(Runner r) {
        return false;
    } // insertRunner

    /**
     * Modifies information of given runner, which is a no-op for hard-coded data
     */
    @Override
    public boolean updateRunner(Runner r) {
        return false;
    } // updateRunner

    /**
     * Removes information of given runner, which is a no-op for hard-coded data
     */
    @Override
    public boolean deleteRunner(Runner r) {
        return false;
    } // deleteRunner

} // RunnerDefault
