package midtermProject;

// An abstract class that defines a generic account having a balance attribute and
// a tally() method for end of period credits and charges.
// This class implements the Transactable interface with generic deposit and withdraw methods.
//
// Constructors:
//         public Account()
//         public Account( double balance ) throws IllegalArgumentException
// Methods:
//     setters and getters:
//         public static int    getCount()
//         public        void   setBalance( double balance ) throws IllegalArgumentException
//         public        double getBalance()
//     overriding methods of Object superclass:
//         public string toString()
//     implementing abstract methods of Transactable interface:
//         public void deposit(  double amount ) throws IllegalArgumentException
//         public void withdraw( double amount ) throws IllegalArgumentException
//     abstract methods
//         public abstract void tally()

public abstract class Account implements Transactable {

    // class variables
    private static int count = 0;

    // instance variables
    private double balance;

    // constructors

    public Account() {
        this( DEFAULT_BALANCE );
    } // end Account

    public Account( double balance ) throws IllegalArgumentException {
        // enforce nonnegative balance
        if ( balance >= 0 ) {
            this.balance = balance;

            count++;
        } else {
            throw new IllegalArgumentException( "Would set negative balance" );
        }
    } // end Account

    // accessors/mutators

    public static int getCount() {
        return count;
    } // end getCount

    public void setBalance( double balance ) throws IllegalArgumentException {
        // enforce nonnegative balance
        if ( balance >= 0 ) {
            this.balance = balance;
        } else {
            throw new IllegalArgumentException( "Would set negative balance" );
        }
    } // end setBalance

    public double getBalance() {
        return balance;
    } // end getBalance

    // instance methods

    @Override // Object.toString()
    public String toString() {
        return "Account Balance: " + balance + "\n";
    } // end toString

    // implement Transactable.deposit()
    public void deposit( double amount ) throws IllegalArgumentException {
        // enforce nonnegative balance
        if ( balance + amount >= 0 ) {
            balance += amount;
        } else {
            throw new IllegalArgumentException( "Would result in negative balance" );
        }
    } // end deposit

    // implement Transactable.withdraw()
    public void withdraw( double amount ) throws IllegalArgumentException {
        // enforce nonnegative balance
        if ( balance - amount >= 0 ) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException( "Would result in negative balance" );
        }
    } // end withdraw

    public abstract void tally();

} // end Account
