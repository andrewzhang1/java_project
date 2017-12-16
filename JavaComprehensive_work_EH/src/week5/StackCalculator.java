package week5;

public class StackCalculator {

    private GenericStack<Double> s;

    public StackCalculator() {
        s = new GenericStack<Double>();
    }

    public void push ( double x ) {
        s.push( x );
    }

    public double pop() {
        return s.pop();
    }

    public double add() {
        double x = pop();
        double y = pop();

        push( x + y );

        return  x + y;
    }

    public double subtract() {
        double x = pop();
        double y = pop();

        push( y - x );

        return  y - x;
    }

    public double multiply() {
        double x = pop();
        double y = pop();

        push( x * y );

        return  x * y;
    }

    public double divide() {
        double x = pop();
        double y = pop();

        push( y / x );

        return  y / x;
    }

    public double sqrt() {
        double x = pop();

        push( Math.sqrt( x ) );

        return  Math.sqrt( x );
    }

    public double power() {
        double x = pop();
        double y = pop();

        push( Math.pow( y, x ) );

        return  Math.pow( y, x );
    }

    public void clear() {
        s.clear();
    }

    public int size() {
        return s.size();
    }    

    /*
    // this version raises ClassCastException (Object cannot be cast to Double)
    public double[] getValues() {
        Double[] D = (Double[]) s.toArray();
        double[] d = new double[ s.size() ];

        for ( int i = 0 ; i < D.length ; i++ ) {
            d[i] = D[i].doubleValue();
        }

        return d;
    }
    */
    // this version works
    public double[] getValues() {
        Object[] o = s.toArray();
        double[] d = new double[ s.size() ];

        for ( int i = 0 ; i < s.size() ; i++ ) {
            d[i] = Double.valueOf( o[i].toString() );
        }

        return d;
    }

} // StackCalculator
