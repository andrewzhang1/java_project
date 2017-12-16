package finalProject;

/**
 * The ThreadRunner class inherits functionality from Runner, and provides execution in threads.
 */
public class ThreadRunner extends Runner implements Runnable {

    /**
     * Constructor
     * @param name    String for name of runner
     * @param speed   int for how far runner travels as one move
     * @param restPct int for likelihood that runner rests on its move
     */
    public ThreadRunner( String name, int speed, int restPct ) {
        super( name, speed, restPct );
    } // ThreadRunner

    /**
     * The run() method of the Runnable interface which is executed by a thread
     */
    @Override
    public void run() {
        Thread t           = Thread.currentThread();
        int    distanceRan = 0;

        while ( ! t.isInterrupted() ) {
            if ( restPct < Math.random() * 100 ) {
                // run:

                // interrupt could be received while running here, causing interrupt flag to be set;
                // interrupt flag set would be detected on next iteration (if distanceRan < RunnerDAO.COURSE_LENGTH)
                distanceRan += speed;
                System.out.println( name + " : " + distanceRan );

                if ( distanceRan >= RunnerDAO.COURSE_LENGTH ) {
                    // if first to call finished(), this thread wins and interrupts other threads;
                    // if not first to call finished(), this thread loses and is interrupted by first caller
                    RunnerApp.finished( name );
                    break;
                }
            } else {
                // rest:

                // interrupt could be received while resting here, causing InterruptedException;
                // note the interrupt flag is not set
                try {
                    Thread.sleep( 100 );
                }
                catch ( InterruptedException e ) {
                    // this thread lost while sleeping
                    System.out.println( name + " : You beat me fair and square." );
                    break;
                }
            }
        }

        // this thread exited the loop either while running (t.isInterrupted() == true) or while resting (InterruptedException);
        // in the latter case, this thread conceded the race in above loop;
        // in the former case, it remains for this thread to concede
        if ( t.isInterrupted() ) {
            // this thread lost while running
            System.out.println( name + " : You beat me fair and square." );
        }
    } // run

} // ThreadRunner
