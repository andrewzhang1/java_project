package week2;

import java.util.Scanner;
import java.text.NumberFormat;
//import java.math.BigDecimal;
//import java.math.RoundingMode;

public class Wk02Ex04Vs02 {

    public static void main( String[] args ) {
    	double  amount;
    	double  rate;
    	int     years;
    	double  payment;
    	String  response;

    	Scanner sc = new Scanner( System.in );
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		NumberFormat percent  = NumberFormat.getPercentInstance();
		
		currency.setMaximumFractionDigits( 2 );								// $.--
		percent.setMaximumFractionDigits( 3 );								// --.---%
		
    	System.out.println( "Welcome to the Loan Calculator" );

    	while ( true ) {
    		System.out.println( "" );
    		System.out.println( "DATA ENTRY" );
    		
    		amount = getDoubleWithinRange( sc, "Enter loan amount:          ", 0, 1000000 );
    		rate   = getDoubleWithinRange( sc, "Enter yearly interest rate: ", 0, 20 );
    		years  = getIntWithinRange(    sc, "Enter number of years:      ", 0, 100);

    		payment = payment( amount, rate, years );
    		
    		System.out.println( "" );
    		System.out.println( "FORMATTED RESULTS" );
    		
    		System.out.println( "Loan Amount:          " + currency.format( amount ) );
    		System.out.println( "Yearly interest rate: " + percent.format( rate ) );
    		System.out.println( "Number of years:      " + years );
    		System.out.println( "Monthly payment:      " + currency.format( payment ) );

			// see Wk02Ex01 or Wk02Ex02 for another way to validate String input
    		System.out.println( "" );
    		response = getStringWithinRange( sc, "Continue? (y/n): " );
    		if ( ! response.equalsIgnoreCase( "y" ) ) {
    			//sc.nextLine();
    			break;
    		}
    	}

    	sc.close();
    } // end main

    private static int getIntWithinRange( java.util.Scanner sc, String prompt, int min, int max ) {
    	int     i;
    	
    	while ( true ) {
    		i = getInt( sc, prompt );

    		if ( i < min ) {
    			System.out.println( "Error! Number must be greater than " + min + "." );
    			continue;
    		} else if ( i > max ) {
    			System.out.println( "Error! Number must be less than " + max + "." );
    			continue;
    		} else {
    			break;
    		}
    	}
    		
		return i;
	} // end getIntWithinRange

    private static int getInt( java.util.Scanner sc, String prompt ) {
    	int     i;
    	
    	while ( true ) {
        	System.out.print( prompt );
        	
    		if ( sc.hasNextInt() ) {
    			i = sc.nextInt();
			
    			sc.nextLine();
    			break;
    		} else {
    			System.out.println( "Error! Invalid integer value. Try again." );
			
    			sc.nextLine();
    			continue;
    		}
    	}

    	return i;
	} // end getInt

    private static double getDoubleWithinRange( java.util.Scanner sc, String prompt, double min, double max ) {
    	double  d;
    	
    	while ( true ) {
    		d = getDouble( sc, prompt );

    		if ( d < min ) {
    			System.out.println( "Error! Number must be greater than " + min + "." );
    			continue;
    		} else if ( d > max ) {
    			System.out.println( "Error! Number must be less than " + max + "." );
    			continue;
    		} else {
    			break;
    		}
    	}
    		
		return d;
	} // end getDoubleWithinRange

    private static Double getDouble( java.util.Scanner sc, String prompt ) {
    	double  d;
    	
    	while ( true ) {
        	System.out.print( prompt );
        	
    		if ( sc.hasNextDouble() ) {
    			d = sc.nextDouble();
			
    			sc.nextLine();
    			break;
    		} else {
    			System.out.println( "Error! Invalid decimal value. Try again." );
			
    			sc.nextLine();
    			continue;
    		}
    	}

    	return d;
	} // end getDouble

    private static String getStringWithinRange( java.util.Scanner sc, String prompt ) {
    	// WithinRange means in ("y","Y","n","N")

    	String  response;
    	
    	while ( true ) {
    		response = getString( sc, prompt );
    		if ( response.equalsIgnoreCase( "y" ) || response.equalsIgnoreCase( "n" ) ){
    			break;
    		} else {
    			System.out.println( "Error! Entry must be 'y' or 'n'. Try again." );
    			continue;
    		}
    	}
    	
    	return response;
    } // end getStringWithinRange
    
