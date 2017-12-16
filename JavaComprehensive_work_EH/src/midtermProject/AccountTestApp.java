package midtermProject;

import java.util.Scanner;
import java.text.NumberFormat;

// test of Account classes and Transactable interface

public class AccountTestApp {

    // main() executes the following steps:
    //     instantiates Account subtypes Checking and Saving
    //     prompts user for Account transactions
    //     for each requested transaction, invokes method:
    //         transactAccount (which effects the requested transactions for different Account subtypes)
    //     after processing requested transactions, invokes method:
    //         tallyAccount    (which calculates end of period credits/charges for different Account subtypes)
    //     displays resulting credits, charges and final balances

    public static void main( String[] args ) {

        // user response variables
        String  accountType;
        String  transactionType;
        double  amount;
        String  prompt;
        String  response;

        // account reference variables
        Saving   saving   = new Saving();
        Checking checking = new Checking();
//        Account saving   = new Saving();
//        Account checking = new Checking();

        // configure input validation
        Scanner sysin = new Scanner( System.in );
        Validator val = new Validator( sysin );

        // configure output formatting
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        currency.setMinimumFractionDigits( 2 );
        currency.setMaximumFractionDigits( 2 );

        // application screen banner
        System.out.println( "Welcome to the Account application" );

        prompt = "\n"
               + "Starting Balances\n"
               + "Checking: " + currency.format( checking.getBalance() ) + "\n"
               + "Saving:   " + currency.format( saving.getBalance() );
        System.out.println( prompt );

        prompt = "\nEnter the transactions for the month";
        System.out.println( prompt );

        while ( true ) {
            // get user request
            // note that amount >= 0 is enforced (ie, deposits and withdrawals are nonnegative)
            System.out.println( "" );
            transactionType = val.getString( "Withdrawal or deposit? (w/d): ", "w", "d" );
            accountType     = val.getString( "Checking or savings?   (c/s): ", "c", "s" );
            amount          = val.getDouble( "Amount?                     : ", 0.0, Double.MAX_VALUE );

            // execute user request for transactionType (d/w) of amount on accountType (c/s)
            switch ( accountType.toLowerCase() ) {
                case "c" : transactAccount( checking, transactionType, amount );
                           break;
                case "s" : transactAccount( saving, transactionType, amount );
                           break;
                // future cases of accountType; placeholder for default case
                default  : ;
            }

            // continue or exit loop
            System.out.println( "" );
            response = val.getString( "Continue? (y/n): ", "y", "n" );
            if ( response.equalsIgnoreCase( "y" ) ) {
                continue;
            } else {
                break;
            }
        }

        // executed user requested transactions; now display credits/charges to be applied
        prompt = "\n"
               + "Monthly Payments and Fees\n"
               + "Checking fee:             " + currency.format( checking.getFee() ) + "\n"
               + "Savings interest payment: " + currency.format( saving.getBalance() * saving.getRate() );
        System.out.println( prompt );

        // increase/decrease account balance by end of (eg, monthly) period credits/charges
        tallyAccount( checking );
        tallyAccount( saving );

        // display resulting balances
        prompt = "\n"
               + "Final Balances\n"
               + "Checking: " + currency.format( checking.getBalance() ) + "\n"
               + "Savings:  " + currency.format( saving.getBalance() );
        System.out.println( prompt );

        sysin.close();

    } // end main

    private static void transactAccount( Account account, String transactionType, double amount ) {

        String  prompt;

        switch ( transactionType.toLowerCase() ) {
            case "d" :
                try {
                    account.deposit( amount );
                }
                catch ( IllegalArgumentException e ) {
                    prompt = "Error: " + e.getMessage() + "\n"
                           + "Please select different values";
                    System.out.println( prompt );
                }
                break;
            case "w" :
                try {
                    // demonstrates polymorphism since parameter account is of superclass Account
                    // and withdraw() is implemented differently for subclasses Checking and Saving
                    account.withdraw( amount );
                }
                catch ( IllegalArgumentException e ) {
                    prompt = "Error: " + e.getMessage() + "\n"
                           + "Please select different values";
                    System.out.println( prompt );
                }
                break;
            // future cases of transactionType; placeholder for default case
            default  : ;
        }

    } // end transactAccount

    private static void tallyAccount ( Account account ) {

        String  prompt;

        try {
            // demonstrates polymorphism since parameter account is of superclass Account
            // and tally() is implemented differently for subclasses Checking and Saving
            account.tally();
        }
        catch( IllegalArgumentException e ) {
            prompt = "Error: " + e.getMessage() + "\n"
                   + "Please select different values";
            System.out.println( prompt );
        }

    } // end tallyAccount

} // end AccountTestApp
