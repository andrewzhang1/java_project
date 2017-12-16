package midtermProject;

// An extension of the Account class for a subtype of Checking.
// This account type supports a non-generic type-specific property that between-end-of-period balance
// shall be, not only nonnegative, but also not less than a minimum, the nonnegative end-of-period fee.
//
// Constructors:
//         public Checking()
//         public Checking( double balance, double fee ) throws IllegalArgumentException
// Methods:
//     setters and getters:
//         public void   setBalance( double balance ) throws IllegalArgumentException    // overrides Account.setBalance
//         public void   setFee( double balance ) throws IllegalArgumentException
//         public double getFee()
//     overriding methods of Account superclass:
//         public String toString()
//         public void   withdraw( double amount ) throws IllegalArgumentException
//     implementing abstract methods of Account superclass:
//         public void tally() throws IllegalArgumentException

public class Checking extends Account implements Transactable {

    // instance variables
    private double fee;

    // constructors

    public Checking() {
        this( DEFAULT_BALANCE, CHECKING_FEE );
    } // end Checking

    public Checking( double balance, double fee ) throws IllegalArgumentException {
        super( balance );

        // enforce nonnegative fee
        if ( fee < 0 ) {
            throw new IllegalArgumentException( "Would set negative checking fee" );
        }

        // enforce nonnegative balance - fee (ie, not just nonnegative balance in case of Checking)
        if ( balance >= fee ) {
            this.fee = fee;
        } else {
            throw new IllegalArgumentException( "Would set balance less than minimum (checking fee)" );
        }
    } // end Checking

    // accessors/mutators

    @Override // Account.setBalance
    public void setBalance( double balance ) throws IllegalArgumentException {
        // enforce balance >= fee (a minimum balance)
        if ( balance - fee >= 0 ) {
            super.setBalance( balance );
        } else {
            throw new IllegalArgumentException( "Would set balance less than minimum (checking fee)" );
        }
    }

    public void setFee( double fee ) {
        // enforce nonnegative fee
        if ( fee >= 0 ) {
            this.fee = fee;
        } else {
            throw new IllegalArgumentException( "Would set negative checking fee" );
        }
    }

    public double getFee() {
        return fee;
    }

    // instance methods

    @Override // Account.toString()
    public String toString() {
        return "Checking " + super.toString();
    } // end toString

    @Override // Account.withdraw()
    public void withdraw( double amount ) throws IllegalArgumentException {
        double balance = getBalance();

        // enforce withdrawals result in balance >= fee
        if ( balance - amount >= fee ) {
            balance -= amount;
            super.setBalance( balance );
        } else {
            throw new IllegalArgumentException( "Would result in balance less than minimum (checking fee)" );
        }
    } // end withdraw

    // implements Account.tally()
    public void tally() throws IllegalArgumentException {
        double balance = getBalance();

        // withdrawals result in balance >= fee, so when calling this tally method,
        // checking the balance condition again should be unnecessary; however it is prudent
        if ( balance - fee >= 0 ) {
            // now tally allows paying checking fee, potentially drawing down to zero balance
            balance -= fee;
            super.setBalance( balance );
        } else {
            throw new IllegalArgumentException( "Would result in negative balance" );
        }
    } // end tally

} // end Checking
