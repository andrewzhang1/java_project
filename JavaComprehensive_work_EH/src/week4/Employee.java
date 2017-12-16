package week4;

public class Employee extends Person {

    private String socialSecurityNumber;

    public Employee() {
        super();
    }

    public void setSocialSecurityNumber( String s ) {
        this.socialSecurityNumber = s;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public String getDisplayText() {
        return  super.toString() +
                "Social Security number: " + socialSecurityNumber + "\n";
    }

} // end Employee
