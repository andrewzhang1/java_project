package week6;

public class Conversion {

    private String  fromUnit;
    private String  toUnit;
    private double  conversionRatio;

    private double  fromValue;
    private double  toValue;

    public Conversion() {
        // default is (fromUnit = miles, toUnit = kilometers)
        this( "mi", "km", 1.6093 );
    }

    public Conversion( String fromUnit, String toUnit, double conversionRatio ) {
        this.fromUnit        = fromUnit;
        this.toUnit          = toUnit;
        this.conversionRatio = conversionRatio;
    }

    public String getFromUnit() {
        return  fromUnit;
    }

    public String getToUnit() {
        return  toUnit;
    }

    public double getConversionRatio() {
        return  conversionRatio;
    }

    @Override // Object.equals
    public boolean equals ( Object o ) {
        if ( o instanceof Conversion ) {
            Conversion c = (Conversion) o;

            // consider two Conversion objects equal iff fromUnit and toUnit are same
            // and disregard comparing conversionRatio (for purpose of deleting object from array list)
            if ( fromUnit.equalsIgnoreCase( c.fromUnit ) && toUnit.equalsIgnoreCase( c.toUnit ) ) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    } // equals

    @Override // Object.toString
    public String toString() {
        return  fromUnit + "\t" + toUnit + "\t" + conversionRatio;
    } // toString

    public double convert( double fromValue ) {
        this.fromValue = fromValue;
        this.toValue   = this.fromValue * conversionRatio;

        return  this.toValue;
    }

} // Conversion