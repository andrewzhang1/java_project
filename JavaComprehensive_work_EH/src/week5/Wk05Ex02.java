package week5;

import java.text.NumberFormat;

public class Wk05Ex02 {

    public static void main( String[] args ) {
//        double[][] sales = new double[4][4];
//        sales[0][0] = 1540; ... sales[0][3] = 1845;
//        ...
//        sales[3][0] = 1105; ... sales[3][3] = 1576;
        double[][] sales =  {
            { 1540, 2010, 2450, 1845 },
            { 1130, 1168, 1847, 1491 },
            { 1580, 2305, 2710, 1284 },
            { 1105, 4102, 2391, 1576 }
        };

        double sum;

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        currency.setMinimumFractionDigits( 2 );
        currency.setMaximumFractionDigits( 2 );

        System.out.println( "Welcome to the Sales Report application" );

        System.out.println( "" );
        System.out.println( "Region\tQ1\t\tQ2\t\tQ3\t\tQ4" );
        for ( int i = 0 ; i < sales.length ; i++ ) {
            System.out.print( (i+1) );
            for ( int j = 0 ; j < sales[i].length ; j++ ) {
                System.out.print( "\t" + currency.format( sales[i][j] ) );                
            }
            System.out.print( "\n" );
        }

        System.out.println( "" );
        System.out.println( "Sales by region:" );
        for ( int i = 0 ; i < sales.length ; i++ ) {
            sum = 0;
            for ( int j = 0 ; j < sales[i].length ; j++ ) {
                sum += sales[i][j];
            }
            System.out.println( "Region " + (i+1) + ": " + currency.format( sum ) );
        }

        System.out.println( "" );
        System.out.println( "Sales by quarter" );
        for ( int j = 0 ; j < sales[0].length ; j++ ) {
            sum = 0;
            for ( int i = 0 ; i < sales.length ; i++ ) {
                sum += sales[i][j];
            }
            System.out.println( "Q" + (j+1) + ": " + currency.format( sum ) );
        }

        System.out.println( "" );
        sum = 0;
        for ( int i = 0 ; i < sales.length ; i++ ) {
            for ( int j = 0 ; j < sales[i].length ; j++ ) {
                sum += sales[i][j];
            }
        }
        System.out.println( "Total annual sales, all regions: " + currency.format( sum ) );
    } // main

} // Wk05Ex02