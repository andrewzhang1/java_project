package week3;

import java.text.NumberFormat;
import java.math.BigDecimal;
import java.math.RoundingMode;

import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;

public class Test {
	public static void main( String[] args ) {
		double pct = 0.0755;
		
		System.out.println("");
		NumberFormat fmt = NumberFormat.getPercentInstance();
		String str = fmt.format( pct );
		System.out.println( str );
		
		fmt.setMinimumFractionDigits( 2 );
		String str2 = fmt.format( pct );
		System.out.println( str2 );
		
		
		int qty = 5;
		
		System.out.println("");
		System.out.println( "qty = " + qty );
		int tot = qty++;
		System.out.println( "qty = " + qty );
		System.out.println( "tot = " + tot );
		
	
		int x = 100;
		float y = 1.587F;
		double z = 4.8;
		
		System.out.println("");
		System.out.println( "x = " + x );
		System.out.println( "y = " + y );
		System.out.println( "Math.round(y) = " + Math.round(y) );
		System.out.println( "z = " + z );
		System.out.println( "(int) z = " + (int) z );
		System.out.println( "x + Math.round(y) + (int)z = " + (x + Math.round(y) + (int)z) );
		
		
		BigDecimal totalOne = new BigDecimal( 6.728 );
		BigDecimal totalTwo = new BigDecimal( 116 );
		totalOne = totalOne.setScale(2, RoundingMode.HALF_UP);
		BigDecimal totalFinal = totalTwo.add(totalOne);
		System.out.println( "totalFinal = " + totalFinal );
		
		GregorianCalendar start = new GregorianCalendar(2002, 4, 2);
		Date startDate = start.getTime();
		System.out.println(startDate.toString());
		
		StringBuilder name = new StringBuilder("Thomas");
		int cap = name.capacity();
		System.out.println( "cap = " + cap );
		
		String s1 = "The answer";
		StringBuilder sb1 = new StringBuilder(s1);
		sb1.setLength(8);
		int cap2 = sb1.capacity();
		System.out.println( "cap2 = " + cap2 );
		
		String s10 = "JavaGuy@enetis.com";
		String s20 = "";
		for (int i = 0; i < s1.length(); i++)
		{
		    if (s10.charAt(i) == '@')
		    {
		        int ind = s10.indexOf(".");
		        s20 = s10.substring(i, ind);
		        i = s10.length();
		    }
		}
		System.out.println( "s20 = " + s20 );
		
		GregorianCalendar date = new GregorianCalendar(1997, 11, 29);
		date.add(Calendar.MONTH, 2);
		System.out.println( "date = " + date.toString() );
		
		StringBuilder name2 = new StringBuilder("Thomas");
		name2.append(" Berst");
		int cap3 = name2.capacity();
		System.out.println( "cap3 = " + cap3 );
		
		GregorianCalendar start2 = new GregorianCalendar(
                2002, 2, 2, 23, 15, 30);
		Date date2 = start2.getTime();
		DateFormat f = DateFormat.getTimeInstance(DateFormat.SHORT);
		System.out.println(f.format(date2));
		
		String s11 = "Star Wars";
		String s2 = "";
		s2 += "Star Wars";
		if (s11 == s2)
		    System.out.println("equal");
		if (s11.equals(s2))
		    System.out.println("same");
	}
}
