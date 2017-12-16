package week3;

import java.text.NumberFormat;

public class Circle {

    // class fields    
    private static int     objectCount = 0;

    // instance fields    
    private        double  radius;

    // constructors    
    public Circle() {
        this( 0.0 );
    }

    public Circle( double radius ) {
        this.radius = radius;
        Circle.objectCount++;
    }

    // accessors and mutators
    public static int getObjectCount() {
        return  Circle.objectCount;
    }

    public void setRadius ( double radius ) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    // utility methods
    private String formatNumber( double x ) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMinimumFractionDigits( 2 );
        nf.setMaximumFractionDigits( 2 );
        
        return  nf.format( x );
    }

    // instance methods
    public double getCircumference() {
        return  2 * Math.PI * this.radius;
    }

    public String getFormattedCircumference() {
        return  this.formatNumber( this.getCircumference() );
    }

    public double getArea() {
        return  Math.PI * Math.pow( this.radius, 2 );
    }

    public String getFormattedArea() {
        return  this.formatNumber( this.getArea() );
    }

} // end Circle