    private static String getString( java.util.Scanner sc, String prompt ) {
    	String  response;
    	
    	/*
    	while ( true ) {
    		System.out.print( prompt );
    		
    		// do not use hasNext here
    		// sc.hasNext() blocks when false, waiting on input
    		if ( sc.hasNext() ) {
    			response = sc.next();
    			
    			sc.nextLine();
    			break;
    		} else {
    			System.out.println( "Error: response required" );

    			//sc.nextLine();
    			continue;
    		}
    	}
    	*/
    	while ( true ) {
    		System.out.print( prompt );
    		
    		// this alternative works
    		// read whole input line, continue loop if too few/many tokens
    		String[] tokens = sc.nextLine().split( "[ ]+" );
    		
    		/*
    		// this does not work because always have tokens.length >=1 with tokens[0] existing
    		if ( tokens.length != 1 ) {
    			System.out.println( "Error: expect exactly one value.  Please try again" );
    			continue;
    		} else {
    			response = tokens[0];
    		}
    		*/
    		if ( ! tokens[0].isEmpty() ) {
    			response = tokens[0];
    			
    			break;
    		} else {
    			System.out.println( "Error! This entry is required. Try again." );
    			
    			continue;
    		}
    		
    	}
    	
		return  response;
    } // end getString

    /*
    private static double payment( double amount, double rate, int years ) {
    	// months          = years * 12
    	// monthly rate    = rate / 12
    	// monthly payment = amount * monthlyRate / (1 - 1/Math.pow(1 + monthlyRate, months))

    	int         months      = years * 12;
    	double      monthlyRate = rate / 12.0;
    	
    	BigDecimal  amountBD;
    	BigDecimal  monthlyRateBD;
    	BigDecimal  numeratorBD;
    	BigDecimal  denominatorBD;
    	
    	amountBD      = new BigDecimal( Double.toString( amount ) );
    	monthlyRateBD = new BigDecimal( Double.toString( monthlyRate ) );
    	numeratorBD   = amountBD.multiply( monthlyRateBD );
    	denominatorBD = new BigDecimal( Double.toString( 1 - 1/Math.pow( 1 + monthlyRate,  months )  ) );
    	
		amountBD      = amountBD.setScale( 2, RoundingMode.HALF_UP );
		monthlyRateBD = monthlyRateBD.setScale( 3, RoundingMode.HALF_UP );
		numeratorBD   = numeratorBD.setScale( 2, RoundingMode.HALF_UP );
		denominatorBD = denominatorBD.setScale( 2,  RoundingMode.HALF_UP );
		
    	return  Double.valueOf( numeratorBD.divide( denominatorBD ).toString() );
    } // end payment
    */
    
    private static double payment( double amount, double rate, int years ) {
    	// months          = years * 12
    	// monthly rate    = rate / 12
    	// monthly payment = amount * monthlyRate / (1 - 1/Math.pow(1 + monthlyRate, months))

    	int         months      = years * 12;
    	double      monthlyRate = rate / 12.0;
    	
    	/*
    	BigDecimal  amountBD;
    	BigDecimal  monthlyRateBD;
    	BigDecimal  numeratorBD;
    	BigDecimal  denominatorBD;
    	
    	amountBD      = new BigDecimal( Double.toString( amount ) );
    	monthlyRateBD = new BigDecimal( Double.toString( monthlyRate ) );
    	numeratorBD   = amountBD.multiply( monthlyRateBD );
    	denominatorBD = new BigDecimal( Double.toString( 1 - 1/Math.pow( 1 + monthlyRate,  months )  ) );
    	
		amountBD      = amountBD.setScale( 2, RoundingMode.HALF_UP );
		monthlyRateBD = monthlyRateBD.setScale( 3, RoundingMode.HALF_UP );
		numeratorBD   = numeratorBD.setScale( 2, RoundingMode.HALF_UP );
		denominatorBD = denominatorBD.setScale( 2,  RoundingMode.HALF_UP );
		
    	return  Double.valueOf( numeratorBD.divide( denominatorBD ).toString() );
    	*/
    	return  amount * monthlyRate / ( 1 - 1/Math.pow(1 + monthlyRate, months ) );
    } // end payment
    
} // end Wk02Ex04Vs02
