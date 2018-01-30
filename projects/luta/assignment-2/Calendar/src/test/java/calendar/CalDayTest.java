package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
		int day = 12;
		int month = 2;
		int year = 2017;
		GregorianCalendar cal = new GregorianCalendar(year, month, day);

		CalDay calday = new CalDay(cal);

		assertEquals(30, calday.getSizeAppts());
		 assertEquals(12, calday.getDay());
		 assertEquals(02, calday.getMonth());
		 assertEquals(2017, calday.getYear());
		 assertEquals(true, calday.isValid());
		 assertEquals(null, calday.iterator());
		 assertEquals("test", calday.toString());


	 }

	 @Test
	  public void test02()  throws Throwable  {
		 
	 }
//add more unit tests as you needed	
}
