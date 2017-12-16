package finalProject;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * The RunnerApp class represents a race between multiple competitors with indeterminate outcome.
 */
public class RunnerApp {

    private static ArrayList<Thread>  threads = new ArrayList<>();

    /**
     * The main() method or entry point to this application
     * @param args array of Strings representing command line arguments (not used here)
     */
    public static void main( String[] args ) {
        Scanner   in          = new Scanner( System.in );
        Validator val         = new Validator( in );
        int       intResponse;
        String    strResponse;

        RunnerDAO          rDAO    = null;
        ArrayList<Runner>  runners = null;

        System.out.println( "Welcome to the Marathon Race Runner Program" );
        System.out.println( "" );

        loop:
        while ( true ) {
            System.out.println( "Select your data source:" );
            System.out.println( "" );
            System.out.println( "1. Default runners (Tortoise and Hare)" );
            System.out.println( "2. Text file" );
            System.out.println( "3. XML file" );
            System.out.println( "4. Derby database" );
            System.out.println( "5. Exit" );
            System.out.println( "" );

            intResponse = val.getInt( "Enter your choice: ", 1, 5 );
            if ( intResponse == 2 ) {
                strResponse = val.getString( "Enter Text file name: " );
            } else if ( intResponse == 3 ) {
                strResponse = val.getString( "Enter XML file name: " );
            } else if ( intResponse == 4 ) {
                strResponse = val.getString( "Enter Derby database name: " );
            } else {
                strResponse = null;
            }
            System.out.println( "" );

            switch ( intResponse ) {
            case 1 :
                rDAO = DAOFactory.getRunnerDAO( "DEF", strResponse );
                break;
            case 2 :
                rDAO = DAOFactory.getRunnerDAO( "TXT", strResponse );
                break;
            case 3 :
                rDAO = DAOFactory.getRunnerDAO( "XML", strResponse );
                break;
            case 4 :
                rDAO = DAOFactory.getRunnerDAO( "SQL", strResponse );
                break;
            case 5 :
                // user exits
                break loop;
            }

            // get array list of runners from selected data source
            try {
                runners = rDAO.getRunners();
            }
            catch ( Exception e ) {
                System.out.println( e.getMessage() );
                System.out.println( "" );
                continue;
            }

            // (re-)initialize array list of threads
            threads.clear();

            // load runner objects into array list of runners
            for ( Runner r : runners ) {
                // create runner thread
                Thread t = new Thread( new ThreadRunner( r.getName(), r.getSpeed(), r.getRestPct() ), r.getName() );

                // save runner thread reference into array list of threads
                threads.add( t );
            }

            System.out.println( "On your marks! Get set! Go!" );
            System.out.println( "" );

            // start the race in (near) unison
            for ( Thread t : threads ) {
                t.start();
            }

            // this main thread waits for each runner thread to terminate
            for ( Thread t : threads ) {
                try {
                    t.join();
                }
                catch ( InterruptedException e ) {
                    System.out.println( "" );
                    System.out.println( "Unexpected problem with threads; printing stack trace" );
                    e.printStackTrace();
                    System.out.println( "" );
                    break;
                }
            }
            
            System.out.println( "" );
            System.out.println( "Press Enter to continue ...");
            in.nextLine();
        }

        System.out.println( "Thank you for using my Marathon Race Program" );
    } // main

    /**
     * This method: provides serialization (to determine first caller, preventing ties); interrupts other runners (to end their race)
     * @param name String representing name of runner that calls the method
     */
    public static synchronized void finished( String name ) {
        // caller wins the race
        System.out.println( name + " : I finished!" );
        System.out.println( "" );

        System.out.println( "The race is over: " + name + " is the winner!");
        System.out.println( "" );

        // others concede the race
        for ( Thread t : threads ) {
            if ( ! t.getName().equals( name ) ) {
                t.interrupt();
            }
        }
    } // finished

} // RunnerApp
