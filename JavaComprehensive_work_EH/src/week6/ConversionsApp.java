package week6;

import java.util.Scanner;
import java.util.ArrayList;

public class ConversionsApp {

    public static void main( String[] args ) {

        Scanner    sysin       = new Scanner( System.in );
        Validator  val         = new Validator( sysin );
        String     prompt;
        int        intResponse;
        double     dblResponse;

        String     fromUnit;
        String     toUnit;
        double     conversionRatio;

        ConversionsTextFile    ctf         = new ConversionsTextFile();
        ArrayList<Conversion>  conversions = new ArrayList<>();

        System.out.println( "Welcome to the Length Converter application" );

        loop:
        while( true ) {
            prompt = "\n"
                   + "1 - List conversions\n"
                   + "2 - Add a conversion\n"
                   + "3 - Delete a conversion\n"
                   + "4 - Convert a length\n"
                   + "5 - Exit\n";
            System.out.println( prompt );
            intResponse = val.getInt( "Enter menu number: ", 1, 5 );            
            System.out.println( "" );

            switch ( intResponse ) {
                case  1 :
                    conversions = ctf.getConversions();
                    for ( int i = 0 ; i < conversions.size() ; i++ ) {
                        Conversion item = conversions.get(i);
                        System.out.println( (i+1) + " - " + item.getFromUnit() + " to " + item.getToUnit() + ": " + item.getConversionRatio() );
                    }

                    break;
                case  2 :
                    conversions = ctf.getConversions();

                    fromUnit        = val.getString( "Enter 'From' Unit: " );
                    toUnit          = val.getString( "Enter 'To' Unit: " );
                    conversionRatio = val.getDouble( "Enter conversion ratio: ");

                    ctf.appendConversion( conversions, new Conversion( fromUnit, toUnit, conversionRatio ) );
                    ctf.saveConversions( conversions );

                    System.out.println( "" );
                    System.out.println( "This entry has been added" );

                    break; 
                case  3 :
                    conversions = ctf.getConversions();
                    for ( int i = 0 ; i < conversions.size() ; i++ ) {
                        Conversion item = conversions.get(i);
                        System.out.println( (i+1) + " - " + item.getFromUnit() + " to " + item.getToUnit() + ": " + item.getConversionRatio() );
                    }

                    System.out.println( "" );
                    intResponse = val.getInt( "Enter conversion number: " );

                    ctf.deleteConversion( conversions, conversions.get( intResponse - 1 ) );
                    ctf.saveConversions( conversions );

                    System.out.println( "" );
                    System.out.println( "This entry has been deleted" );

                    break;
                case  4 :
                    conversions = ctf.getConversions();
                    for ( int i = 0 ; i < conversions.size() ; i++ ) {
                        Conversion item = conversions.get(i);
                        System.out.println( (i+1) + " - " + item.getFromUnit() + " to " + item.getToUnit() + ": " + item.getConversionRatio() );
                    }

                    System.out.println( "" );
                    intResponse = val.getInt( "Enter conversion number: " );
                    dblResponse = val.getDouble( "Enter <fromValue>: ");

                    Conversion item = conversions.get( intResponse - 1 );

                    System.out.println( "" );
                    System.out.println( dblResponse + " " + item.getFromUnit() + " = " + item.convert( dblResponse ) + " " + item.getToUnit() );

                    break;
                case  5 :
                    break loop;
                default :
                    break;
            }
        }

        sysin.close();

    } // main

} // ConversionsApp