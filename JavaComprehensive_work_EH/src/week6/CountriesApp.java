package week6;

import java.util.Scanner;
import java.util.ArrayList;

public class CountriesApp {

    public static void main( String[] args ) {

        Scanner    sysin       = new Scanner( System.in );
        Validator  val         = new Validator( sysin );
        String     prompt;
        int        intResponse;
        String     strResponse;

        CountriesTextFile  ctf       = new CountriesTextFile();
        ArrayList<String>  countries = new ArrayList<>();

        System.out.println( "Welcome to the Countries Maintenance application" );

        loop:
        while( true ) {
            prompt = "\n"
                   + "1 - List countries\n"
                   + "2 - Add a country\n"
                   + "3 - Delete a country\n"
                   + "4 - Exit\n";
            System.out.println( prompt );
            intResponse = val.getInt( "Enter menu number: ", 1, 4 );            
            System.out.println( "" );

            switch ( intResponse ) {
                case  1 :
                    countries = ctf.getCountries();
                    for ( String item : countries ) {
                        System.out.println( item );
                    }

                    break;
                case  2 :
                    strResponse = val.getLine( "Enter country: " );
                    ctf.appendCountry( countries, strResponse );
                    ctf.saveCountries( countries );

                    break;
                case  3 :
                    strResponse = val.getLine( "Enter country: " );
                    ctf.deleteCountry( countries, strResponse );
                    ctf.saveCountries( countries );

                    break;
                  case  4 :
                      break loop;
                default :
                    break;
            }
        }

        sysin.close();
        
    } // main

} // CountriesApp