package week2;

import java.util.Scanner;
import java.text.NumberFormat;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Wk02Ex01 {

    public static void main( String[] args ) {
        BigDecimal  amount;
        BigDecimal  rate;
        BigDecimal  interest;
        String      response;

        Scanner      sc       = new Scanner( System.in );
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        NumberFormat percent  = NumberFormat.getPercentInstance();

        currency.setMaximumFractionDigits( 2 );                             // $.--
        percent.setMaximumFractionDigits( 3 );                              // --.---%

        System.out.println( "Welcome to the Interest Calculator" );

        while ( true ) {
            System.out.println( "" );
            while ( true ) {
                System.out.print( "Enter loan amount:\t" );
                if ( sc.hasNextDouble() ) {
                    amount = new BigDecimal( sc.next() );
                    amount = amount.setScale( 2, RoundingMode.HALF_UP );    // ($).--

                    sc.nextLine();
                    break;
                } else {
                    System.out.println( "Error: data type mismatch" );

                    sc.nextLine();
                    continue;
                }
            }

            while ( true ) {
                System.out.print( "Enter interest rate:\t" );
                if ( sc.hasNextDouble() ) {
                    rate = new BigDecimal( sc.next() );
                    rate = rate.setScale( 5, RoundingMode.HALF_UP );        // --.---(%)

                    sc.nextLine();
                    break;
                } else {
                    System.out.println( "Error: data type mismatch" );

                    sc.nextLine();
                    continue;
                }
            }

            interest = amount.multiply( rate );
            interest = interest.setScale( 2, RoundingMode.HALF_UP );

            System.out.println( "" );
            System.out.println( "Loan amount:\t"   + currency.format( amount ) );
            System.out.println( "Interest rate:\t" + percent.format( rate ) );
            System.out.println( "Interest:\t"      + currency.format( interest ) );

            // see Wk02Ex02 or Wk02Ex03 for another way to validate String input
            System.out.println( "" );
            System.out.print( "Continue? (y/n): " );
            response = sc.next();
            if ( ! response.equalsIgnoreCase( "y" ) ) {
                sc.nextLine();
                break;
            }
        }

        sc.close();
    } // end main

} // end Wk01Ex01
