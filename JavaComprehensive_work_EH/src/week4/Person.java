package week4;

public abstract class Person {

    private String fname;
    private String lname;
    private String email;

    public Person() {
        fname = "";
        lname = "";
        email = "";
    }

    public void setFname( String s ) {
        this.fname = s;
    }

    public String getFname() {
        return fname;
    }

    public void setLname( String s ) {
        this.lname = s;
    }

    public String getLname() {
        return lname;
    }

    public void setEmail( String s ) {
        this.email = s;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return  "Name: " + fname + " " + lname + "\n" +
                "Email: " + email + "\n";
    }

    public abstract String getDisplayText();

} // end Person

