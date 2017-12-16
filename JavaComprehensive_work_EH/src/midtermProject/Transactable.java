package midtermProject;

// An interface that defines default values for balance, credit and charge attributes,
// and abstract methods for deposit and withdraw transactions.
//
// Constants:
//     public static final double DEFAULT_BALANCE
//     public static final double CHECKING_FEE
//     public static final double SAVING_RATE
// Methods:
//     public abstract void deposit( double amount)
//     public abstract void withdraw( double amount)

public interface Transactable {

    // absent a database, assume all accounts start with default balance
    // assumption: balance >= 0
    double DEFAULT_BALANCE = 1000.00;

    // periodic (monthly) checking service fee and saving interest rate
    // assumption: values >= 0
    double CHECKING_FEE    = 1.00;
    double SAVING_RATE     = 0.01;

    // deposit and withdraw transactions
    // assumption: amount >= 0
    void deposit(  double amount );
    void withdraw( double amount );

} // end Transactable
