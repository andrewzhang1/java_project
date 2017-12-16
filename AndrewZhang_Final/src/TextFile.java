
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class reads the data from the textfile and parses the data to create ThreadRunner object
 * @author 
 *
 */
public class TextFile implements DataSource{

	private File textFile = null;
	private BufferedReader data = null;
	
	
	/**
	 * Constructor - Fetches the textfile name from the user and checks if it is valid
	 * @param input
	 */
    public TextFile(Scanner input) {
    	System.out.print("Enter Text file name: ");
    	String textfilename = input.nextLine(); 
    	textFile = new File(textfilename);
    	this.checkFile();
    }

    
    /**
     * Checks if the file exists 
     */
    private void checkFile() {
    	try {
    		data = new BufferedReader(
    				       new FileReader(textFile));
    		
    	}
    	catch(FileNotFoundException e)
    	{
    		System.out.println("The mentioned File is not found.");
            System.out.println("");
			System.exit(1);
		} catch (Exception ex) {
			System.out.println("The following error occured while reading the file.");
			ex.printStackTrace();
			System.exit(2);
		}
    }
    
    
    /**
     * Override the method declared in the interface.This method reads the data from the file and creates
     * ThreadRunner objects for each runner present in the file
     * @return Arraylist of type ThreadRunner
     */
    @Override
    public ArrayList<ThreadRunner> getRunners() {
    	ArrayList<ThreadRunner> runners = new ArrayList<ThreadRunner>();
    	try {
    		String line = data.readLine();
    		while(line != null) {
    			ThreadRunner runner = getData(line);
    			runners.add(runner);  
    			line = data.readLine();
    		}
    	}
    	catch (IOException e) {
    		System.out.println("The following error occured while reading the file.");
    		e.printStackTrace();
    		System.exit(3);
    	}
		return runners;
    	}
    
    
    /**
     * This method parses the data passed to it and fetches the runner name, speed and the rest percentage
     * @param line - the data from the text file
     * @return - ThreadRunner object
     */
    private ThreadRunner getData(String line) {
    	String name = null;
    	try 
    	{
    		String[] lineParse = line.split("\t");
    		name = lineParse[0];
    		String speedString = lineParse[1];
    		String restString = lineParse[2];
    		int speed = Integer.parseInt(speedString);
    		int rest = Integer.parseInt(restString);
    		return (new ThreadRunner(name,speed,rest));
    	}
    	catch (NumberFormatException num) {
    		System.out.println("The data entered for the speed/rest is not correct for the runner : " + name);	
    		System.exit(1);
    	}
    	catch (Exception ex) {
			System.out.println("An error occured while reading the data from the file");
			System.exit(1);
    	}
		return null;   	
    }
}