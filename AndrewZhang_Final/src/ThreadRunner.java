import java.util.ArrayList;

//public class ThreadRunner {

	/**
	 * 
	 */

	/**
	 * This class stores all the details for the  runners.
	 * @author mamta-prashant
	 *
	 */
	public class ThreadRunner extends Thread{

		private final String runnerName;
		private final int restPercentage;
		private final int runnerSpeed;
		private int distance = 0;
		ArrayList<String> rank = new ArrayList<String>();
		
		
		/**
		 * Constructor
		 * @param RunnerName - Runners name
		 * @param RunnerSpeed - Runners speed
		 * @param RestPercentage - Rest Percentage
		 */
	
		public ThreadRunner(String runnerName,int runnerSpeed, int restPercentage) {
			
			this.runnerName = runnerName;
			this.restPercentage = restPercentage;
			this.runnerSpeed = runnerSpeed;
		}

	
		
		/**
		 * Based on a random number created , decides if the runner has to sleep or run.If the distance covered is more than 1000
		 * it declares the thread the winner based on the flag condition
		 */
		public void run() {

			while ((distance < 1000) && (!MarathonRaceApp.raceFlag))  {
				int randomNumber = (int)(Math.random() * 100);
				if (randomNumber > restPercentage) {
					distance += runnerSpeed;
				}
				System.out.println(this.getRunnerName() + " : " + distance);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					break;
				}
			}	
			if ((distance >= 1000) && (!MarathonRaceApp.raceFlag)){
				MarathonRaceApp.finished(this);
			}
			
		}
			
		/**
		 * Returns the runner's name
		 * @return name of the runner
		 */
	    public String getRunnerName()
	    {
	        return runnerName;
	    }   
	}
//}
//}