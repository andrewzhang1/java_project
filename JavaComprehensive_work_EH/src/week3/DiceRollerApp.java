package week3;

import java.util.Scanner;

public class DiceRollerApp {

    public static void main( String[] args ) {
        int     roll     = 0;
        String  response;

        Scanner sysin = new Scanner( System.in );

        System.out.println( "Welcome to the Paradise Roller application" );

        PairOfDice dice = new PairOfDice();
        // requirements assume six-sided dice
        // optionally prompt for number of sides, and use
        //        constructor    PairOfDice( sides )
        // or    setter        dice.setSides( sides )

        while (true) {
            System.out.println( "" );
            response = Validator.getString( sysin, "Roll the dice? (y/n): ", "y", "n" );

            if ( response.equalsIgnoreCase( "y" ) ) {
                dice.roll();

                System.out.println( "" );
                System.out.println( "Roll " + ++roll + ":" );
                System.out.println( dice.getValue1() );
                System.out.println( dice.getValue2() );

                switch ( dice.getSum() ) {
                    case  2:  System.out.println( "Snake eyes" );
                              break;
                    case  7:  System.out.println( "Craps!" );
                              break;
                    case 12:  System.out.println( "Box cars!" );
                              break;
                    default:
                }
            } else {
                break;
            }
        }

        sysin.close();
    } // end main

} // end DiceRollerApp
