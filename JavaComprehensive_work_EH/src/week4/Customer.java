package week4;

public class Customer extends Person {

    private String customerNumber;

    public Customer() {
        super();
    }

    public void setCustomerNumber( String s ) {
        this.customerNumber = s;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public String getDisplayText() {
        return  super.toString() +
                "Customer number: " + customerNumber + "\n";
    }

} // end Customer
