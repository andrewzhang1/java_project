package week3;

public class PairOfDice {

    // instance fields
    private Die die1;
    private Die die2;

    private int sum;

    // constructors
    public PairOfDice() {
        die1 = new Die();
        die2 = new Die();
    }

    public PairOfDice( int sides ) {
        die1 = new Die( sides );
        die2 = new Die( sides );
    }

    // accessors and mutators
    public void setSides( int sides ) {
        die1.setSides( sides );
        die2.setSides( sides );
    }

    public int getSides() {
        return  die1.getSides();        // or die2.getSides()
    }

    // instance methods
    public void roll() {
        die1.roll();
        die2.roll();
    }

    public int getValue1() {
        return  die1.getValue();
    }

    public int getValue2() {
        return  die2.getValue();
    }

    public int getSum() {
        this.sum = die1.getValue() + die2.getValue();

        return  this.sum;
    }

} // end PairOfDice
