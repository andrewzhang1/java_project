package week3;

public class Die {

    // instance fields
    private int sides;
    private int value = 0;        // 0 means die not yet rolled

    // constructors
    public Die() {
        this( 6 );
    }

    public Die( int sides ) {
        this.sides = sides;
    }

    // accessors and mutators
    public void setSides( int sides ) {
        this.sides = sides;
    }

    public int getSides() {
        return this.sides;
    }

    // instance methods
    public void roll() {
        this.value = (int) (Math.random() * this.sides) + 1;
    }

    public int getValue() {
        return  this.value;
    }

} // end die
