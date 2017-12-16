package finalProject;

/**
 * The Runner class represents a runner in a race.
 */
public class Runner {

    protected String  name;
    protected int     speed;
    protected int     restPct;

    /**
     * Constructor
     * @param name    String for name of runner
     * @param speed   int for how far runner travels as one move
     * @param restPct int for likelihood that runner rests on its move
     */
    public Runner ( String name, int speed, int restPct ){
        this.name    = name;
        this.speed   = speed;
        this.restPct = restPct;
    } // Runner

    /**
     * Gets runner parameter name
     * @return String for name of runner
     */
    public String getName() {
        return name;
    } // getName

    /**
     * Sets runner parameter name
     * @param name String for name of runner
     */
    public void setName( String name ) {
        this.name = name;
    } // setName

    /**
     * Gets runner parameter speed
     * @return int for speed of runner
     */
    public int getSpeed() {
        return speed;
    } // getSpeed

    /**
     * Sets runner parameter speed
     * @param speed int for speed of runner
     */
    public void setSpeed( int speed ) {
        this.speed = speed;
    } // setSpeed

    /**
     * Gets runner parameter restPct
     * @return int for likelihood of resting
     */
    public int getRestPct() {
        return restPct;
    } // getRestPct

    /**
     * Sets runner parameter restPct
     * @param restPct int for likelihood of resting
     */
    public void setRestPct( int restPct ) {
        this.restPct = restPct;
    } // setRestPct

} // Runner
