package midtermProject;

import java.math.BigDecimal;
import java.math.RoundingMode;

// An extension of the Account class for a subtype of Saving.
//
// Constructors:
//         public Saving()
//         public Saving( double balance, double rate ) throws IllegalArgumentException
// Methods:
//     setters and getters:
//         public void   setRate( double balance ) throws IllegalArgumentException
//         public double getRate()
//     overriding methods of Account superclass:
//         public String toString()
//     implementing abstract methods of Account superclass:
//         public void tally() throws IllegalArgumentException

public class Saving extends Account implements Transactable {

    // instance variables
    private double rate;

    // constructors

    public Saving() {
        this( DEFAULT_BALANCE, SAVING_RATE );
    }

    public Saving( double balance, double rate) throws IllegalArgumentException {
        super( balance );

        // enforce nonnegative rate
        if ( rate >= 0 ) {
            this.rate = rate;
        } else {
            throw new IllegalArgumentException( "Would set negative interest rate" );
        }
    }

    // accessors/mutators

    public void setRate( double rate ) throws IllegalArgumentException {
        // enforce nonnegative rate
        if ( rate >= 0 ) {
            this.rate = rate;
        } else {
            throw new IllegalArgumentException( "Would set negative interest rate" );
        }
    }

    public double getRate() {
        return rate;
    }

    // instance methods

    @Override // Account.toString()
    public String toString() {
        return "Saving " + super.toString();
    } // end toString

    // implements Account.tally()
    public void tally() throws IllegalArgumentException {
        // for multiplication/division operations with doubles, use BigDecimal arithmetic

        // zero
        BigDecimal zeroBD = new BigDecimal( Double.toString( 0 ) );

        // balance
        BigDecimal balanceBD = new BigDecimal( Double.toString( getBalance() ) );
        balanceBD = balanceBD.setScale( 2, RoundingMode.HALF_UP );

        // rate
        BigDecimal rateBD = new BigDecimal( Double.toString( rate ) );
        rateBD = rateBD.setScale( 2, RoundingMode.HALF_UP );

        // balance <- balance + interest = balance + (balance * rate)
        BigDecimal valueBD = balanceBD.add( balanceBD.multiply( rateBD ) );
        valueBD = valueBD.setScale( 2, RoundingMode.HALF_UP );

        // enforce nonnegative balance
        // compareTo() returns 0 or 1 (not -1) meaning == or > (not <)
        if ( valueBD.compareTo( zeroBD ) >= 0 ) {
            Double balanceD = new Double( valueBD.toString() );
            setBalance( balanceD.doubleValue() );
        } else {
            throw new IllegalArgumentException( "Would result in negative balance" );
        }
    } // end tally

} // end Saving
