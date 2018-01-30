package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
		 TimeTable table = new TimeTable();


		int day = 12;
		int month = 2;
		int year = 2017;
		GregorianCalendar firstDay = new GregorianCalendar(year, month, day);

		
		GregorianCalendar lastDay = new GregorianCalendar(year, month, day);

		GregorianCalendar today = new GregorianCalendar(2017, 2, 12);
		GregorianCalendar tomorrow = (GregorianCalendar)today.clone();

		LinkedList<Appt> rightnow = new LinkedList<Appt>();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = table.getApptRange(rightnow, today, tomorrow);

		assertEquals(calDays, table.getApptRange(rightnow, today, tomorrow));
	 }
	 /*
	 @Test
	  public void test02()  throws Throwable  {
		 
	 }*/
//add more unit tests as you needed
}
